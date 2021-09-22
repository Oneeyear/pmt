package com.yl.pmt.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.collect.Lists;
import com.yl.pmt.exception.BusinessException;
import com.yl.pmt.mapper.DemandDetailMapper;
import com.yl.pmt.mapper.DemandMapper;
import com.yl.pmt.mapper.UserDetailMapper;
import com.yl.pmt.pojo.dto.DemandDto;
import com.yl.pmt.pojo.dto.DemandQueryDto;
import com.yl.pmt.pojo.po.DemandDetailPo;
import com.yl.pmt.pojo.po.DemandPo;
import com.yl.pmt.pojo.po.UserDetailPo;
import com.yl.pmt.security.util.SecurityUtil;
import com.yl.pmt.service.IDemandService;
import com.yl.pmt.util.EntityConvertUtil;
import com.yl.pmt.util.MapBeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 需求
 *
 * @author pch
 * @date 2021/9/15 7:37 下午
 */
@Service("demandService")
public class DemandService extends ServiceImpl<DemandMapper, DemandPo> implements IDemandService {

	@Autowired
	DemandMapper demandMapper;

	@Autowired
	DemandDetailMapper demandDetailMapper;

	@Autowired
	UserDetailMapper userDetailMapper;

	/**
	 * 新增需求
	 *
	 * @param dto
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public void addDemand(DemandDto dto) {
		Optional.ofNullable(dto).orElseThrow(() -> new BusinessException("数据不能为空！"));
		DemandPo po = (DemandPo) EntityConvertUtil.convert(dto, "Po");
		// 保存操作
		String user = SecurityUtil.getUserName();
		po.setCreateUser(user);
		po.setCreateTime(new Date());
		po.setModifyUser(user);
		po.setModifyTime(new Date());
		boolean flag = this.save(po);
		if (!flag) {
			throw new BusinessException("新增失败！");
		}
	}

	/**
	 * 删除需求
	 *
	 * @param ids
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public void delDemands(List<Integer> ids) {
		String modifyUser = SecurityUtil.getUserName();
		Optional.ofNullable(ids).orElseThrow(() -> new BusinessException("传入数据为空！"));
		UpdateWrapper<DemandPo> updateDemand = new UpdateWrapper<>();
		updateDemand.lambda().set(DemandPo::getLogicState, "N")
				.set(DemandPo::getModifyUser, modifyUser)
				.set(DemandPo::getModifyTime, new Date())
				.in(DemandPo::getId, ids);
		int rd = demandMapper.update(null, updateDemand);
		UpdateWrapper<DemandDetailPo> updateDemandDetail = new UpdateWrapper<>();
		updateDemandDetail.lambda().set(DemandDetailPo::getLogicState, "N")
				.set(DemandDetailPo::getModifyUser, modifyUser)
				.set(DemandDetailPo::getModifyTime, new Date())
				.in(DemandDetailPo::getId, ids);
		int rdd = demandDetailMapper.update(null, updateDemandDetail);
		if (rd == 0 && rdd == 0) {
			throw new BusinessException("删除失败！");
		}
	}

	/**
	 * 查询需求
	 *
	 * @param dto
	 * @return
	 */
	@Override
	public List<Map<String, Object>> listDemands(DemandQueryDto dto) {
		// 更新需求状态
		changeDemandStatus();
		// 当传入值为空时查询全部
		dto = Optional.ofNullable(dto).orElseGet(() -> new DemandQueryDto());
		List<DemandPo> demandPos = demandMapper.selectDemandList(dto);
		// 查询需求日期 用set去重
		Set<Integer> demandIds = demandPos.parallelStream()
				.map(DemandPo::getId).collect(Collectors.toSet());
		QueryWrapper<DemandDetailPo> wrapper = new QueryWrapper();
		wrapper.lambda().eq(DemandDetailPo::getLogicState, "Y").in(DemandDetailPo::getDemandId, demandIds).orderByAsc(DemandDetailPo::getDate);
		List<DemandDetailPo> demandDetailPos = demandDetailMapper.selectList(wrapper);
		Map<Integer, List<DemandDetailPo>> demandDetailGroupMap = demandDetailPos.stream()
				.collect(Collectors.groupingBy(DemandDetailPo::getDemandId));
		demandPos.forEach(items -> {
			Integer demandId = items.getId();
			items.setDemandDetail(demandDetailGroupMap.get(demandId));
		});
		Map<String, List<DemandPo>> demandGroupMap = demandPos.stream()
				.collect(Collectors.groupingBy(DemandPo::getUserCode));
		// 查询人员
		List<UserDetailPo> userDetailPos = userDetailMapper.selectUserList(dto);
		List<Map<String, Object>> list = new ArrayList<>();
		userDetailPos.forEach(items -> {
			Map<String, Object> map = MapBeanUtil.object2Map(items);
			String userCode = items.getUserCode();
			// 不为空
			map.put("demands", demandGroupMap.get(userCode));
			list.add(map);
		});
		return list;
	}

	/**
	 * 修改需求
	 *
	 * @param dto
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public void editDemand(DemandDto dto) {
		Optional.ofNullable(dto).orElseThrow(() -> new BusinessException("数据不能为空！"));
		DemandPo po = (DemandPo) EntityConvertUtil.convert(dto, "Po");
		Integer id = po.getId();
		if (id == null) {
			throw new BusinessException("传入参数为空！");
		}
		// 更新操作
		po.setModifyTime(new Date());
		this.updateById(po);
	}

	/**
	 * 需求状态改变
	 */
	@Transactional(rollbackFor = Exception.class)
	public void changeDemandStatus() {
		// 查询生效的需求
		QueryWrapper<DemandPo> queryWrapper = new QueryWrapper<>();
		queryWrapper.lambda().eq(DemandPo::getLogicState, "Y");
		List<DemandPo> pos = this.list(queryWrapper);
		// 遍历判断需求状态
		List<Integer> normal = Lists.newArrayList(), delay = Lists.newArrayList(), finish = Lists.newArrayList();
		pos.forEach(po -> {
			Date planStartTime = po.getPlanStartTime();
			Date planEndTime = po.getPlanEndTime();
			Date startTime = po.getStartTime();
			Date endTime = po.getEndTime();
			Date testTime = po.getTestTime();
			boolean isDelay = false;
			boolean isNotNull = planStartTime != null && planEndTime != null && startTime != null && endTime == null;
			if (isNotNull) {
				isDelay = startTime.after(planStartTime) || endTime.after(planEndTime);
			}
			if (isDelay) {
				delay.add(po.getId());
			}
			boolean isNormal = false;
			isNotNull = planStartTime != null && planEndTime != null && startTime != null && endTime == null;
			if (isNotNull) {
				isNormal = !startTime.after(planStartTime) && !endTime.after(planEndTime);
			} else {
				isNotNull = planStartTime != null && planEndTime != null && startTime != null;
				if (isNotNull) {
					isNormal = !startTime.after(planStartTime) && endTime == null && !new Date().after(planEndTime);
				}
			}
			if (isNormal) {
				normal.add(po.getId());
			}
			if (testTime != null) {
				finish.add(po.getId());
			}
		});
		String user = SecurityUtil.getUserName();
		UpdateWrapper<DemandPo> updateWrapper = new UpdateWrapper<>();
		updateWrapper.lambda().set(DemandPo::getModifyUser, user).set(DemandPo::getModifyTime, new Date());
		if (!CollectionUtils.isEmpty(delay)) {
			updateWrapper.lambda().set(DemandPo::getStatus, "delay").in(DemandPo::getId, delay);
			demandMapper.update(null, updateWrapper);
		}
		if (!CollectionUtils.isEmpty(normal)) {
			updateWrapper.lambda().set(DemandPo::getStatus, "normal").in(DemandPo::getId, normal);
			demandMapper.update(null, updateWrapper);

		}
		if (!CollectionUtils.isEmpty(finish)) {
			updateWrapper.lambda().set(DemandPo::getStatus, "finish").in(DemandPo::getId, finish);
			demandMapper.update(null, updateWrapper);
		}
	}

}

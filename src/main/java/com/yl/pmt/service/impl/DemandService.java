package com.yl.pmt.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.collect.Lists;
import com.yl.pmt.exception.BusinessException;
import com.yl.pmt.mapper.DemandMapper;
import com.yl.pmt.mapper.UserDetailMapper;
import com.yl.pmt.pojo.dto.DemandDto;
import com.yl.pmt.pojo.dto.DemandQueryDto;
import com.yl.pmt.pojo.po.DemandPo;
import com.yl.pmt.pojo.po.UserDetailPo;
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
		po.setCreateTime(new Date());
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
		Optional.ofNullable(ids).orElseThrow(() -> new BusinessException("传入数据为空！"));
		demandMapper.removeDemands(ids);
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
		Map<String, List<DemandPo>> updateGroupMap = demandPos.stream().collect(Collectors.groupingBy(DemandPo::getUserCode));
		// 查询人员
		List<UserDetailPo> userDetailPos = userDetailMapper.selectUserList(dto);
		List<Map<String, Object>> list = new ArrayList<>();
		userDetailPos.forEach(items -> {
			Map<String, Object> map = MapBeanUtil.object2Map(items);
			String userCode = items.getUserCode();
			// 不为空
			map.put("demands", updateGroupMap.get(userCode));
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
		queryWrapper.eq("logic_state", "Y");
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
		if (!CollectionUtils.isEmpty(delay)) {
			demandMapper.updateDemandStatus(delay, "delay");
		}
		if (!CollectionUtils.isEmpty(normal)) {
			demandMapper.updateDemandStatus(normal, "normal");
		}
		if (!CollectionUtils.isEmpty(finish)) {
			demandMapper.updateDemandStatus(finish, "finish");
		}
	}

}

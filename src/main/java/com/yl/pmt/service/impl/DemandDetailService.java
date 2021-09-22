package com.yl.pmt.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yl.pmt.mapper.DemandDetailMapper;
import com.yl.pmt.pojo.dto.DemandDetailDto;
import com.yl.pmt.pojo.po.DemandDetailPo;
import com.yl.pmt.security.util.SecurityUtil;
import com.yl.pmt.service.IDemandDetailService;
import com.yl.pmt.util.EntityConvertUtil;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

/**
 * 需求每日状态
 *
 * @author pch
 * @date 2021/9/22 1:40 下午
 */
@Service("demandDetailService")
public class DemandDetailService extends ServiceImpl<DemandDetailMapper, DemandDetailPo> implements IDemandDetailService {

	/**
	 * 编辑需求每日状态
	 *
	 * @param dto
	 */
	@Override
	public void editDemandDetail(DemandDetailDto dto) {
		// 查询当天数据是否已经存在
		DemandDetailPo po = (DemandDetailPo) EntityConvertUtil.convert(dto, "Po");
		Date date = po.getDate();
		Integer demandId = po.getDemandId();
		QueryWrapper<DemandDetailPo> wrapper = new QueryWrapper<>();
		wrapper.lambda().eq(DemandDetailPo::getDemandId, demandId).eq(DemandDetailPo::getLogicState, "Y").eq(DemandDetailPo::getDate, date);
		List<DemandDetailPo> pos = this.list(wrapper);
		String user = SecurityUtil.getUserName();
		po.setId(null);
		po.setModifyUser(user);
		po.setModifyTime(new Date());
		po.setLogicState("Y");
		if (CollectionUtils.isEmpty(pos)) {
			po.setCreateUser(user);
			po.setCreateTime(new Date());
			// 如果不存在，则是新增操作
			this.save(po);
		} else {
			// 如果存在，则是更新操作
			UpdateWrapper<DemandDetailPo> updateWrapper = new UpdateWrapper<>();
			updateWrapper.lambda().eq(DemandDetailPo::getDemandId, demandId).eq(DemandDetailPo::getDate, date).eq(DemandDetailPo::getLogicState, "Y");
			this.update(po, updateWrapper);
		}
	}

}

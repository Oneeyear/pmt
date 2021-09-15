package com.yl.pmt.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yl.pmt.exception.BusinessException;
import com.yl.pmt.mapper.DemandMapper;
import com.yl.pmt.pojo.po.DemandPo;
import com.yl.pmt.pojo.vo.DemandVo;
import com.yl.pmt.service.IDemandService;
import com.yl.pmt.util.EntityConvertUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * 需求
 *
 * @author pch
 * @date 2021/9/15 7:37 下午
 */
@Service
public class DemandService extends ServiceImpl<DemandMapper, DemandPo> implements IDemandService {

	@Autowired
	DemandMapper demandMapper;

	/**
	 * 根据姓名查询需求
	 *
	 * @param name
	 * @return
	 */
	@Override
	public List<DemandPo> getDemandByName(String name) {
		QueryWrapper<DemandPo> queryWrapper = new QueryWrapper<>();
		queryWrapper.eq("name", name);
		List<DemandPo> pos = this.list(queryWrapper);
		return pos;
	}

	/**
	 * 新增需求
	 *
	 * @param vo
	 */
	@Override
	public void addDemand(DemandVo vo) {
		Optional.ofNullable(vo).orElseThrow(() -> new BusinessException("数据不能为空！"));
		DemandPo po = (DemandPo) EntityConvertUtil.convert(vo, "Po");
		boolean flag = this.save(po);
		if (!flag) {
			throw new BusinessException("新增失败！");
		}
	}
}

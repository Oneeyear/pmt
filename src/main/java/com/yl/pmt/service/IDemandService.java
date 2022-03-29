package com.yl.pmt.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yl.pmt.domain.dto.DemandDto;
import com.yl.pmt.domain.dto.DemandQueryDto;
import com.yl.pmt.domain.po.DemandPo;

import java.util.List;
import java.util.Map;

/**
 * 需求
 *
 * @author pch
 * @date 2021/9/15 7:36 下午
 */
public interface IDemandService extends IService<DemandPo> {

	/**
	 * 新增需求
	 *
	 * @param dto
	 */
	void addDemand(DemandDto dto);

	/**
	 * 删除需求
	 *
	 * @param ids
	 */
	void delDemands(List<Integer> ids);

	/**
	 * 查询需求
	 *
	 * @param dto
	 * @return
	 */
	List<Map<String, Object>> listDemands(DemandQueryDto dto);

	/**
	 * 修改需求
	 *
	 * @param dto
	 */
	void editDemand(DemandDto dto);
}

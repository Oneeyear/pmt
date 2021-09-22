package com.yl.pmt.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yl.pmt.pojo.dto.DemandDetailDto;
import com.yl.pmt.pojo.po.DemandDetailPo;

/**
 * 需求每日状态
 *
 * @author pch
 * @date 2021/9/22 1:38 下午
 */
public interface IDemandDetailService extends IService<DemandDetailPo> {

	/**
	 * 编辑需求每日状态
	 *
	 * @param dto
	 */
	void editDemandDetail(DemandDetailDto dto);
}

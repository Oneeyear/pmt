package com.yl.pmt.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yl.pmt.pojo.po.DemandPo;
import com.yl.pmt.pojo.vo.DemandVo;

import java.util.List;

/**
 * 需求
 *
 * @author pch
 * @date 2021/9/15 7:36 下午
 */
public interface IDemandService extends IService<DemandPo> {

	/**
	 * 根据姓名查询需求
	 *
	 * @param name
	 * @return
	 */
	List<DemandPo> getDemandByName(String name);

	/**
	 * 新增需求
	 *
	 * @param vo
	 */
	void addDemand(DemandVo vo);

}

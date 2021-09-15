package com.yl.pmt.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yl.pmt.pojo.po.DemoPo;
import com.yl.pmt.pojo.vo.DemoVo;

/**
 * demo_service
 *
 * @author pch
 * @date 2021/9/14 6:15 下午
 */
public interface IDemoService extends IService<DemoPo> {

	/**
	 * 根据ID查询姓名
	 *
	 * @param id
	 * @return
	 */
	String getName(Integer id);

	/**
	 * 新增用户
	 *
	 * @param vo
	 * @return
	 */
	void addUser(DemoVo vo);
}

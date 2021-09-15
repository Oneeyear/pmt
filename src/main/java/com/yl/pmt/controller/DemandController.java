package com.yl.pmt.controller;

import com.yl.pmt.pojo.po.DemandPo;
import com.yl.pmt.pojo.vo.DemandVo;
import com.yl.pmt.result.BaseResponse;
import com.yl.pmt.result.ResponseData;
import com.yl.pmt.service.IDemandService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * demo_controller
 *
 * @author pch
 * @date 2021/9/14 6:35 下午
 */
@Api(tags = "需求列表操作")
@RestController
@RequestMapping("/demand")
public class DemandController extends BaseResponse {

	@Autowired
	IDemandService demandService;

	/**
	 * 查询需求列表
	 *
	 * @return
	 */
	@ApiOperation(value = "查询需求列表", notes = "查询需求列表")
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ResponseData listDemands() {
		List<DemandPo> pos = demandService.list();
		return success("查询成功！", pos);
	}

	/**
	 * 根据ID查询需求
	 *
	 * @return
	 */
	@ApiOperation(value = "根据ID查询用户姓名", notes = "根据ID查询用户姓名")
	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public ResponseData getDemandByName(String name) {
		List<DemandPo> list = demandService.getDemandByName(name);
		return success("查询成功！", list);
	}

	/**
	 * 新增用户
	 *
	 * @return
	 */
	@ApiOperation(value = "新增用户", notes = "新增用户")
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseData addDemand(DemandVo vo) {
		demandService.addDemand(vo);
		return success("新增成功！");
	}

}

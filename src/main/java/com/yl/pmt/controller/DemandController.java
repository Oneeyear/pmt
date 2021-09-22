package com.yl.pmt.controller;

import com.yl.pmt.pojo.dto.DemandDetailDto;
import com.yl.pmt.pojo.dto.DemandDto;
import com.yl.pmt.pojo.dto.DemandQueryDto;
import com.yl.pmt.result.BaseResponse;
import com.yl.pmt.result.ResponseData;
import com.yl.pmt.service.IDemandDetailService;
import com.yl.pmt.service.IDemandService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * demo_controller
 *
 * @author pch
 * @date 2021/9/14 6:35 下午
 */
@Api(tags = "需求列表")
@RestController
@RequestMapping("/demand")
public class DemandController extends BaseResponse {

	@Autowired
	IDemandService demandService;

	@Autowired
	IDemandDetailService demandDetailService;

	/**
	 * 新增需求
	 *
	 * @return
	 */
	@ApiOperation(value = "新增需求", notes = "新增需求")
	@RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public ResponseData add(@Validated DemandDto dto) {
		demandService.addDemand(dto);
		return success("新增成功！");
	}

	/**
	 * 查询需求
	 *
	 * @return
	 */
	@ApiOperation(value = "查询需求", notes = "查询需求列表")
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ResponseData list(DemandQueryDto dto) {
		List<Map<String, Object>> list = demandService.listDemands(dto);
		return success("查询成功！", list);
	}

	/**
	 * 删除需求
	 *
	 * @return
	 */
	@ApiOperation(value = "删除需求", notes = "删除需求")
	@RequestMapping(value = "/del", method = RequestMethod.DELETE)
	public ResponseData del(@RequestParam(value = "ids") List<Integer> ids) {
		demandService.delDemands(ids);
		return success("删除成功！");
	}

	/**
	 * 修改需求
	 *
	 * @return
	 */
	@ApiOperation(value = "修改需求", notes = "修改需求")
	@RequestMapping(value = "/edit", method = RequestMethod.PUT)
	public ResponseData edit(@Validated DemandDto dto) {
		demandService.editDemand(dto);
		return success("修改成功！");
	}

	/**
	 * 编辑需求每日状态
	 *
	 * @return
	 */
	@ApiOperation(value = "编辑需求每日状态", notes = "编辑需求每日状态")
	@RequestMapping(value = "/detail/edit", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public ResponseData editDetail(@Validated DemandDetailDto dto) {
		demandDetailService.editDemandDetail(dto);
		return success("编辑成功！");
	}

}

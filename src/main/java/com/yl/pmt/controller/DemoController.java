package com.yl.pmt.controller;

import com.yl.pmt.pojo.po.DemoPo;
import com.yl.pmt.pojo.vo.DemoVo;
import com.yl.pmt.result.BaseResponse;
import com.yl.pmt.result.ResponseData;
import com.yl.pmt.service.IDemoService;
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
@Api(tags = "demo_controller")
@RestController
@RequestMapping("/user")
public class DemoController extends BaseResponse {

	@Autowired
	IDemoService demoService;

	/**
	 * 查询用户列表
	 *
	 * @return
	 */
	@ApiOperation(value = "获取用户列表", notes = "获取用户列表")
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ResponseData listUserInfos() {
		List<DemoPo> demoPos = demoService.list();
		return success("查询成功！", demoPos);
	}

	/**
	 * 根据ID查询用户姓名
	 *
	 * @return
	 */
	@ApiOperation(value = "根据ID查询用户姓名", notes = "根据ID查询用户姓名")
	@RequestMapping(value = "/name", method = RequestMethod.GET)
	public ResponseData getUserName(Integer id) {
		String name = demoService.getName(id);
		return success("查询成功！", name);
	}

	/**
	 * 新增用户
	 *
	 * @return
	 */
	@ApiOperation(value = "新增用户", notes = "新增用户")
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseData getUserName(DemoVo vo) {
		demoService.addUser(vo);
		return success("新增成功！");
	}

}

package com.yl.pmt.controller;

import com.yl.pmt.pojo.dto.UserDto;
import com.yl.pmt.pojo.po.UserPo;
import com.yl.pmt.result.BaseResponse;
import com.yl.pmt.result.ResponseData;
import com.yl.pmt.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 用户
 *
 * @author pch
 * @date 2021/9/16 3:35 下午
 */
@Api(tags = "用户信息")
@RestController
@RequestMapping("/user")
public class UserController extends BaseResponse {

	@Autowired
	IUserService userService;

	/**
	 * 新增用户
	 *
	 * @return
	 */
	@ApiOperation(value = "新增用户", notes = "新增用户")
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseData addUser(@Validated UserDto dto) {
		userService.addUser(dto);
		return success("新增成功！");
	}

	/**
	 * 查询用户
	 *
	 * @return
	 */
	@ApiOperation(value = "查询用户", notes = "查询用户")
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ResponseData listUsers() {
		List<UserPo> pos = userService.listUsers();
		return success("查询成功！", pos);
	}

	/**
	 * 删除用户
	 *
	 * @return
	 */
	@ApiOperation(value = "删除用户", notes = "删除用户")
	@RequestMapping(value = "/del", method = RequestMethod.DELETE)
	public ResponseData addUsers(String ids) {
		userService.delUsers(ids);
		return success("删除成功！");
	}

}

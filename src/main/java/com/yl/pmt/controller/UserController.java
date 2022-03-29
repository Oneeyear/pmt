package com.yl.pmt.controller;

import com.yl.pmt.domain.dto.UserDetailDto;
import com.yl.pmt.domain.po.UserDetailPo;
import com.yl.pmt.domain.vo.UserDetailVo;
import com.yl.pmt.result.ResponseData;
import com.yl.pmt.service.IUserDetailService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
public class UserController extends BaseController {

	@Autowired
	IUserDetailService userService;

	/**
	 * 新增用户
	 *
	 * @return
	 */
	@ApiOperation(value = "新增用户", notes = "新增用户")
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseData add(@Validated UserDetailDto dto) {
		String msg = userService.addUser(dto);
		return success(msg);
	}

	/**
	 * 查询用户
	 *
	 * @return
	 */
	@ApiOperation(value = "查询用户", notes = "查询用户")
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ResponseData list() {
		List<UserDetailPo> pos = userService.listUsers();
		return success("查询成功！", pos);
	}

	/**
	 * 删除用户
	 *
	 * @return
	 */
	@ApiOperation(value = "删除用户", notes = "删除用户")
	@RequestMapping(value = "/del", method = RequestMethod.DELETE)
	public ResponseData del(@RequestParam(value = "ids") List<Integer> ids) {
		userService.delUsers(ids);
		return success("删除成功！");
	}

	/**
	 * 用户信息
	 *
	 * @return
	 * @author pch
	 * @CreateTime 2021/6/2 14:52
	 */
	@ApiOperation(value = "获取用户信息")
	@RequestMapping(value = "/info", method = RequestMethod.GET)
	public ResponseData userInfo() {
		UserDetailVo vo = userService.getUserInfo();
		return success("用户端信息", vo);
	}

	/**
	 * 修改用户
	 *
	 * @return
	 * @author pch
	 * @CreateTime 2021/6/2 14:52
	 */
	@ApiOperation(value = "获取用户信息")
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ResponseData edit(UserDetailDto dto) {
		userService.edit(dto);
		return success("修改成功！");
	}

}

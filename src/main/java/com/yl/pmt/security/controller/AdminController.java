package com.yl.pmt.security.controller;

import com.yl.pmt.security.pojo.Menu;
import com.yl.pmt.security.pojo.Role;
import com.yl.pmt.security.pojo.SelfUser;
import com.yl.pmt.security.pojo.User;
import com.yl.pmt.security.service.IMenuService;
import com.yl.pmt.security.service.IRoleService;
import com.yl.pmt.security.service.IUserService;
import com.yl.pmt.security.util.ResultUtil;
import com.yl.pmt.security.util.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 管理端
 *
 * @Author pch
 * @CreateTime 2020/10/2 14:16
 */
@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private IUserService sysUserService;
	@Autowired
	private IRoleService sysRoleService;
	@Autowired
	private IMenuService sysMenuService;

	/**
	 * 管理端信息
	 *
	 * @Author pch
	 * @CreateTime 2020/10/2 14:22
	 * @Return Map<String, Object> 返回数据MAP
	 */
	@PreAuthorize("hasRole('ADMIN')")
	@RequestMapping(value = "/info", method = RequestMethod.GET)
	public Map<String, Object> userLogin() {
		Map<String, Object> result = new HashMap<>();
		SelfUser userDetails = SecurityUtil.getUserInfo();
		result.put("title", "管理端信息");
		result.put("data", userDetails);
		return ResultUtil.resultSuccess(result);
	}

	/**
	 * 拥有ADMIN或者USER角色可以访问
	 *
	 * @Author pch
	 * @CreateTime 2020/10/2 14:22
	 * @Return Map<String, Object> 返回数据MAP
	 */
	@PreAuthorize("hasAnyRole('ADMIN','USER')")
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public Map<String, Object> list() {
		Map<String, Object> result = new HashMap<>();
		List<User> userList = sysUserService.list();
		result.put("title", "拥有用户或者管理员角色都可以查看");
		result.put("data", userList);
		return ResultUtil.resultSuccess(result);
	}

	/**
	 * 拥有ADMIN和USER角色可以访问
	 *
	 * @Author pch
	 * @CreateTime 2020/10/2 14:22
	 * @Return Map<String, Object> 返回数据MAP
	 */
	@PreAuthorize("hasRole('ADMIN') and hasRole('USER')")
	@RequestMapping(value = "/menuList", method = RequestMethod.GET)
	public Map<String, Object> menuList() {
		Map<String, Object> result = new HashMap<>();
		List<Menu> menuList = sysMenuService.list();
		result.put("title", "拥有用户和管理员角色都可以查看");
		result.put("data", menuList);
		return ResultUtil.resultSuccess(result);
	}


	/**
	 * 拥有sys:user:info权限可以访问
	 * hasPermission 第一个参数是请求路径 第二个参数是权限表达式
	 *
	 * @Author pch
	 * @CreateTime 2020/10/2 14:22
	 * @Return Map<String, Object> 返回数据MAP
	 */
	@PreAuthorize("hasPermission('/admin/userList','sys:user:info')")
	@RequestMapping(value = "/userList", method = RequestMethod.GET)
	public Map<String, Object> userList() {
		Map<String, Object> result = new HashMap<>();
		List<User> userList = sysUserService.list();
		result.put("title", "拥有sys:user:info权限都可以查看");
		result.put("data", userList);
		return ResultUtil.resultSuccess(result);
	}


	/**
	 * 拥有ADMIN角色和sys:role:info权限可以访问
	 *
	 * @Author pch
	 * @CreateTime 2020/10/2 14:22
	 * @Return Map<String, Object> 返回数据MAP
	 */
	@PreAuthorize("hasRole('ADMIN') and hasPermission('/admin/adminRoleList','sys:role:info')")
	@RequestMapping(value = "/adminRoleList", method = RequestMethod.GET)
	public Map<String, Object> adminRoleList() {
		Map<String, Object> result = new HashMap<>();
		List<Role> roleList = sysRoleService.list();
		result.put("title", "拥有ADMIN角色和sys:role:info权限可以访问");
		result.put("data", roleList);
		return ResultUtil.resultSuccess(result);
	}
}

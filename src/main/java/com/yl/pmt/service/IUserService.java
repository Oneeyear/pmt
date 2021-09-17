package com.yl.pmt.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yl.pmt.pojo.dto.UserDto;
import com.yl.pmt.pojo.po.UserPo;

import java.util.List;

/**
 * 用户信息
 *
 * @author pch
 * @date 2021/9/16 3:38 下午
 */
public interface IUserService extends IService<UserPo> {

	/**
	 * 新增用户
	 *
	 * @param dto
	 */
	void addUser(UserDto dto);

	/**
	 * 查询用户
	 *
	 * @return
	 */
	List<UserPo> listUsers();

	/**
	 * 删除用户
	 *
	 * @param ids
	 */
	void delUsers(List<Integer> ids);
}

package com.yl.pmt.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yl.pmt.domain.dto.UserDetailDto;
import com.yl.pmt.domain.po.UserDetailPo;
import com.yl.pmt.domain.vo.UserDetailVo;

import java.util.List;

/**
 * 用户信息
 *
 * @author pch
 * @date 2021/9/16 3:38 下午
 */
public interface IUserDetailService extends IService<UserDetailPo> {

	/**
	 * 新增用户
	 *
	 * @param dto
	 * @return
	 */
	String addUser(UserDetailDto dto);

	/**
	 * 查询用户
	 *
	 * @return
	 */
	List<UserDetailPo> listUsers();

	/**
	 * 删除用户
	 *
	 * @param ids
	 */
	void delUsers(List<Integer> ids);

	/**
	 * 获取用户信息
	 *
	 * @return
	 */
	UserDetailVo getUserInfo();

	/**
	 * 修改用户信息
	 *
	 * @param dto
	 */
	void edit(UserDetailDto dto);
}

package com.yl.pmt.security.service.impl;

import com.yl.pmt.security.pojo.SelfUser;
import com.yl.pmt.security.pojo.User;
import com.yl.pmt.security.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * SpringSecurity用户的业务实现
 *
 * @Author pch
 * @CreateTime 2020/10/1 17:21
 */
@Component
public class SelfUserDetailsService implements UserDetailsService {

	@Autowired
	private IUserService sysUserService;

	/**
	 * 查询用户信息
	 *
	 * @Author pch
	 * @CreateTime 2020/9/13 17:23
	 * @Param username  用户名
	 * @Return UserDetails SpringSecurity用户信息
	 */
	@Override
	public SelfUser loadUserByUsername(String account) throws UsernameNotFoundException {
		// 查询用户信息
		User user = sysUserService.selectUserByAccount(account);
		if (user != null) {
			// 组装参数
			SelfUser selfUser = new SelfUser();
			BeanUtils.copyProperties(user, selfUser);
			return selfUser;
		}
		return null;
	}
}

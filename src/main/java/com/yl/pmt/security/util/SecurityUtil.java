package com.yl.pmt.security.util;

import com.yl.pmt.security.pojo.SelfUser;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Security工具类
 *
 * @Author pch
 * @CreateTime 2020/10/2 13:16
 */
public class SecurityUtil {

	/**
	 * 私有化构造器
	 */
	private SecurityUtil() {
	}

	/**
	 * 获取当前用户信息
	 */
	public static SelfUser getUserInfo() {
		SelfUser userDetails = (SelfUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return userDetails;
	}

	/**
	 * 获取当前用户ID
	 */
	public static Long getUserId() {
		return getUserInfo().getUserId();
	}

	/**
	 * 获取当前用户账号
	 */
	public static String getUserName() {
		return getUserInfo().getUsername();
	}

	/**
	 * 获取当前用户ID
	 */
	public static String getAccount() {
		return getUserInfo().getAccount();
	}

	/**
	 * 获取当前用户ID
	 */
	public static String getUserCode() {
		return getUserInfo().getUserCode();
	}
}

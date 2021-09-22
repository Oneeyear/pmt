package com.yl.pmt.security.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 系统用户实体
 *
 * @Author pch
 * @CreateTime 2020/9/14 15:57
 */
@Data
@TableName("sys_user")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 用户ID
	 */
	@TableId
	private Long userId;

	/**
	 * 用户名
	 */
	private String account;

	/**
	 * 密码
	 */
	private String password;

	/**
	 * 用户唯一标识
	 */
	private String userCode;

	/**
	 * 状态:NORMAL正常  PROHIBIT禁用
	 */
	private String status;
}

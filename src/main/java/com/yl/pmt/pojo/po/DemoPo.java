package com.yl.pmt.pojo.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * demo_po
 *
 * @author pch
 * @date 2021/9/14 6:27 下午
 */
@Data
@TableName("sys_user")
public class DemoPo extends BasePo {

	@TableId(type = IdType.AUTO)
	private Integer id;

	/**
	 * 姓名
	 */
	private String name;

	/**
	 * 手机号
	 */
	private String phone;

	/**
	 * 邮箱
	 */
	private String mail;

	/**
	 * 地址
	 */
	private String address;

	/**
	 * 公司
	 */
	private String company;

	/**
	 * 备注
	 */
	private String remark;

	/**
	 * 启用状态
	 */
	private String enable;

	/**
	 * 逻辑状态
	 */
	private String logic;

}

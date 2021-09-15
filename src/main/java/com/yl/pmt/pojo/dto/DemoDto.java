package com.yl.pmt.pojo.dto;

import lombok.Data;

/**
 * demo_dto
 *
 * @author pch
 * @date 2021/9/14 11:55 下午
 */
@Data
public class DemoDto extends BaseDto {

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

}

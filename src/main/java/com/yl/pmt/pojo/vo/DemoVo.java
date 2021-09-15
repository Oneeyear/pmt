package com.yl.pmt.pojo.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * demo_vo
 *
 * @author pch
 * @date 2021/9/14 6:38 下午
 */
@Data
@ApiModel(value = "实体demo")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DemoVo extends BaseVo {


	@ApiModelProperty(value = "id")
	private Integer id;

	/**
	 * 姓名
	 */
	@ApiModelProperty(value = "姓名")
	private String name;

	/**
	 * 手机号
	 */
	@ApiModelProperty(value = "手机号")
	private String phone;

	/**
	 * 邮箱
	 */
	@ApiModelProperty(value = "邮箱")
	private String mail;

	/**
	 * 地址
	 */
	@ApiModelProperty(value = "地址")
	private String address;

	/**
	 * 公司
	 */
	@ApiModelProperty(value = "公司")
	private String company;

	/**
	 * 备注
	 */
	@ApiModelProperty(value = "备注")
	private String remark;

}

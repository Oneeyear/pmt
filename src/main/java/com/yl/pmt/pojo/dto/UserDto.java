package com.yl.pmt.pojo.dto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * 用户新增传入参数
 *
 * @author pch
 * @date 2021/9/16 3:03 下午
 */
@Api(value = "需求实体")
@Data
public class UserDto extends BaseDto {

	/**
	 * 主键
	 */
	@ApiModelProperty(value = "主键")
	private Integer id;

	/**
	 * 用户名
	 */
	@NotEmpty(message = "用户名不能为空")
	@Size(max = 50, message = "用户名不能超过50位")
	@ApiModelProperty(value = "用户名")
	private String name;

	/**
	 * 部门（基础资料/服务质量...）
	 */
	@NotEmpty(message = "部门名称不能为空")
	@Size(max = 50, message = "部门名称不能超过50位")
	@ApiModelProperty(value = "部门（基础资料/服务质量...）")
	private String dept;

	/**
	 * 地区（上海/深圳）
	 */
	@NotEmpty(message = "地区不能为空")
	@ApiModelProperty(value = "地区（上海/深圳）")
	private String area;

	/**
	 * 备注
	 */
	@ApiModelProperty(value = "备注")
	private String remark;

	/**
	 * 启用状态
	 */
	@ApiModelProperty(value = "启用状态")
	private String status;

}

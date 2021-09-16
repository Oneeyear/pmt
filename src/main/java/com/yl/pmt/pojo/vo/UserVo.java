package com.yl.pmt.pojo.vo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 用户实体类
 *
 * @author pch
 * @date 2021/9/16 3:03 下午
 */
@Api(value = "需求实体")
@Data
public class UserVo extends BaseVo {

	/**
	 * 主键
	 */
	@ApiModelProperty(value = "主键")
	private Integer id;

	/**
	 * 用户ID
	 */
	@ApiModelProperty(value = "用户ID")
	private Integer userId;

	/**
	 * 部门（基础资料/服务质量...）
	 */
	@ApiModelProperty(value = "部门（基础资料/服务质量...）")
	private String dept;

	/**
	 * 地区（上海/深圳）
	 */
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
	private String enable;

}

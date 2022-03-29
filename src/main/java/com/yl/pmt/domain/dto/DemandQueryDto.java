package com.yl.pmt.domain.dto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * 需求查询传入参数
 *
 * @author pch
 * @date 2021/9/16 8:14 下午
 */
@Api(value = "需求查询实体")
@Data
public class DemandQueryDto {

	/**
	 * 用户唯一标识
	 */
	@ApiModelProperty(value = "用户唯一标识")
	private String userCode;

	/**
	 * 用户名
	 */
	@ApiModelProperty(value = "用户名")
	private String name;

	/**
	 * 需求
	 */
	@ApiModelProperty(value = "需求")
	private String demand;

	/**
	 * 需求类型
	 */
	@ApiModelProperty(value = "需求类型")
	private String demandType;

	/**
	 * 地区（上海/深圳）
	 */
	@NotEmpty(message = "地区不能为空")
	@ApiModelProperty(value = "地区（上海/深圳）")
	private String area;

	/**
	 * 项目组
	 */
	@ApiModelProperty(value = "项目组")
	private String dept;

	/**
	 * 开始时间
	 */
	@ApiModelProperty(value = "开始时间")
	private String startTime;

	/**
	 * 结束时间
	 */
	@ApiModelProperty(value = "结束时间")
	private String endTime;

	/**
	 * 状态 normal-正常 delay-延期 suspend-挂起 finish-完成
	 */
	@ApiModelProperty(value = "状态 normal-正常 delay-延期 suspend-挂起 finish-完成")
	private String status;

}

package com.yl.pmt.pojo.vo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 需求实体
 *
 * @author pch
 * @date 2021/9/15 7:04 下午
 */
@Api(value = "需求实体")
@Data
public class DemandVo extends BaseVo{
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
	 * 计划开始时间
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@ApiModelProperty(value = "计划开始时间")
	private Date planStartTime;

	/**
	 * 计划结束时间
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@ApiModelProperty(value = "计划结束时间")
	private Date planEndTime;

	/**
	 * 计划提测时间
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@ApiModelProperty(value = "计划提测时间")
	private Date planTestTime;

	/**
	 * 计划上线时间
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@ApiModelProperty(value = "计划上线时间")
	private Date planOnlineTime;

	/**
	 * 实际开始时间
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@ApiModelProperty(value = "实际开始时间")
	private Date startTime;

	/**
	 * 实际结束时间
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@ApiModelProperty(value = "实际结束时间")
	private Date endTime;

	/**
	 * 实际提测时间
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@ApiModelProperty(value = "实际提测时间")
	private Date testTime;

	/**
	 * 备注
	 */
	@ApiModelProperty(value = "备注")
	private String remark;

}

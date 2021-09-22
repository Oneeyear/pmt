package com.yl.pmt.pojo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * 需求新增传入参数
 *
 * @author pch
 * @date 2021/9/15 7:04 下午
 */
@Api(value = "需求实体")
@Data
public class DemandDto extends BaseDto {

	/**
	 * 主键
	 */
	@ApiModelProperty(value = "主键")
	private Integer id;

	/**
	 * 用户唯一标识
	 */
	@NotEmpty(message = "用户唯一标识不能为空")
	@ApiModelProperty(value = "用户唯一标识")
	private String userCode;

	/**
	 * 需求
	 */
	@NotEmpty(message = "需求名不能为空")
	@ApiModelProperty(value = "需求")
	private String demand;

	/**
	 * 需求类型
	 */
	@NotEmpty(message = "需求类型不能为空")
	@ApiModelProperty(value = "需求类型")
	private String demandType;

	/**
	 * 计划开始时间
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	@ApiModelProperty(value = "计划开始时间")
	private Date planStartTime;

	/**
	 * 计划结束时间
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	@ApiModelProperty(value = "计划结束时间")
	private Date planEndTime;

	/**
	 * 计划提测时间
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	@ApiModelProperty(value = "计划提测时间")
	private Date planTestTime;

	/**
	 * 计划上线时间
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	@ApiModelProperty(value = "计划上线时间")
	private Date planOnlineTime;

	/**
	 * 实际开始时间
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	@ApiModelProperty(value = "实际开始时间")
	private Date startTime;

	/**
	 * 实际结束时间
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	@ApiModelProperty(value = "实际结束时间")
	private Date endTime;

	/**
	 * 实际提测时间
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	@ApiModelProperty(value = "实际提测时间")
	private Date testTime;

	/**
	 * 备注
	 */
	@ApiModelProperty(value = "备注")
	private String remark;

	/**
	 * 状态 normal-正常 delay-延期 suspend-挂起 finish-完成
	 */
	@ApiModelProperty(value = "状态 normal-正常 delay-延期 suspend-挂起 finish-完成")
	private String status;

}

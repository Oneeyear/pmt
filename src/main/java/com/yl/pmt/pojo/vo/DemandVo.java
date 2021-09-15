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
public class DemandVo {
	/**
	 * 主键
	 */
	@ApiModelProperty(value = "主键")
	private Integer id;

	/**
	 * 姓名
	 */
	@ApiModelProperty(value = "姓名")
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

	/**
	 * 逻辑状态
	 */
	@ApiModelProperty(value = "逻辑状态")
	private String logicalState;

	/**
	 * 创建人
	 */
	@ApiModelProperty(value = "创建人")
	private String createUser;

	/**
	 * 创建时间
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@ApiModelProperty(value = "创建时间")
	private Date createTime;

	/**
	 * 修改人
	 */
	@ApiModelProperty(value = "修改人")
	private String modifyUser;

	/**
	 * 修改时间
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@ApiModelProperty(value = "修改时间")
	private Date modifyTime;
}

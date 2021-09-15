package com.yl.pmt.pojo.dto;

import lombok.Data;

import java.util.Date;

/**
 * 需求实体
 *
 * @author pch
 * @date 2021/9/15 7:04 下午
 */
@Data
public class DemandDto {

	/**
	 * 主键
	 */
	private Integer id;

	/**
	 * 姓名
	 */
	private String name;

	/**
	 * 需求
	 */
	private String demand;

	/**
	 * 需求类型
	 */
	private String demandType;

	/**
	 * 计划开始时间
	 */
	private Date planStartTime;

	/**
	 * 计划结束时间
	 */
	private Date planEndTime;

	/**
	 * 计划提测时间
	 */
	private Date planTestTime;

	/**
	 * 计划上线时间
	 */
	private Date planOnlineTime;

	/**
	 * 实际开始时间
	 */
	private Date startTime;

	/**
	 * 实际结束时间
	 */
	private Date endTime;

	/**
	 * 实际提测时间
	 */
	private Date testTime;

	/**
	 * 备注
	 */
	private String remark;

	/**
	 * 逻辑状态
	 */
	private String logicalState;

	/**
	 * 创建人
	 */
	private String createUser;

	/**
	 * 创建时间
	 */
	private Date createTime;

	/**
	 * 修改人
	 */
	private String modifyUser;

	/**
	 * 修改时间
	 */
	private Date modifyTime;
}

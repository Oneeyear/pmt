package com.yl.pmt.pojo.vo;

import lombok.Data;

import java.util.Date;

/**
 * 需求实体
 *
 * @author pch
 * @date 2021/9/15 7:04 下午
 */
@Data
public class DemandVo extends BaseVo {

	/**
	 * 主键
	 */
	private Integer id;

	/**
	 * 用户唯一标识
	 */
	private String userCode;

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
	 * 状态 normal-正常 delay-延期 suspend-挂起 finish-完成
	 */
	private String status;

}

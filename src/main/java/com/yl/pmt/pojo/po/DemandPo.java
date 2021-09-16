package com.yl.pmt.pojo.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * 需求实体
 *
 * @author pch
 * @date 2021/9/15 7:04 下午
 */
@Data
@Accessors(chain = true)
@TableName(value = "demand")
public class DemandPo extends BasePo {
	/**
	 * 主键
	 */
	@TableId(type = IdType.AUTO)
	private Integer id;

	/**
	 * 用户ID
	 */
	private Integer userId;

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
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date planStartTime;

	/**
	 * 计划结束时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date planEndTime;

	/**
	 * 计划提测时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date planTestTime;

	/**
	 * 计划上线时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date planOnlineTime;

	/**
	 * 实际开始时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date startTime;

	/**
	 * 实际结束时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date endTime;

	/**
	 * 实际提测时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
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

package com.yl.pmt.domain.vo;

import lombok.Data;

import java.util.Date;

/**
 * 需求每日完成详情
 *
 * @author pch
 * @date 2021/9/22 1:34 下午
 */
@Data
public class DemandDetailVo extends BaseVo {

	/**
	 * 主键
	 */
	private Integer id;

	/**
	 * 需求ID
	 */
	private Integer demandId;

	/**
	 * 操作日期
	 */
	private Date date;

	/**
	 * 完成状态
	 */
	private String status;

	/**
	 * 备注
	 */
	private String remark;

}

package com.yl.pmt.pojo.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * 需求每日完成详情
 *
 * @author pch
 * @date 2021/9/22 11:41 上午
 */
@Data
@Accessors(chain = true)
@TableName(value = "demand_detail")
public class DemandDetailPo extends BasePo {

	/**
	 * 主键
	 */
	@TableId(type = IdType.AUTO)
	private Integer id;

	/**
	 * 需求ID
	 */
	private Integer demandId;

	/**
	 * 操作日期
	 */
	@JsonFormat(pattern = "yyyy-MM-dd")
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

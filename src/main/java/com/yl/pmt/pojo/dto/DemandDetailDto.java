package com.yl.pmt.pojo.dto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * 需求每日完成详情
 *
 * @author pch
 * @date 2021/9/22 11:41 上午
 */
@Data
@Api(value = "需求单日完成详情")
public class DemandDetailDto extends BaseDto {

	/**
	 * 主键
	 */
	@ApiModelProperty(value = "主键")
	private Integer id;

	/**
	 * 需求ID
	 */
	@ApiModelProperty(value = "需求ID")
	private Integer demandId;

	/**
	 * 日期
	 */
	@ApiModelProperty(value = "日期")
	@NotNull(message = "日期不能为空")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date date;

	/**
	 * 日常状态
	 */
	@ApiModelProperty(value = "当日状态 normal-正常 risky-有风险")
	private String status;

	/**
	 * 备注
	 */
	@ApiModelProperty(value = "备注")
	private String remark;

}

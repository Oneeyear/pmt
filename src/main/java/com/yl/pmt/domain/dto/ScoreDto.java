package com.yl.pmt.domain.dto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotEmpty;

/**
 * 美术成绩
 *
 * @author pch
 * @date 2021/10/22 8:53 下午
 */
@EqualsAndHashCode(callSuper = true)
@Api(value = "美术成绩实体")
@Data
public class ScoreDto extends BaseDto {

	@ApiModelProperty(value = "主键")
	private Integer id;

	@ApiModelProperty(value = "姓名")
	@NotEmpty(message = "姓名不能为空")
	private String name;

	@ApiModelProperty(value = "考生号")
	@NotEmpty(message = "考生号不能为空")
	private String code;

	@ApiModelProperty(value = "素描")
	private Integer sketchScore;

	@ApiModelProperty(value = "色彩")
	private Integer colorScore;

	@ApiModelProperty(value = "速写")
	private Integer writeScore;

	@ApiModelProperty(value = "总成绩")
	private Integer totalScore;

}

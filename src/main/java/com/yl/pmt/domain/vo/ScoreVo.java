package com.yl.pmt.domain.vo;

import lombok.Data;

/**
 * 美术成绩
 *
 * @author pch
 * @date 2021/10/22 8:57 下午
 */
@Data
public class ScoreVo extends BaseVo {

	/**
	 * 主键
	 */
	private Integer id;

	/**
	 * 姓名
	 */
	private String name;

	/**
	 * 考生号
	 */
	private String code;

	/**
	 * 素描
	 */
	private Integer sketchScore;

	/**
	 * 色彩
	 */
	private Integer colorScore;

	/**
	 * 速写
	 */
	private Integer writeScore;

	/**
	 * 总成绩
	 */
	private Integer totalScore;
}

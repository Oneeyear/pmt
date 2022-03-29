package com.yl.pmt.domain.po;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.Api;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 美术成绩
 *
 * @author pch
 * @date 2021/10/22 8:55 下午
 */
@Api(value = "美术成绩实体")
@Data
@Accessors(chain = true)
@TableName(value = "score")
public class ScorePo extends BasePo {

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

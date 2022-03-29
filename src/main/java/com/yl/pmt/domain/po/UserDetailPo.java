package com.yl.pmt.domain.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 用户实体类
 *
 * @author pch
 * @date 2021/9/16 3:03 下午
 */
@Data
@Accessors(chain = true)
@TableName(value = "sys_user_detail")
public class UserDetailPo extends BasePo {

	/**
	 * 主键
	 */
	@TableId(type = IdType.AUTO)
	private Integer id;

	/**
	 * 用户名
	 */
	private String name;

	/**
	 * 部门（基础资料/服务质量...）
	 */
	private String dept;

	/**
	 * 地区（上海/深圳）
	 */
	private String area;

	/**
	 * 备注
	 */
	private String remark;

	/**
	 * 用户唯一标识
	 */
	private String userCode;

}

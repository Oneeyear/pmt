package com.yl.pmt.pojo.po;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @author pch
 * @date 2021/9/15 9:20 上午
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BasePo implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 逻辑状态
	 */
	private String logicState;

	/**
	 * 创建人
	 */
	private String createUser;

	/**
	 * 创建时间
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createTime;

	/**
	 * 修改人
	 */
	private String modifyUser;

	/**
	 * 修改时间
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date modifyTime;

}

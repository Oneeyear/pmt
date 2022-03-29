package com.yl.pmt.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @author pch
 * @date 2021/9/15 9:19 上午
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseDto implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 逻辑状态
	 */
	@ApiModelProperty(value = "逻辑状态")
	private String logicState;

	/**
	 * 创建人
	 */
	@ApiModelProperty(value = "创建人")
	private String createUser;

	/**
	 * 创建时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@ApiModelProperty(value = "创建时间")
	private Date createTime;

	/**
	 * 修改人
	 */
	@ApiModelProperty(value = "修改人")
	private String modifyUser;

	/**
	 * 修改时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@ApiModelProperty(value = "修改时间")
	private Date modifyTime;

}

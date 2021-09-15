package com.yl.pmt.result;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * @author pch
 * @date 2021/5/26 7:02 下午
 */
@Data
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class ResponseData<T> {

	private Integer count;

	/**
	 * 统一返回码
	 */
	private Integer code;

	/**
	 * 统一错误消息
	 */
	private String msg;

	/**
	 * 结果对象
	 */
	private T data;

	public ResponseData() {
	}

	public ResponseData(Integer code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public ResponseData(Integer code, String msg, T data) {
		this.code = code;
		this.msg = msg;
		this.data = data;
	}

	public ResponseData(Integer code, String msg, T data, Integer count) {
		this.code = code;
		this.msg = msg;
		this.data = data;
		this.count = count;
	}


}

package com.yl.pmt.exception;

import com.yl.pmt.result.ResponseData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * DefaultExceptionHandler:自定义异常处理器
 *
 * @author pch
 * @date 2021/5/26 7:02 下午
 */
@Slf4j
@ControllerAdvice
public class DefaultException {

	/**
	 * 业务异常
	 */
	@ExceptionHandler({BusinessException.class})
	@ResponseBody
	public ResponseData BusinessException(BusinessException e) {
		ResponseData responseData = new ResponseData<>();
		Integer code = e.getCode();
		code = code != null ? code : 500;
		responseData.setCode(code);
		responseData.setMsg(e.getMessage());
		responseData.setData(null);
		return responseData;
	}

	/**
	 * 数据校验异常
	 */
	@ExceptionHandler({BindException.class})
	@ResponseBody
	public ResponseData BindException(BindException e) {
		ResponseData responseData = new ResponseData<>();
		responseData.setCode(500);
		responseData.setMsg(e.getFieldError().getDefaultMessage());
		responseData.setData(null);
		return responseData;
	}

	/**
	 * 异常统一处理(最后的异常处理)
	 */
	@ExceptionHandler({Exception.class})
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public ResponseData allException(Exception e) {
		ResponseData responseData = new ResponseData<>();
		responseData.setCode(500);
		responseData.setMsg("系统异常" + e.getMessage());
		responseData.setData(null);
		return responseData;
	}


}

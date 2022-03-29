package com.yl.pmt.controller;

import com.github.pagehelper.PageInfo;
import com.yl.pmt.result.ResponseData;

/**
 * BaseController:返回的工具类,主要是方便返回的写法
 * 单纯的返回工具类,直接放在这个包
 *
 * @author pch
 * @date 2021/5/26 7:02 下午
 */
public class BaseController {
	/**
	 * 返回成功描述
	 *
	 * @param msg
	 * @return
	 */
	public static ResponseData success(String msg) {
		ResponseData ResponseData = new ResponseData();
		ResponseData.setCode(200);
		ResponseData.setMsg(msg);
		ResponseData.setData(null);
		return ResponseData;
	}

	/**
	 * 返回成功描述和数据详情
	 *
	 * @param msg
	 * @param data
	 * @return
	 */
	public static ResponseData success(String msg, Object data) {
		ResponseData ResponseData = new ResponseData();
		if (data instanceof PageInfo) {
			PageInfo page = (PageInfo) data;
			ResponseData.setData(page.getList());
			ResponseData.setCount((int) page.getTotal());
		} else {
			ResponseData.setData(data);
		}
		ResponseData.setCode(200);
		ResponseData.setMsg(msg);
		return ResponseData;
	}

	/**
	 * 返回成功描述和数据详情
	 *
	 * @param msg
	 * @param data
	 * @return
	 */
	public static ResponseData success(String msg, Object data, Integer count) {
		ResponseData ResponseData = new ResponseData();
		ResponseData.setCode(200);
		ResponseData.setMsg(msg);
		ResponseData.setData(data);
		ResponseData.setCount(count);
		return ResponseData;
	}

	/**
	 * 返回失败的带code的异常
	 *
	 * @param code
	 * @param msg
	 * @return
	 */
	public static ResponseData failure(Integer code, String msg) {
		ResponseData ResponseData = new ResponseData();
		ResponseData.setCode(code);
		ResponseData.setMsg(msg);
		ResponseData.setData(null);
		return ResponseData;
	}

	/**
	 * 登录异常
	 *
	 * @param msg
	 * @return
	 */
	public static ResponseData unAuthorization(String msg) {
		ResponseData ResponseData = new ResponseData();
		ResponseData.setCode(401);
		ResponseData.setMsg(msg);
		ResponseData.setData(null);
		return ResponseData;
	}

	/**
	 * 授权异常
	 *
	 * @param msg
	 * @return
	 */
	public static ResponseData forbidden(String msg) {
		ResponseData ResponseData = new ResponseData();
		ResponseData.setCode(403);
		ResponseData.setMsg(msg);
		ResponseData.setData(null);
		return ResponseData;
	}


	/**
	 * 返回失败的描述信息
	 *
	 * @param msg
	 * @return
	 */
	public static ResponseData failure(String msg) {
		ResponseData ResponseData = new ResponseData();
		ResponseData.setCode(500);
		ResponseData.setMsg(msg);
		ResponseData.setData(null);
		return ResponseData;
	}

}

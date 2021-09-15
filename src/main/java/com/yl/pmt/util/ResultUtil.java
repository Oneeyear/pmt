package com.yl.pmt.util;

import com.alibaba.fastjson.JSON;
import com.yl.pmt.result.ResponseData;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletResponse;
import java.io.PrintWriter;

/**
 * 返回结果工具类
 *
 * @author pch
 * @date 2021/5/28 10:50
 */
@Slf4j
public class ResultUtil {

	/**
	 * 私有化构造器
	 */
	private ResultUtil() {
	}

	/**
	 * 使用response输出JSON
	 *
	 * @param responseData
	 * @return void
	 * @author pch
	 * @date 2021/5/28 11:23
	 */
	public static void responseJson(ServletResponse response, ResponseData responseData) {
		PrintWriter out = null;
		try {
			response.setCharacterEncoding("UTF-8");
			response.setContentType("application/json");
			out = response.getWriter();
			out.println(JSON.toJSONString(responseData));
		} catch (Exception e) {
			log.error("【JSON输出异常】" + e);
		} finally {
			if (out != null) {
				out.flush();
				out.close();
			}
		}
	}

}

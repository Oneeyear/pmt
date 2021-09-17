package com.yl.pmt.security.handler;

import com.yl.pmt.result.BaseResponse;
import com.yl.pmt.security.config.JWTConfig;
import com.yl.pmt.security.pojo.SelfUser;
import com.yl.pmt.security.util.JWTTokenUtil;
import com.yl.pmt.security.util.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description 登录成功处理类
 * @Author pch
 * @CreateTime 2020/10/3 9:13
 */
@Slf4j
@Component
public class UserLoginSuccessHandler implements AuthenticationSuccessHandler {
	/**
	 * 登录成功返回结果
	 *
	 * @Author pch
	 * @CreateTime 2020/10/3 9:27
	 */
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
		// 组装JWT
		SelfUser selfUser = (SelfUser) authentication.getPrincipal();
		String token = JWTTokenUtil.createAccessToken(selfUser);
		token = JWTConfig.tokenPrefix + token;
		Map<String, String> map = new HashMap<>();
		map.put("token", token);
		// 封装返回参数
		ResultUtil.responseJson(response, BaseResponse.success("登录成功！", map));
	}
}

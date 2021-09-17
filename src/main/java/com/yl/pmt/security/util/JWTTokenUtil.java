package com.yl.pmt.security.util;

import com.alibaba.fastjson.JSON;
import com.yl.pmt.security.config.JWTConfig;
import com.yl.pmt.security.pojo.SelfUser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

/**
 * JWT工具类
 * @Author pch
 * @CreateTime 2020/10/2 7:42
 */
@Slf4j
public class JWTTokenUtil {

    /**
     * 私有化构造器
     */
    private JWTTokenUtil(){}

    /**
     * 生成Token
     * @Author pch
     * @CreateTime 2020/10/2 12:16
     * @Param  selfUser 用户安全实体
     * @Return Token
     */
    public static String createAccessToken(SelfUser selfUser){
        // 登陆成功生成JWT
        String token = Jwts.builder()
                // 放入用户名和用户ID
                .setId(selfUser.getUserCode())
                // 主题
                .setSubject(selfUser.getAccount())
                // 签发时间
                .setIssuedAt(new Date())
                // 签发者
                .setIssuer("pmt")
                // 自定义属性 放入用户拥有权限
                .claim("authorities", JSON.toJSONString(selfUser.getAuthorities()))
                // 失效时间
                .setExpiration(new Date(System.currentTimeMillis() + JWTConfig.expiration))
                // 签名算法和密钥
                .signWith(SignatureAlgorithm.HS512, JWTConfig.secret)
                .compact();
        return token;
    }
}

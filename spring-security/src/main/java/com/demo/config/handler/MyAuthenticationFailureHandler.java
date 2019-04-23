package com.demo.config.handler;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Description:自定义登录失败逻辑
 * <p>
 * Create on 2019/04/20
 *
 * @author zys
 */
@Component
public class MyAuthenticationFailureHandler implements AuthenticationFailureHandler{

    @Autowired
    private ObjectMapper mapper;
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {

        response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        response.setContentType("application/json;charset=utf-8");
        //response.getWriter().write(mapper.writeValueAsString(exception.getMessage()));
        response.getWriter().write(JSON.toJSONString(exception.getMessage()));
    }
}

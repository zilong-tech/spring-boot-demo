package com.demo.config;

import com.demo.config.filter.ValidateCodeFilter;
import com.demo.config.handler.MyAuthenticationFailureHandler;
import com.demo.config.handler.MyAuthenticationSucessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * Description:认证方式
 * <p>
 * Create on 2019/04/19
 *
 * @author zys
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyAuthenticationSucessHandler authenticationSucessHandler;

    @Autowired
    private MyAuthenticationFailureHandler authenticationFailureHandler;

    @Autowired
    private ValidateCodeFilter validateCodeFilter;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.addFilterBefore(validateCodeFilter, UsernamePasswordAuthenticationFilter.class) // 添加验证码校验过滤器
                .formLogin() //表单方式
                .loginPage("/login.html") //指定了未登录时跳转的url
               // .loginPage("/authentication/require") // 登录跳转 URL
                .loginProcessingUrl("/login") //对应登录页面form表单的action="/login"
                .successHandler(authenticationSucessHandler) // 处理登录成功
                .failureHandler(authenticationFailureHandler) // 处理登录失败
                .and()
                .authorizeRequests() //授权配置
                .antMatchers("/login.html","/css/**","/authentication/require","/code/image").permitAll()// 指定了无须认证的资源
                .anyRequest() //所有请求
                .authenticated()//都需要认证
                .and().csrf().disable(); //关闭CSRF攻击防御

    }

    /**
     * 密码加密
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}

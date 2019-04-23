package com.demo.config.filter;


import org.springframework.security.core.AuthenticationException;

/**
 * Description:
 * <p>
 * Create on 2019/04/20
 *
 * @author zys
 */
public class ValidateCodeException extends AuthenticationException {

    public ValidateCodeException(String msg, Throwable t) {
        super(msg, t);
    }
}

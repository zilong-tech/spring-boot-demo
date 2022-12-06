package com.demo.springbootvalidation.config;

import com.demo.springbootvalidation.result.ResultBody;
import org.hibernate.validator.HibernateValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.List;


/**
 * @author
 * @since 2022-11-11
 */

@RestControllerAdvice
public class ValidatorConfiguration {


    @Bean
    public Validator validator(){
        ValidatorFactory validatorFactory = Validation.byProvider(HibernateValidator.class)
                .configure()
                //  快速失败模式  true表示启用，false表示普通模式
                .addProperty("hibernate.validator.fail_fast","true")
                .buildValidatorFactory();

        return validatorFactory.getValidator();
    }

    /**
     * 普通模式 失败提示
     * @param ex
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResultBody resolveMethodArgumentNotValidException(MethodArgumentNotValidException ex){

        List<ObjectError> objectErrors = ex.getBindingResult().getAllErrors();
        if(!CollectionUtils.isEmpty(objectErrors)) {
            StringBuilder msgBuilder = new StringBuilder();
            for (ObjectError objectError : objectErrors) {
                msgBuilder.append(objectError.getDefaultMessage()).append(",");
            }
            String errorMessage = msgBuilder.toString();
            if (errorMessage.length() > 1) {
                errorMessage = errorMessage.substring(0, errorMessage.length() - 1);
            }
            return ResultBody.fail("400", errorMessage);

        }
        return null;
    }

    /**
     * 快速模式 错误提示
     * @param result
     * @return
     */
//    @ExceptionHandler({BindException.class,MethodArgumentNotValidException.class})
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    public ResultBody handleError(MethodArgumentNotValidException e) {
//
//        return this.handleError(e.getBindingResult());
//    }

    private ResultBody handleError(BindingResult result) {
        FieldError error = result.getFieldError();
        String message = String.format("%s:%s", error.getField(), error.getDefaultMessage());
        return ResultBody.fail("400", message);
    }
}
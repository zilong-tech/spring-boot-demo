package com.demo.springbootvalidation.anno;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class FlagValidatorClass implements ConstraintValidator<FlagValidator,Object> {
    /**
     * FlagValidator注解规定的那些有效值
     */
    private String values;

    @Override
    public void initialize(FlagValidator flagValidator) {
        this.values = flagValidator.values();
    }

    /**
     * 用户输入的值，必须是FlagValidator注解规定的那些值其中之一。
     * 否则，校验不通过。
     * @param value 用户输入的值，如从前端传入的某个值
     */
    @Override
    public boolean isValid(Object value, ConstraintValidatorContext constraintValidatorContext) {
        // 切割获取值
        String[] value_array = values.split(",");
        Boolean isFlag = false;

        for (int i = 0; i < value_array.length; i++){
            // 存在一致就跳出循环
            if (value_array[i] .equals(value)){
                isFlag = true; break;
            }
        }

        return isFlag;
    }
}
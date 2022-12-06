package com.demo.springbootvalidation.utils;


import com.demo.springbootvalidation.web.City;
import com.demo.springbootvalidation.web.User;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ValidateUtil {
	/**
	 * 校验参数
	 *
	 * @param voObject
	 * @return
	 */
	public static String validateParams(Object voObject) {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<Object>> violations = validator.validate(voObject);
		if (violations.size() > 0) {
			List<String> msgList = new ArrayList<>();
			for (ConstraintViolation<Object> violation : violations) {
				msgList.add(violation.getMessage());
			}
			return StringUtils.join(msgList.toArray(), ",");
		} else {
			return null;
		}
	}

	/**
	 * 分组校验参数
	 *
	 * @param voObject
	 * @return
	 */
	public static String validateParams(Object voObject, Class<?>... groupClass) {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<Object>> violations = validator.validate(voObject, groupClass);
		if (violations.size() > 0) {
			List<String> msgList = new ArrayList<>();
			for (ConstraintViolation<Object> violation : violations) {
				msgList.add(violation.getMessage());
			}
			return StringUtils.join(msgList.toArray(), ",");
		} else {
			return null;
		}
	}

	public static void main(String[] args) {

		City city = new City();
		String s = validateParams(city);
		System.out.println(s);
	}

}

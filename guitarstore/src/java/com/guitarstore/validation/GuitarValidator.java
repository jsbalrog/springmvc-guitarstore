package com.guitarstore.validation;

import com.guitarstore.domain.Guitar;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author jenkinset
 */
public class GuitarValidator implements Validator {

	@Override
	public boolean supports(Class clazz) {
		return Guitar.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object o, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "brand", "required.brand", "Brand is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "model", "required.model", "Model is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "year", "required.year", "Year is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "price", "required.price", "Price is required.");
	}

}

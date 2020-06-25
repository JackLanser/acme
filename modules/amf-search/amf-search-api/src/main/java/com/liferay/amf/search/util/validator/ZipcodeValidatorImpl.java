package com.liferay.amf.search.util.validator;

import com.liferay.amf.search.exception.ZipcodeValidationException;
import com.liferay.amf.search.validator.ZipcodeValidator;
import com.liferay.portal.kernel.util.Validator;

import java.util.ArrayList;
import java.util.List;

import org.osgi.service.component.annotations.Component;

 @Component(
     immediate = true, 
     service = ZipcodeValidator.class
 )
 public class ZipcodeValidatorImpl implements ZipcodeValidator {

	@Override
	public void validate(String zipCode) throws ZipcodeValidationException {
		List<String> errors = new ArrayList<>();
		if(!zipCodeValid(zipCode, errors)) {
			throw new ZipcodeValidationException(errors);
		}
	}
	
	public boolean zipCodeValid(String zipCode, List<String> errors) {
		if(!Validator.isNumber(zipCode)) {
			errors.add("zipCodeNaN");
		}
		if(zipCode.length() != 5) {
			errors.add("zipCodeLength");
		}
		if(!errors.isEmpty()) return false;
		else return true;
	}


}
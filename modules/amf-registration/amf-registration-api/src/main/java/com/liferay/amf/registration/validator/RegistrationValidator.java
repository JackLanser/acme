package com.liferay.amf.registration.validator;

import com.liferay.amf.registration.exception.RegistrationValidationException;

import java.util.Date;
import java.util.Locale;
import java.util.Map;

public interface RegistrationValidator {
	public void validate(String firstName, String lastName, String email, String userName, boolean male, int bMonth, int bDay, int bYear, 
			String password1, String password2, String homePhone, String mobilePhone, String address1, String address2, String city,
			String zip, String securityQuestion, String securityAnswer, boolean acceptedTou)
			throws RegistrationValidationException;
}

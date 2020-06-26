package com.liferay.amf.registration.util.validator;

import com.liferay.amf.registration.exception.RegistrationValidationException;
import com.liferay.amf.registration.validator.RegistrationValidator;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.regex.Pattern;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, service = RegistrationValidator.class)
public class RegistrationValidatorImpl implements RegistrationValidator {

	public boolean isRegistrationValid(
		String firstName, String lastName, String email, String userName,
		boolean male, int bMonth, int bDay, int bYear, String password1,
		String password2, String homePhone, String mobilePhone, String address1,
		String address2, String city, String zip, String securityQuestion,
		String securityAnswer, boolean acceptedTou, List<String> errors) {

		validateBasicInfo(
			userName, email, firstName, lastName, bMonth, bDay, bYear,
			password1, password2, errors);
		validatePhone(homePhone, mobilePhone, errors);
		validateBillingAddress(address1, address2, city, zip, errors);
		validateMisc(securityAnswer, acceptedTou, errors);

		if (errors.isEmpty())

			return false;
			else

			return true;
	}

	@Override
	public void validate(
			String firstName, String lastName, String email, String userName,
			boolean male, int bMonth, int bDay, int bYear, String password1,
			String password2, String homePhone, String mobilePhone,
			String address1, String address2, String city, String zip,
			String securityQuestion, String securityAnswer, boolean acceptedTou)
		throws RegistrationValidationException {

		List<String> errors = new ArrayList<>();

		if (isRegistrationValid(
				firstName, lastName, email, userName, male, bMonth, bDay, bYear,
				password1, password2, homePhone, mobilePhone, address1,
				address2, city, zip, securityQuestion, securityAnswer,
				acceptedTou, errors)) {

			throw new RegistrationValidationException(errors);
		}
	}

	@Reference
	protected com.liferay.portal.kernel.service.UserLocalService
		userLocalService;

	private boolean compareBirthday(int bDay, int bMonth, int bYear) {
		Calendar todaysDate = Calendar.getInstance();
		Calendar birthDate = Calendar.getInstance();

		birthDate.set(bYear + 13, bMonth, bDay);

		if (todaysDate.compareTo(birthDate) < 0)

			return true;

		return false;
	}

	private void validateBasicInfo(
		String userName, String email, String firstName, String lastName,
		int bMonth, int bDay, int bYear, String password1, String password2,
		List<String> errors) {

		Pattern p = Pattern.compile("^[a-zA-Z0-9]*$");
		Pattern pEmail = Pattern.compile("^[a-zA-Z0-9@.]*$");
		Pattern pPassword = Pattern.compile(
			"^((?=.*[a-z])(?=.*[0-9])(?=.*[!^&*@#$%])(?=.*[A-Z]).{6,})$");

		if (firstName.length() > 50)
			errors.add("firstNameErrorTooLong");

		if (firstName.equals(""))
			errors.add("firstNameErrorEmpty");

		if (!p.matcher(firstName).matches())
			errors.add("firstNameErrorNonAlpha");
;

		if (lastName.length() > 50)
			errors.add("lastNameErrorTooLong");

		if (lastName.equals(""))
			errors.add("lastNameErrorEmpty");

		if (!p.matcher(lastName).matches())
			errors.add("lastNameErrorNonAlpha");

		if (email.length() > 255)
			errors.add("emailErrorTooLong");

		if (email.equals(""))
			errors.add("emailErrorEmpty");

		if (!email.contains("@"))
			errors.add("emailErrorNoAt");
		email = email.replaceFirst("@", "");
		email = email.replace(".", "");

		if (!pEmail.matcher(email).matches())
			errors.add("emailErrorNonAlpha");

		if (!p.matcher(userName).matches())
			errors.add("userNameErrorNonAlpha");

		if ((userName.length() < 4) || (userName.length() > 16))
			errors.add("userNameErrorLength");

		if (userLocalService.fetchUserByScreenName(20101, userName) != null)
			errors.add("userNameErrorNotUnique");

		if (!pPassword.matcher(password1).matches())
			errors.add("passwordErrorNonAlpha");

		if (password1.length() < 6)
			errors.add("passwordErrorTooShort");

		if (!password1.equals(password2))
			errors.add("passwordErrorConfirmMismatch");

		if (compareBirthday(bDay, bMonth, bYear))
			errors.add("birthdayError");
	}

	private void validateBillingAddress(
		String address1, String address2, String city, String zip,
		List<String> errors) {

		Pattern p = Pattern.compile("^[a-zA-Z0-9]*$");
		Pattern pNumber = Pattern.compile("^[0-9]{5}$");

		if (address1.length() > 255)
			errors.add("address1ErrorTooLong");

		if (address1.equals(""))
			errors.add("address1ErrorEmpty");
		address1 = address1.replace(" ", "");

		if (!p.matcher(address1).matches())
			errors.add("address1ErrorNonAlpha");

		if (address2.length() > 255)
			errors.add("address2ErrorTooLong");
		address2 = address2.replace(" ", "");

		if (!p.matcher(address2).matches())
			errors.add("address2ErrorNonAlpha");

		if (!p.matcher(city).matches())
			errors.add("cityErrorNonAlpha");

		if (city.length() > 255)
			errors.add("cityErrorTooLong");

		if (!pNumber.matcher(zip).matches())
			errors.add("zipError");
	}

	private void validateMisc(
		String securityAnswer, boolean acceptedTou, List<String> errors) {

		Pattern p = Pattern.compile("^[a-zA-Z0-9]*$");

		if (!acceptedTou)
			errors.add("acceptedTouError");

		if (!p.matcher(securityAnswer).matches())
			errors.add("securityAnswerNonAlpha");

		if (securityAnswer.length() > 255)
			errors.add("secuirtyAnswerTooLong");

		if (securityAnswer.equals(""))
			errors.add("securityAnswerEmpty");
	}

	private void validatePhone(
		String homePhone, String mobilePhone, List<String> errors) {

		Pattern pNumber = Pattern.compile("^[0-9]{10}$");

		if (homePhone.equals("") && mobilePhone.equals("")) {
			return;
		}

		if (homePhone.equals("")) {
			if (!pNumber.matcher(mobilePhone).matches())
				errors.add("mobilePhoneError");

			return;
		}

		if (mobilePhone.equals("")) {
			if (!pNumber.matcher(homePhone).matches())
				errors.add("homePhoneError");

			return;
		}

		if (!pNumber.matcher(homePhone).matches())
			errors.add("homePhoneError");

		if (!pNumber.matcher(mobilePhone).matches())
			errors.add("mobilePhoneError");
	}

}
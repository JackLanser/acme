<%@ include file="./init.jsp"%>

<liferay-ui:error key="serviceErrorDetails">
	<liferay-ui:message arguments='<%= SessionErrors.get(liferayPortletRequest, "serviceErrorDetails") %>' key="error.assignment-service-error" />
</liferay-ui:error>
<liferay-ui:error key="firstNameErrorTooLong" message="First name is too long" />
<liferay-ui:error key="firstNameErrorEmpty" message="First name field is empty" />
<liferay-ui:error key="firstNameNonAlpha" message="First name is not alphanumeric" />

<liferay-ui:error key="lastNameErrorTooLong" message="Last name is too long" />
<liferay-ui:error key="lastNameErrorEmpty" message="Last name field is empty" />
<liferay-ui:error key="lastNameNonAlpha" message="Last name is not alphanumeric" />

<liferay-ui:error key="emailErrorTooLong" message="Email is too long" />
<liferay-ui:error key="emailErrorEmpty" message="Email field is empty" />
<liferay-ui:error key="emailErrorNoAt" message="Email is missing a @" />
<liferay-ui:error key="emailNonAlpha" message="Email is not alphanumeric" />

<liferay-ui:error key="userNameErrorLength" message="Username needs to be between 4 and 16 characters" />
<liferay-ui:error key="userNameErrorNonAlpha" message="Username is not alphanumeric" />
<liferay-ui:error key="userNameErrorNotUnique" message="There is already an account with that username" />

<liferay-ui:error key="passwordErrorNonAlpha" message="Password is not alphanumeric" />
<liferay-ui:error key="passwordErrorTooShort" message="Password needs to be at least 6 characters" />
<liferay-ui:error key="passwordErrorConfirmMismatch" message="Passwords do not match" />

<liferay-ui:error key="birthdayError" message="You need to be at least 13 years old to create an account" />

<liferay-ui:error key="homePhoneError" message="Home phone can only be digits and cannot be greater than 10 digits" />
<liferay-ui:error key="mobilePhoneError" message="Mobile phone can only be digits and cannot be greater than 10 digits" />

<liferay-ui:error key="address1ErrorNonAlpha" message="Address 1 is not alphanumeric" />
<liferay-ui:error key="address1ErrorTooLong" message="Address 1 cannot be greater than 255 characters" />
<liferay-ui:error key="address1ErrorEmpty" message="Address 1 field is empty" />

<liferay-ui:error key="address2ErrorNonAlpha" message="Address 2 is not alphanumeric" />
<liferay-ui:error key="address2ErrorTooLong" message="Address 2 cannot be greater than 255 characters" />

<liferay-ui:error key="cityErrorNonAlpha" message="City is not alphanumeric" />
<liferay-ui:error key="cityErrorTooLong" message="City cannot be greater than 255 characters" />

<liferay-ui:error key="zipError" message="Zipcode has to be a 5 digit number" />

<liferay-ui:error key="securityAnswerNonAlpha" message="Security Answer is not alphanumeric" />
<liferay-ui:error key="securityAnswerTooLong" message="Security Answer is too long" />
<liferay-ui:error key="securityAnswerEmpty" message="Security Answer field is empty" />

<liferay-ui:error key="acceptedTouError" message="Need to agree to terms of use" />











<%@ include file="./init.jsp"%>

<liferay-ui:error key="serviceErrorDetails">
	<liferay-ui:message arguments='<%= SessionErrors.get(liferayPortletRequest, "serviceErrorDetails") %>' key="error.assignment-service-error" />
</liferay-ui:error>
<liferay-ui:error key="firstNameErrorTooLong" message="first.name.too.long" />
<liferay-ui:error key="firstNameErrorEmpty" message="first.name.empty" />
<liferay-ui:error key="firstNameNonAlpha" message="first.name.non.alpha" />

<liferay-ui:error key="lastNameErrorTooLong" message="last.name.too.long" />
<liferay-ui:error key="lastNameErrorEmpty" message="last.name.empty" />
<liferay-ui:error key="lastNameNonAlpha" message="last.name.non.alpha" />

<liferay-ui:error key="emailErrorTooLong" message="email.too.long" />
<liferay-ui:error key="emailErrorEmpty" message="email.empty" />
<liferay-ui:error key="emailErrorNoAt" message="email.no.at" />
<liferay-ui:error key="emailNonAlpha" message="email.non.alpha" />

<liferay-ui:error key="userNameErrorLength" message="username.length" />
<liferay-ui:error key="userNameErrorNonAlpha" message="username.non.alpha" />
<liferay-ui:error key="userNameErrorNotUnique" message="username.not.unique" />

<liferay-ui:error key="passwordErrorNonAlpha" message="password.non.alpha" />
<liferay-ui:error key="passwordErrorTooShort" message="password.too.short" />
<liferay-ui:error key="passwordErrorConfirmMismatch" message="password.confirm.mismatch" />

<liferay-ui:error key="birthdayError" message="birthday" />

<liferay-ui:error key="homePhoneError" message="home.phone" />
<liferay-ui:error key="mobilePhoneError" message="mobile.phone" />

<liferay-ui:error key="address1ErrorNonAlpha" message="address1.non.alpha" />
<liferay-ui:error key="address1ErrorTooLong" message="address1.too.long" />
<liferay-ui:error key="address1ErrorEmpty" message="address1.empty" />

<liferay-ui:error key="address2ErrorNonAlpha" message="address2.non.alpha" />
<liferay-ui:error key="address2ErrorTooLong" message="address2.too.long" />

<liferay-ui:error key="cityErrorNonAlpha" message="city.non.alpha" />
<liferay-ui:error key="cityErrorTooLong" message="city.too.long" />

<liferay-ui:error key="zipError" message="zip" />

<liferay-ui:error key="securityAnswerNonAlpha" message="security.anser.non.alpha" />
<liferay-ui:error key="securityAnswerTooLong" message="security.answer.too.long" />
<liferay-ui:error key="securityAnswerEmpty" message="security.answer.empty" />

<liferay-ui:error key="acceptedTouError" message="acceptedTou" />











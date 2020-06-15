package com.liferay.amf.registration.web.portlet.actions;

import com.liferay.amf.registration.exception.RegistrationValidationException;
import com.liferay.amf.registration.service.registrationLocalService;
import com.liferay.amf.registration.web.constants.MVCCommandNames;
import com.liferay.amf.registration.web.constants.RegistrationPortletKeys;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
	immediate = true,
	property = {
			"javax.portlet.name=" + RegistrationPortletKeys.REGISTRATION,
			"mvc.command.name=" + MVCCommandNames.SUBMIT_FORM
	},
	service = MVCActionCommand.class
)
public class SumbitFormMVCActionCommand extends BaseMVCActionCommand {

	@Override
	public void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException, PortalException {
		String firstName = ParamUtil.getString(actionRequest, "first_name");
		String lastName = ParamUtil.getString(actionRequest, "last_name");
		String userName = ParamUtil.getString(actionRequest, "username");
		String email = ParamUtil.getString(actionRequest, "email");
		String Gender = ParamUtil.getString(actionRequest, "Gender");
		int bDay = Integer.parseInt(ParamUtil.getString(actionRequest, "bDay"));
		int bMonth = Integer.parseInt(ParamUtil.getString(actionRequest, "bMonth"));
		int bYear = Integer.parseInt(ParamUtil.getString(actionRequest, "bYear"));
		String password1 = ParamUtil.getString(actionRequest, "password1");
		String password2 = ParamUtil.getString(actionRequest, "password2");
		String homePhone = ParamUtil.getString(actionRequest, "home_phone");
		String mobilePhone = ParamUtil.getString(actionRequest, "mobile_phone");
		String address1 = ParamUtil.getString(actionRequest, "address");
		String address2 = ParamUtil.getString(actionRequest, "address2");
		String zip = ParamUtil.getString(actionRequest, "zip");
		String state = ParamUtil.getString(actionRequest, "state");
		String city = ParamUtil.getString(actionRequest, "city");
		String securityQuestion = ParamUtil.getString(actionRequest, "security_question");
		String securityAnswer = ParamUtil.getString(actionRequest, "security_answer");
		boolean acceptedTou = ParamUtil.getBoolean(actionRequest, "accepted_tou");
		boolean male = false;
		
		if(Gender.equals("Male")) male = true;
		try{
			_registrationLocalService.addUser(firstName, lastName, email, userName, male, bMonth, bDay, bYear, password1,
				password2, homePhone, mobilePhone, address1, address2, city, zip, securityQuestion, securityAnswer, 
				acceptedTou, state);
		}
		catch (RegistrationValidationException rve) {
			rve.getErrors().forEach(key -> SessionErrors.add(actionRequest, key));
		}catch (PortalException e) {
			e.printStackTrace();
		}
		
		
	}
	
	 @Reference
     protected registrationLocalService _registrationLocalService;

}

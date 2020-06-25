package com.liferay.amf.search.web.actions;

import com.liferay.amf.search.exception.ZipcodeValidationException;
import com.liferay.amf.search.validator.ZipcodeValidator;
import com.liferay.amf.search.web.constants.MVCCommandNames;
import com.liferay.amf.search.web.constants.SearchBoxPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.ProcessAction;
import javax.xml.namespace.QName;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
		immediate = true,
		property = {
				"javax.portlet.name=" + SearchBoxPortletKeys.SEARCHBOX,
				"mvc.command.name=" + MVCCommandNames.SUBMIT_ZIP
		},
		service = MVCActionCommand.class
	)
public class SearchBoxMVCActionCommand extends BaseMVCActionCommand{
	
	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) {
		try {
			producer(actionRequest, actionResponse);
		} catch (ZipcodeValidationException zve) {
			zve.getErrors().forEach(key -> SessionErrors.add(actionRequest, key));
		}
	}
	
	@ProcessAction(name="producer")
	public void producer(ActionRequest actionRequest, ActionResponse actionResponse) throws ZipcodeValidationException {
		String zip = ParamUtil.getString(actionRequest, "zipCode");
		_zipCodeValidator.validate(zip);
		QName qName = new QName("http://zipcode.com", "producemessage");
		actionResponse.setEvent(qName, zip);
	}

	@Reference
    private ZipcodeValidator _zipCodeValidator;

}

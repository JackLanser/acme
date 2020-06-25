package com.liferay.amf.search.web.actions;

import com.liferay.amf.search.web.constants.MVCCommandNames;
import com.liferay.amf.search.web.constants.SearchBoxPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.ProcessAction;
import javax.xml.namespace.QName;

import org.osgi.service.component.annotations.Component;

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
		producer(actionRequest, actionResponse);
	}
	
	@ProcessAction(name="producer")
	public void producer(ActionRequest actionRequest, ActionResponse actionResponse) {
		String zip = ParamUtil.getString(actionRequest, "zipCode");
		QName qName = new QName("http://zipcode.com", "producemessage");
		actionResponse.setEvent(qName, zip);
	}


}

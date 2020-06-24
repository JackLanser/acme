package com.liferay.amf.search.web.actions;

import com.liferay.amf.search.service.ZipcodeSearchLocalService;
import com.liferay.amf.search.web.constants.MVCCommandNames;
import com.liferay.amf.search.web.constants.SearchBoxPortletKeys;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

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
		String zip = ParamUtil.getString(actionRequest, "zipCode");
		List<User> users = _zipCodeSearchLocalService.findUserByZip(zip);
		System.out.println(users.toString());
		
	}
	
	@Reference
	private ZipcodeSearchLocalService _zipCodeSearchLocalService;

}

package com.liferay.amf.search.web.actions;

import com.liferay.amf.search.web.constants.SearchBoxResultsPortletKeys;
import com.liferay.amf.search.web.constants.MVCCommandNames;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;

import org.osgi.service.component.annotations.Component;

@Component(
		immediate = true,
		property = {
			"javax.portlet.name=" + SearchBoxResultsPortletKeys.SEARCHBOXRESULTS,
			"mvc.command.name=/", "mvc.command.name=" + MVCCommandNames.LIST_USER
		},
		service = MVCRenderCommand.class
)
public class SearchBoxResultsMVCRenderCommand implements MVCRenderCommand{

}

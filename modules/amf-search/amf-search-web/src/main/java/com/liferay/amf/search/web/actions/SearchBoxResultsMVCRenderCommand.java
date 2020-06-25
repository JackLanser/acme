package com.liferay.amf.search.web.actions;

import com.liferay.amf.search.service.ZipcodeSearchService;
import com.liferay.amf.search.web.constants.MVCCommandNames;
import com.liferay.amf.search.web.constants.SearchBoxResultsPortletKeys;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
		immediate = true,
		property = {
			"javax.portlet.name=" + SearchBoxResultsPortletKeys.SEARCHBOXRESULTS,
			"mvc.command.name=/", "mvc.command.name=" + MVCCommandNames.LIST_USER
		},
		service = MVCRenderCommand.class
)
public class SearchBoxResultsMVCRenderCommand implements MVCRenderCommand{

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		
		_setRequestAttributes(renderRequest, renderResponse);
		
		return "/search_box_results.jsp";
		
	}
	
	private void _setRequestAttributes(RenderRequest renderRequest, RenderResponse renderResponse) {
		int currentPage = ParamUtil.getInteger(
				renderRequest, SearchContainer.DEFAULT_CUR_PARAM,
				SearchContainer.DEFAULT_CUR);

		int delta = ParamUtil.getInteger(
				renderRequest, SearchContainer.DEFAULT_DELTA_PARAM,
				5);
		
		int start = ((currentPage > 0) ? (currentPage - 1) : 0) * delta;

		int end = start + delta;
		String zipcode = ParamUtil.getString(renderRequest, "zipcode");
		List<User> users = _zipCodeSearchService.findUserByZip(zipcode, start, end);
		long userCount = _zipCodeSearchService.getUserCount(zipcode);
		renderRequest.setAttribute("userCount", userCount);
		renderRequest.setAttribute("users", users);
		renderRequest.setAttribute("zip", zipcode);
	}
	
	

	@Reference
	private ZipcodeSearchService _zipCodeSearchService;
	
}

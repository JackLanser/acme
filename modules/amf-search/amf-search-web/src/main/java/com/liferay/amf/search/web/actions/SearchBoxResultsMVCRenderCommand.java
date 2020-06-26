/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.amf.search.web.actions;

import com.liferay.amf.search.service.ZipcodeSearchService;
import com.liferay.amf.search.web.constants.MVCCommandNames;
import com.liferay.amf.search.web.constants.SearchBoxResultsPortletKeys;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.util.ParamUtil;

import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author liferay
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + SearchBoxResultsPortletKeys.SEARCHBOXRESULTS,
		"mvc.command.name=/", "mvc.command.name=" + MVCCommandNames.LIST_USER
	},
	service = MVCRenderCommand.class
)
public class SearchBoxResultsMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws PortletException {

		_setRequestAttributes(renderRequest);

		return "/search_box_results.jsp";
	}

	private void _setRequestAttributes(RenderRequest renderRequest) {
		int currentPage = ParamUtil.getInteger(
			renderRequest, SearchContainer.DEFAULT_CUR_PARAM,
			SearchContainer.DEFAULT_CUR);

		int delta = ParamUtil.getInteger(
			renderRequest, SearchContainer.DEFAULT_DELTA_PARAM, 5);

		int start = ((currentPage > 0) ? (currentPage - 1) : 0) * delta;

		int end = start + delta;

		String zipcode = ParamUtil.getString(renderRequest, "zipcode");

		try {
			List<User> users = _zipCodeSearchService.findUserByZip(
				zipcode, start, end);

			renderRequest.setAttribute("users", users);

			renderRequest.setAttribute(
				"userCount", _zipCodeSearchService.getUserCount(zipcode));
		}
		catch (PrincipalException e1) {
			e1.printStackTrace();
		}

		renderRequest.setAttribute("zip", zipcode);
	}

	@Reference
	private ZipcodeSearchService _zipCodeSearchService;

}
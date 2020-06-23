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

package com.liferay.amf.eventmonitor.web.portlet.action;

import com.liferay.amf.eventmonitor.web.constants.EventMonitorPortletKeys;
import com.liferay.amf.eventmonitor.web.constants.MVCCommandNames;
import com.liferay.amf.monitor.model.eventMonitor;
import com.liferay.amf.monitor.service.eventMonitorService;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Portal;

import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * MVC command for showing the assignments list.
 *
 * @author liferay
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + EventMonitorPortletKeys.EVENTMONITOR,
		"mvc.command.name=/", "mvc.command.name=" + MVCCommandNames.LOGIN_VIEW
	},
	service = MVCRenderCommand.class
)
public class LoginViewMVCRenderCommand implements MVCRenderCommand { //ViewEventsMVCRenderCommand

	@Override
	public String render(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws PortletException {

		int currentPage = ParamUtil.getInteger(
			renderRequest, SearchContainer.DEFAULT_CUR_PARAM,
			SearchContainer.DEFAULT_CUR);

		int delta = ParamUtil.getInteger(
			renderRequest, SearchContainer.DEFAULT_DELTA_PARAM,
			SearchContainer.DEFAULT_DELTA);

		int start = ((currentPage > 0) ? (currentPage - 1) : 0) * delta;

		int end = start + delta;

		String curTab = ParamUtil.getString(renderRequest, "tab");

		PortletURL iteratorURL = renderResponse.createRenderURL();

		iteratorURL.setParameter(
			"mvcRenderCommandName", MVCCommandNames.LOGIN_VIEW);

		iteratorURL.setParameter("tab", curTab);

		renderRequest.setAttribute("iteratorURL", iteratorURL);

		List<eventMonitor> events;

		if (curTab.equals("All")) {
			try {
				events = _eventMonitorService.findAll(start, end);

				renderRequest.setAttribute("eventList", events);

				long loginCount =
					_eventMonitorService.getEventMonitorsCountByEventType(
						"Login");
				long registrationCount =
					_eventMonitorService.getEventMonitorsCountByEventType(
						"Registration");

				long count = loginCount + registrationCount;

				renderRequest.setAttribute("eventCount", count);
			}
			catch (PrincipalException e) {
				e.printStackTrace();
			}
		}
		else {
			try {
				events = _eventMonitorService.findByEventType(
					curTab, start, end);

				renderRequest.setAttribute("eventList", events);

				long count =
					_eventMonitorService.getEventMonitorsCountByEventType(
						curTab);

				renderRequest.setAttribute("eventCount", count);
			}
			catch (PrincipalException e) {
				e.printStackTrace();
			}
		}

		return "/view.jsp";
	}

	@Reference
	private eventMonitorService _eventMonitorService;

	@Reference
	private Portal _portal;

}
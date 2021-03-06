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

package com.liferay.amf.search.web.portlet;

import com.liferay.amf.search.web.constants.SearchBoxResultsPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Event;
import javax.portlet.EventRequest;
import javax.portlet.EventResponse;
import javax.portlet.Portlet;
import javax.portlet.ProcessEvent;

import org.osgi.service.component.annotations.Component;

/**
 * @author liferay
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=tools",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=SearchBoxResults",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/search_box_results.jsp",
		"javax.portlet.name=" + SearchBoxResultsPortletKeys.SEARCHBOXRESULTS,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user",
		"javax.portlet.supported-processing-event=producemessage;http://zipcode.com"
	},
	service = Portlet.class
)
public class SearchBoxResultsPortlet extends MVCPortlet {

	@ProcessEvent(qname = "{http://zipcode.com}producemessage")
	public void consumer(
		EventRequest eventRequest, EventResponse eventResponse) {

		Event event = eventRequest.getEvent();

		String zipcode = (String)event.getValue();

		eventResponse.setRenderParameter("zipcode", zipcode);
	}

}
package com.liferay.amf.search.web.portlet;

import com.liferay.amf.search.web.constants.SearchBoxResultsPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;

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
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class SearchBoxResultsPortlet extends MVCPortlet {
}
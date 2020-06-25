package com.liferay.amf.search.web.portlet;

import com.liferay.amf.search.web.constants.SearchBoxPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.ProcessAction;
import javax.xml.namespace.QName;

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
		"javax.portlet.display-name=SearchBox",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/search_box.jsp",
		"javax.portlet.name=" + SearchBoxPortletKeys.SEARCHBOX,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user",
		"javax.portlet.supported-publishing-event=producemessage;http://zipcode.com"
	},
	service = Portlet.class
)
public class SearchBoxPortlet extends MVCPortlet {
	
}
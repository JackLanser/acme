package com.liferay.amf.newsletter.web.render;

import com.liferay.amf.newsletter.web.constants.MVCCommandNames;
import com.liferay.amf.newsletter.web.constants.NewsletterPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

@Component(
		immediate = true,
		property = {
			"javax.portlet.name=" + NewsletterPortletKeys.NEWSLETTER,
			"mvc.command.name=/", "mvc.command.name=" + MVCCommandNames.VIEW_ISSUE
		},
		service = MVCRenderCommand.class
)
public class ViewIssuesMVCRenderCommand implements MVCRenderCommand{
	
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) {
		
		return "view.jsp";
	}

}

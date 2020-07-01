package com.liferay.amf.newsletter.web.render;

import com.liferay.amf.newsletter.model.Issue;
import com.liferay.amf.newsletter.service.IssueLocalService;
import com.liferay.amf.newsletter.web.constants.MVCCommandNames;
import com.liferay.amf.newsletter.web.constants.NewsletterPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;

import java.util.List;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

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
		List<Issue> issues = _issueLocalService.findAllIssues();
		renderRequest.setAttribute("issues", issues);
		return "/view.jsp";
	}

	@Reference
	private IssueLocalService _issueLocalService;
}

package com.liferay.amf.newsletter.web.render;

import com.liferay.amf.newsletter.model.Article;
import com.liferay.amf.newsletter.model.Issue;
import com.liferay.amf.newsletter.service.ArticleLocalService;
import com.liferay.amf.newsletter.service.IssueLocalService;
import com.liferay.amf.newsletter.web.constants.MVCCommandNames;
import com.liferay.amf.newsletter.web.constants.NewsletterPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
		immediate = true,
		property = {
			"javax.portlet.name=" + NewsletterPortletKeys.NEWSLETTER,
			"mvc.command.name=" + MVCCommandNames.VIEW_ARTICLE_LIST
		},
		service = MVCRenderCommand.class
)
public class ListArticlesMVCRenderCommand implements MVCRenderCommand{

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		
		int issueNumber = ParamUtil.getInteger(renderRequest, "issueNumber");
		long issueId = ParamUtil.getLong(renderRequest, "issueId");
		Issue issue = _issueLocalService.fetchByIssueId(issueId);
		List<Article> articles = _articleLocalService.findArticlesByIssueNumber(issueNumber);
		String byline = generateByline(articles);
		renderRequest.setAttribute("byline", byline);
		renderRequest.setAttribute("articles", articles);
		renderRequest.setAttribute("issue", issue);
		
		return "/articleListView.jsp";
	}

	private String generateByline(List<Article> articles){
		String byline = "";
		for(Article article : articles) {
			byline += article.getAuthor() + ", ";
		}
		byline = byline.replaceAll(", $", "");
		return byline;
	}
	
	@Reference
	private ArticleLocalService _articleLocalService;
	
	@Reference
	private IssueLocalService _issueLocalService;
}

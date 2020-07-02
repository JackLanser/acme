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

package com.liferay.amf.newsletter.web.render;

import com.liferay.amf.newsletter.model.Article;
import com.liferay.amf.newsletter.model.Issue;
import com.liferay.amf.newsletter.service.ArticleLocalService;
import com.liferay.amf.newsletter.service.IssueLocalService;
import com.liferay.amf.newsletter.web.constants.MVCCommandNames;
import com.liferay.amf.newsletter.web.constants.NewsletterPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		"javax.portlet.name=" + NewsletterPortletKeys.NEWSLETTER,
		"mvc.command.name=/", "mvc.command.name=" + MVCCommandNames.VIEW_ISSUE
	},
	service = MVCRenderCommand.class
)
public class ViewIssuesMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(
		RenderRequest renderRequest, RenderResponse renderResponse) {

		Map<Issue, List<Article>> issueItems = new HashMap<>();
		List<Issue> issues = _issueLocalService.findAllIssues();

		for (Issue i : issues) {
			List<Article> value =
				_articleLocalService.findArticlesByIssueNumber(
					i.getIssueNumber());

			issueItems.put(i, value);
		}

		renderRequest.setAttribute("issues", issueItems);

		return "/view.jsp";
	}

	@Reference
	private ArticleLocalService _articleLocalService;

	@Reference
	private IssueLocalService _issueLocalService;

}
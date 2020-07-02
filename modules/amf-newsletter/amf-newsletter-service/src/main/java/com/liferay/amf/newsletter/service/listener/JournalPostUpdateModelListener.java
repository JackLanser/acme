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

package com.liferay.amf.newsletter.service.listener;

import com.liferay.amf.newsletter.service.ArticleLocalService;
import com.liferay.amf.newsletter.service.IssueLocalService;
import com.liferay.journal.model.JournalArticle;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.BaseModelListener;
import com.liferay.portal.kernel.model.ModelListener;
import com.liferay.portal.kernel.workflow.WorkflowConstants;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author liferay
 */
@Component(immediate = true, property = {}, service = ModelListener.class)
public class JournalPostUpdateModelListener
	extends BaseModelListener<JournalArticle> {

	public static final String ARTICLE_DDMS = "49942";

	@Override
	public void onAfterUpdate(JournalArticle model) {
		System.out.println(model.getStatus());
		String ddmsKey = model.getDDMStructureKey();

		if (ddmsKey.equals(ARTICLE_DDMS)) {
			if (model.getStatus() == WorkflowConstants.STATUS_IN_TRASH) {
				try {
					_articleLocalService.deleteArticle(
						model.getResourcePrimKey());
				}
				catch (PortalException e) {
					e.printStackTrace();
				}
			}
			else {
				_articleLocalService.handleArticleEvents(
					model.getContent(), model.getResourcePrimKey());
			}
		}
		else {
			if (model.getStatus() == WorkflowConstants.STATUS_IN_TRASH) {
				try {
					_issueLocalService.deleteIssue(model.getResourcePrimKey());
				}
				catch (PortalException e) {
					e.printStackTrace();
				}
			}
			else {
				_issueLocalService.handleIssueEvents(
					model.getContent(), model.getResourcePrimKey());
			}
		}
	}

	@Reference
	private ArticleLocalService _articleLocalService;

	@Reference
	private IssueLocalService _issueLocalService;

}
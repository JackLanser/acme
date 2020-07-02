<%--
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
--%>

<%@ include file="/init.jsp" %>

<c:forEach items="${issues}" var="issue">
	<portlet:renderURL var="viewArticlesURL">
		<portlet:param name="mvcRenderCommandName" value="<%= MVCCommandNames.VIEW_ARTICLE_LIST %>" />
		<portlet:param name="issueNumber" value="${issue.key.issueNumber}" />
		<portlet:param name="issueId" value="${issue.key.issueId}" />
	</portlet:renderURL>

	<aui:fieldset-group markupView="lexicon">
		<a href="${viewArticlesURL}" style="text-decoration: none; color: black;" />

		<aui:fieldset markupView="lexicon">
			<aui:row>
				<h4>Issue: #${issue.key.issueNumber}, ${fn:substring(issue.key.issueDate, 0, 10)} ${fn:substring(issue.key.issueDate,24, 28)}</h4>
			</aui:row>

			<aui:row>
				<h1>${issue.key.title}</h1>
			</aui:row>

			<aui:row>
				<p>${issue.key.description}</p>
			</aui:row>

			<aui:row>
				<aui:fieldset label="Articles:">
					<c:forEach items="${issue.value}" var="article">
						<aui:row>
							<h6>${article.title}</h6>
						</aui:row>
					</c:forEach>
				</aui:fieldset>
			</aui:row>
		</aui:fieldset>
	</aui:fieldset-group>
</c:forEach>
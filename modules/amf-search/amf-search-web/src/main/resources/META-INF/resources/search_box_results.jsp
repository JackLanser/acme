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

<liferay-portlet:renderURL varImpl="iteratorURL">
	<liferay-portlet:param name="mvcRenderCommandName" value="<%= MVCCommandNames.LIST_USER %>" />
	<liferay-portlet:param name="zipcode" value="${zip}" />
</liferay-portlet:renderURL>

<liferay-ui:search-container
	delta="5"
	deltaConfigurable="true"
	emptyResultsMessage="no-items"
	iteratorURL="${iteratorURL}"
	total="${userCount}"
>
	<liferay-ui:search-container-results results="${users}" />

	<liferay-ui:search-container-row className="com.liferay.portal.kernel.model.User" modelVar="user">
		<liferay-ui:search-container-column-text
			name="Search Results for ${zip}"
			value="${user.firstName} ${fn:substring(user.lastName, 0 ,1)}. (${user.screenName}) - ${user.emailAddress}"
		/>
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator markupView="lexicon" />
</liferay-ui:search-container>
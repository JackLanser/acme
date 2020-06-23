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

<%@ include file="/./init.jsp" %>
<liferay-ui:tabs
	names="All,Login,Registration"
	param="tab"
	refresh="true"
	tabsValues="All,Login,Registration"
	type="tabs"
	url="${iteratorURL}"
>
	<liferay-ui:search-container
		delta="20"
		deltaConfigurable="true"
		emptyResultsMessage="no-items"
		iteratorURL="${iteratorURL}"
		total="${eventCount}"
	>
		<liferay-ui:search-container-results results="${eventList}" />

		<liferay-ui:search-container-row className="com.liferay.amf.monitor.model.eventMonitorModel" modelVar="entry">
			<liferay-ui:search-container-row-parameter name="tab1" value="${tab}" />

			<liferay-ui:search-container-column-text name="Date" value="${entry.createDate}" />
			<liferay-ui:search-container-column-text name="ScreenName" value="${entry.userName} (${entry.userId})" />
			<liferay-ui:search-container-column-text name="IP Address" value="${entry.userIP}" />
			<liferay-ui:search-container-column-text name="Event Type" value="${entry.eventType}" />
		</liferay-ui:search-container-row>

		<liferay-ui:search-iterator />
	</liferay-ui:search-container>
</liferay-ui:tabs>
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

<portlet:actionURL name="<%= MVCCommandNames.SUBMIT_ZIP %>" var="searchActionURL"></portlet:actionURL>

<liferay-ui:error key="zipCodeNaN" message="error.zip-code-NaN" />
<liferay-ui:error key="zipCodeLength" message="error.zip-code-length" />

<aui:form action="${searchActionURL}">
	<aui:input label="Zip Code" name="zipCode" type="text" />

	<aui:button-row>
		<aui:button name="submitButton" type="submit" value="Search" />
	</aui:button-row>
</aui:form>
<%@ include file="./init.jsp" %>

<liferay-portlet:renderURL varImpl="iteratorURL">
	<liferay-portlet:param  name="mvcRenderCommandName" value="<%=MVCCommandNames.LIST_USER %>" />
</liferay-portlet:renderURL>


<liferay-ui:search-container
		delta="20"
		deltaConfigurable="true"
		emptyResultsMessage="no-items"
		iteratorURL="${iteratorURL}"
		total="100"
	>
		<liferay-ui:search-container-results results="${users}" />

		<liferay-ui:search-container-row className="com.liferay.portal.kernel.model.User" modelVar="user">

			<liferay-ui:search-container-column-text name="Search Results for ${zip}" 
			value="${user.firstName} ${fn:substring(user.lastName, 0 ,1)}. (${user.screenName}) - ${user.emailAddress}" />
	
		</liferay-ui:search-container-row>

		<liferay-ui:search-iterator />
	</liferay-ui:search-container>
	

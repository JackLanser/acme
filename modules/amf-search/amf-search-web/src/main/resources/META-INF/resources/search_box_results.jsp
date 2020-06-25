<%@ include file="./init.jsp" %>

<liferay-portlet:renderURL varImpl="iteratorURL">
	<liferay-portlet:param  name="mvcRenderCommandName" value="<%=MVCCommandNames.LIST_USER %>" />
	<liferay-portlet:param 	name="zipcode" value="${zip}" />
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

			<liferay-ui:search-container-column-text name="Search Results for ${zip}" 
			value="${user.firstName} ${fn:substring(user.lastName, 0 ,1)}. (${user.screenName}) - ${user.emailAddress}" />
	
		</liferay-ui:search-container-row>

		<liferay-ui:search-iterator markupView="lexicon" />
	</liferay-ui:search-container>
	

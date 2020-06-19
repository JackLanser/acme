<%@ include file="./init.jsp"%>


<liferay-ui:tabs type="tabs" names="All,Login,Registration" 
	tabsValues="All,Login,Registration" 
	refresh="true" param="tab" 
	url="${iteratorURL}">

	<liferay-ui:search-container  
		total="${eventCount}"
		delta="20"
		deltaConfigurable="true"
		iteratorURL="${iteratorURL}"
		emptyResultsMessage="no-items">
		<liferay-ui:search-container-results results="${eventList}" />
		<liferay-ui:search-container-row className="com.liferay.amf.monitor.model.eventMonitorModel" modelVar="entry">
			<liferay-ui:search-container-row-parameter name="tab1" value="${tab}"/>
			<liferay-ui:search-container-column-text name="Date" value="${entry.createDate}" />
			<liferay-ui:search-container-column-text name="ScreenName" value="${entry.userName} (${entry.userId})" />
			<liferay-ui:search-container-column-text name="IP Address" value="${entry.userIP}" />
			<liferay-ui:search-container-column-text name="Event Type" value="${entry.eventType}" />
		</liferay-ui:search-container-row>
		<liferay-ui:search-iterator />
	</liferay-ui:search-container>
	
</liferay-ui:tabs>


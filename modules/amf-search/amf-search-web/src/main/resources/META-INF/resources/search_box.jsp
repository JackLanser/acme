<%@ include file="./init.jsp" %>

<portlet:actionURL var="searchActionURL" name="<%=MVCCommandNames.SUBMIT_ZIP %>"></portlet:actionURL>

<liferay-ui:error key="zipCodeNaN" message="error.zip-code-NaN" />
<liferay-ui:error key="zipCodeLength" message="error.zip-code-length" />
<aui:form action="${searchActionURL}">
	<aui:input label="Zip Code" name="zipCode" type="text"/>
	<aui:button-row>
		<aui:button name="submitButton" type="submit" value="Search" />
	</aui:button-row>
</aui:form>
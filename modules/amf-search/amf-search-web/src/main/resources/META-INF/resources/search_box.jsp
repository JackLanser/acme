<%@ include file="./init.jsp" %>

<portlet:actionURL var="searchActionURL" name="<%=MVCCommandNames.SUBMIT_ZIP %>"></portlet:actionURL>


<aui:form action="${searchActionURL}">
	<aui:input label="Zip Code" name="zipCode" type="text"/>
	<aui:button-row>
		<aui:button name="submitButton" type="submit" value="Search" />
	</aui:button-row>
</aui:form>
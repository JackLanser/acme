<%@ include file="/init.jsp" %>

<portlet:renderURL var="renderURL">
	<portlet:param name="mvcRenderCommandName" value="<%=MVCCommandNames.VIEW_ISSUE %>"/>
</portlet:renderURL>


	<c:forEach var="issue" items="${issues}">
		<aui:fieldset-group markupView="lexicon">
			<aui:fieldset markupView="lexicon">
				<aui:row>
					<h4>Issue: #${issue.issueNumber}, ${fn:substring(issue.issueDate, 0, 10)} ${fn:substring(issue.issueDate,24, 28)}</h4>
				</aui:row>
				<aui:row>
					<h1>${issue.title}</h1>
				</aui:row>
				<aui:row>
					<p>${issue.description}</p>
				</aui:row>
			</aui:fieldset>
		</aui:fieldset-group>
	</c:forEach>

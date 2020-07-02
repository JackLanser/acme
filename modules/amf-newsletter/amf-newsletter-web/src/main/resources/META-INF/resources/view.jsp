<%@ include file="/init.jsp" %>


<c:forEach var="issue" items="${issues}">

	<portlet:renderURL var="viewArticlesURL">
		<portlet:param name="mvcRenderCommandName" value="<%=MVCCommandNames.VIEW_ARTICLE_LIST %>"/>
		<portlet:param name="issueNumber" value="${issue.key.issueNumber}"/>
		<portlet:param name="issueId" value="${issue.key.issueId}"/>
	</portlet:renderURL>
	
	<aui:fieldset-group markupView="lexicon">
		<a href="${viewArticlesURL}" style="text-decoration: none; color: black;"/>
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
					<c:forEach var="article" items="${issue.value}">
						<aui:row>
							<h6>${article.title}</h6>
						</aui:row>
					</c:forEach>
				</aui:fieldset>
			</aui:row>
		</aui:fieldset>
	</aui:fieldset-group>
</c:forEach>

<%@ include file="/init.jsp" %>



<h4>Issue: #${issue.issueNumber}, ${fn:substring(issue.issueDate, 0, 10)} ${fn:substring(issue.issueDate,24, 28)}</h4>
<h1>${issue.title}</h1>
<hp>${byline}</p>
<c:forEach var="article" items="${articles}">
	<h3>${article.title}</h3>	
	<h5>${article.content}</h5>
</c:forEach>
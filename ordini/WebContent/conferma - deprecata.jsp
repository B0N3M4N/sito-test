<%
	String username = (String)session.getAttribute("username");
	if(username != null){
%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="CDN.html" %>
<link rel="stylesheet" href="css/style.css">
<meta charset="ISO-8859-1">
<title>Registrazione</title>
</head>
<body>
<jsp:include page="nav.jsp"/>
<div class="containter">
	<div class="page-header">
		<h3>Registrazione effettuata</h3>
	</div>
</div>
<footer class="footer"><%@include file="footer.html" %></footer>

</body>
</html>
<% } %>
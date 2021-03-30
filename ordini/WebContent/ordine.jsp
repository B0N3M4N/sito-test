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
<title>Conferma ordine</title>
</head>
<body>
	<jsp:include page="nav.jsp" />
	<div class="container">
	<div class="page-header">
		<h3>Ordine confermato</h3>
	</div>
	<p>Codice ordine: &nbsp;<%= session.getAttribute("idordine") %></p>
	<% session.removeAttribute("carrello"); %>
	<p>Per tornare agli acquisti: </p>
	<a href="acquisti.jsp">Pagina articoli</a>
	</div>
	<footer class="footer"><%@include file="footer.html" %></footer>
</body>
</html>
<%
	} else {
	response.sendRedirect("accessonegato.jsp");
	}
%>
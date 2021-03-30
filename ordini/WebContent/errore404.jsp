<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/CDN.html" %>
<link rel="stylesheet" href="/<%= application.getServletContextName() %>/css/style.css">
<meta charset="ISO-8859-1">
<title>Error 404</title>
</head>
<body>
<jsp:include page="nav.jsp"/>
<div class="containter">
	<div class="page-header">
		<h3>Pagina non trovata</h3>
	</div>
	<div class="panel panel-danger">
	<div class="panel-heading">
		<h3>Risorsa non disponibile</h3>
	</div>
	<div class="panel-body">
		<p>Contattare l'amministratore: &nbsp;<a href="mailto:admin@site.com">admin@site.com</a></p>
		<p>Torna alla pagina precedente: &nbsp;<input type="button" class="btn btn-default" value="Indietro" onclick="window.history.back()"></p>
	</div>
	</div>
</div>
<footer class="footer"><%@include file="footer.html" %></footer>

</body>
</html>
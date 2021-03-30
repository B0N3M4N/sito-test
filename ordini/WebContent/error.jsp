<%@page import="java.io.PrintWriter"%>
<%@page import="java.text.ParseException"%>
<%@page import="com.erict.architecture.dao.DAOException"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="CDN.html" %>
<link rel="stylesheet" href="css/style.css">
<meta charset="ISO-8859-1">
<title>Error page</title>
</head>
<body>
<jsp:include page="nav.jsp"/>
<div class="containter">
	<div class="page-header">
		<h3>Sì è verificato un errore interno all'applicazione</h3>
	</div>
	<% if(exception instanceof ClassNotFoundException){ %>
	
	<div class="panel panel-danger">
	<div class="panel-heading">
		<h3>Errore nella connessione col DB</h3>
	</div>
	<div class="panel-body">
		<p><%= exception.getMessage() %></p>
		<p>Contattare l'amministratore: &nbsp;<a href="mailto:admin@site.com">admin@site.com</a></p>
		<p>Torna alla pagina precedente: &nbsp;<input type="button" class="btn btn-default" value="Indietro" onclick="window.history.back()"></p>
	</div>
	</div>
<% } else if(exception instanceof DAOException) { %>
<div class="panel panel-danger">
	<div class="panel-heading">
		<h3>Eccezione durate l'elaborazione SQL</h3>
	</div>
	<div class="panel-body">
		<p><%= ((DAOException)exception).getMessage() %></p>
		<p>Contattare l'amministratore: &nbsp;<a href="mailto:admin@site.com">admin@site.com</a></p>
		<p>Torna alla pagina precedente: &nbsp;<input type="button" class="btn btn-default" value="Indietro" onclick="window.history.back()"></p>
	</div>
	</div>
<% } else if(exception instanceof ParseException) { %>
<div class="panel panel-danger">
	<div class="panel-heading">
		<h3>Eccezione nella conversione della Data</h3>
	</div>
	<div class="panel-body">
		<p><%= exception.getMessage() %></p>
		<p>Contattare l'amministratore: &nbsp;<a href="mailto:admin@site.com">admin@site.com</a></p>
		<p>Torna alla pagina precedente: &nbsp;<input type="button" class="btn btn-default" value="Indietro" onclick="window.history.back()"></p>
	</div>
	</div>
<% } else { %>
	<div class="panel panel-danger">
	<div class="panel-heading">
		<h3>Eccezione non prevista</h3>
		<p><%= exception.getClass().getSimpleName() %></p>
	</div>
	<div class="panel-body">
		<p><%= exception.getMessage() %></p>
		<p><% exception.printStackTrace(new PrintWriter(out)); %> </p>
		<p>Contattare l'amministratore: &nbsp;<a href="mailto:admin@site.com">admin@site.com</a></p>
		<p>Torna alla pagina precedente: &nbsp;<input type="button" class="btn btn-default" value="Indietro" onclick="window.history.back()"></p>
	</div>
	</div>
<% } %>
</div>
<footer class="footer"><%@include file="footer.html" %></footer>

</body>
</html>
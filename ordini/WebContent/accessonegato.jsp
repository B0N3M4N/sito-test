<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="CDN.html" %>
<link rel="stylesheet" href="css/style.css">
<meta charset="ISO-8859-1">
<title>Accesso negato</title>
</head>
<body>
<jsp:include page="nav.jsp"/>
<div class="containter">
	<div class="page-header">
		<h3>Non puoi accedere a questa pagina</h3>
	</div>
	<div class="panel panel-danger">
	<div class="panel-heading">
		<h3>Risorsa non disponibile</h3>
	</div>
	<div class="panel-body">
		<p>Per accedere alla pagina:</p>
		<p>Effettuare il login: &nbsp;<a href="login.jsp">Login</a></p>
		<p>Registrarsi: &nbsp;<a href="registra.jsp">Registrazione</a></p>
	</div>
	</div>
</div>
<footer class="footer"><%@include file="footer.html" %></footer>

</body>
</html>
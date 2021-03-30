<%
	String username = (String)session.getAttribute("username");
	if(username != null){
		session.invalidate();
%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="CDN.html" %>
<link rel="stylesheet" href="css/style.css">
<meta charset="ISO-8859-1">
<title>Logout</title>
</head>
<body>
<jsp:include page="nav.jsp"/>
<div class="containter">
	<div class="page-header">
		<h3>Logout dalla sessione</h3>
	</div>
	<div class="panel panel-danger">
	<div class="panel-heading">
		<h3>Sei uscito dalla sessione</h3>
	</div>
	<div class="panel-body">
		<p>Per accedere nuovamente alla pagina: </p>
		<p>Effettuare il login: &nbsp;<a href="login.jsp">Login</a></p>
	</div>
	</div>
</div>
<footer class="footer"><%@include file="footer.html" %></footer>

</body>
</html>
<%
	} else {
	response.sendRedirect("accessonegato.jsp");
	}
%>
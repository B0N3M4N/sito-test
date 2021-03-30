<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="CDN.html" %>
<link rel="stylesheet" href="css/style.css">
<meta charset="ISO-8859-1">
<title>Login utente</title>
<script src="js/convalida.js"></script>
</head>
<body>
<jsp:include page="nav.jsp"/>
<div class="containter">
	<div class="page-header">
		<h3>Inserire i dati per il login</h3>
	</div>
	<form action="/<%=application.getServletContextName()%>/controllo"
   method="post" id="userForm" class="form-horizontal">
	
	
	<!-- ---------------------------USERNAME -->
	<div class="form-group">
	<label class="col-md-1 control-label">Username</label>
	<div class="col-md-4 inputGroupContainer">
		<div class="input-group">
			<span class="input-group-addon">
				<i class="glyphicon glyphicon-user"></i>
			</span>
			<input type="text" name="username" id="username" placeholder="Username..." class="form-control" maxlength="10" autocomplete="username" required>
		</div>
	</div>
		<div class="col-md-7 control-label" id="infoUsername"></div>
	</div>
	
	<!-- ---------------------------PASSWORD -->
	<div class="form-group">
	<label class="col-md-1 control-label">Password</label>
	<div class="col-md-4 inputGroupContainer">
		<div class="input-group">
			<span class="input-group-addon">
				<i class="glyphicon glyphicon-lock"></i>
			</span>
			<input type="password" name="password" id="password" placeholder="Password..." class="form-control" maxlength="20" autocomplete="new-password" required>
		</div>
	</div>
		<div class="col-md-7 control-label" id="infoPassword"></div>
	</div>
		
	<div class="row">
		<div class="col-md-4 col-md-offset-1">
			<button type="submit" class="btn btn-warning">
				Login&nbsp;<span class="glyphicon glyphicon-send"></span>
			</button>
		</div>
	</div>
	</form>
</div>
<footer class="footer"><%@include file="footer.html" %></footer>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="CDN.html" %>
<link rel="stylesheet" href="css/style.css">
<meta charset="ISO-8859-1">
<title>Registrazione</title>
<script src="js/convalida.js"></script>
</head>
<body>
<jsp:include page="nav.jsp"/>
<div class="containter">
	<div class="page-header">
		<h3>Registrazione nuovo utente</h3>
	</div>
	<form action="/<%=application.getServletContextName()%>/salvadati"
   method="post" id="userForm" class="form-horizontal">
	
	<!-- ---------------------------NOME -->
	<div class="form-group">
	<label class="col-md-1 control-label">Nome</label>
	<div class="col-md-4 inputGroupContainer">
		<div class="input-group">
			<span class="input-group-addon">
				<i class="glyphicon glyphicon-user"></i>
			</span>
			<input type="text" name="nome" id="home" placeholder="Nome..." class="form-control"  maxlength="30">
		</div>
	</div>
		<div class="col-md-7 control-label" id="infoNome"></div>
	</div>
	
	<!-- ---------------------------COGNOME -->
	<div class="form-group">
	<label class="col-md-1 control-label">Cognome</label>
	<div class="col-md-4 inputGroupContainer">
		<div class="input-group">
			<span class="input-group-addon">
				<i class="glyphicon glyphicon-user"></i>
			</span>
			<input type="text" name="cognome" id="home" placeholder="Cognome..." class="form-control"  maxlength="30">
		</div>
	</div>
		<div class="col-md-7 control-label" id="infoCognome"></div>
	</div>
	
	<!-- ---------------------------INDIRIZZO -->
	<div class="form-group">
	<label class="col-md-1 control-label">Indirizzo</label>
	<div class="col-md-4 inputGroupContainer">
		<div class="input-group">
			<span class="input-group-addon">
				<i class="glyphicon glyphicon-home"></i>
			</span>
			<textarea cols="50" rows="3" name="indirizzo" id="indirizzo" placeholder="Indirizzo..." class="form-control" style="resize: none" maxlength="30"></textarea>
		</div>
	</div>
		<div class="col-md-7 control-label" id="infoIndirizzo"></div>
	</div>
	
	<!-- ---------------------------CAP -->
	<div class="form-group">
	<label class="col-md-1 control-label">Cap</label>
	<div class="col-md-4 inputGroupContainer">
		<div class="input-group">
			<span class="input-group-addon">
				<i class="glyphicon glyphicon-home"></i>
			</span>
			<input type="text" name="cap" placeholder="CAP..." class="form-control" maxlength="5">
		</div>
	</div>
		<div class="col-md-7 control-label" id="infoCap"></div>
	</div>
	
	<!-- ---------------------------NASCITA -->
	<div class="form-group">
	<label class="col-md-1 control-label">Nascita</label>
	<div class="col-md-4 inputGroupContainer">
		<div class="input-group date" id="dp">
			<span class="input-group-addon">
				<i class="glyphicon glyphicon-calendar"></i>
			</span>
			<input type="text" name="nascita" id="nascita" placeholder="DD/MM/YYYY..." class="form-control" maxlength="10">
		</div>
	</div>
		<div class="col-md-7 control-label" id="infoNascita"></div>
	</div>
	<script>
		$(function(){
			$('#dp').datepicker({
				format: 'dd/mm/yyyy',
				autoclose: true,
				startDate: '01/01/1900',
				endDate: new Date()
			})
		}).on(
				'changeDate',
				function(e){
					$('#userForm').bootstrapValidator(
						'revalidateField', 'nascita'		
					)
				});
	</script>
	
	<!-- ---------------------------USERNAME -->
	<div class="form-group">
	<label class="col-md-1 control-label">Username</label>
	<div class="col-md-4 inputGroupContainer">
		<div class="input-group">
			<span class="input-group-addon">
				<i class="glyphicon glyphicon-user"></i>
			</span>
			<input type="text" name="username" id="username" placeholder="Username..." class="form-control" maxlength="10">
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
			<input type="password" name="password" id="password" placeholder="Password..." class="form-control" maxlength="20">
		</div>
	</div>
		<div class="col-md-7 control-label" id="infoPassword"></div>
	</div>
	
	<!-- ---------------------------EMAIL -->
	<div class="form-group">
	<label class="col-md-1 control-label">Email</label>
	<div class="col-md-4 inputGroupContainer">
		<div class="input-group">
			<span class="input-group-addon">
				<i class="glyphicon glyphicon-envelope"></i>
			</span>
			<input type="text" name="email" id="email" placeholder="Email..." class="form-control" maxlength="30">
		</div>
	</div>
		<div class="col-md-7 control-label" id="infoEmail"></div>
	</div>
	
	<div class="row">
		<div class="col-md-4 col-md-offset-1">
			<button type="submit" class="btn btn-warning">
				Registrati&nbsp;<span class="glyphicon glyphicon-send"></span>
			</button>
		</div>
	</div>
	</form>
</div>
<footer class="footer"><%@include file="footer.html" %></footer>
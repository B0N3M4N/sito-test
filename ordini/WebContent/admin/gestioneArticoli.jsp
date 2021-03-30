<%
	String username = (String)session.getAttribute("admin");
	if(username == null)
		response.sendRedirect("../login.jsp");
	else{		
%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:useBean id="carrello" class="com.erict.businesscomponent.bean.Carrello" scope="session"/>
<%@page import="com.erict.businesscomponent.model.Articolo"%>
<%@page import="com.erict.businesscomponent.ClientFacade"%>
<%
	String query = request.getParameter("q");
	Articolo[] articoli = null;
	if(query != null)
		articoli = ClientFacade.getInstance().searchArticoli(query);
	else
		articoli = ClientFacade.getInstance().getArticoli();
%>
<!DOCTYPE html>
<html>
<head>
<%@include file="../CDN.html" %>
<link rel="stylesheet" href="../css/style.css">
<meta charset="ISO-8859-1">
<title>Gestione Articoli</title>
</head>
<body>
<jsp:include page="nav.jsp"/>
<div class="containter">
	<div class="page-header">
		<h3>Articoli presenti disponibili</h3>
	</div>
	<div class="row">
		<div class="form-group col-md-6">
			<form id="q_form">
				<div class="input-group">
				<input type="text" class="form-control" name="q" value="<%= query == null ? "" : query%>">
				<span class="btn btn-default">
				<button class="btn btn-default" type="submit">
				<span class="glyphicon glyphicon-search"></span>
				</button>
				</span>
				</div>
			</form>
			</div>
			</div>
			
			<div class="table-responsive">
	<table class="table table-hover" style="width:100%;">
		<thead>
			<tr>
			<th style="width:200px;">Marca</th>
			<th style="width:200px;">Modello</th>
			<th style="width:200px;">Prezzo</th>
			<th style="width:200px;">&nbsp;</th>
			<th style="width:200px;">&nbsp;</th>
			<th style="width:0px;"></th>
			</tr>
		</thead>
		<tbody>
<%
	for(Articolo a : articoli){
%>
	<tr>
	<td><%= a.getMarca() %></td>
	<td><%= a.getModello() %></td>
	<td><%= String.format("%.2f",a.getPrezzo()) %>&euro;</td>
	<td>
	<button type="button" class="btn btn-info btn-xs" data-toggle="modal" data-target="#editModal_<%=a.getIdArticolo()%>">
		<span class="glyphicon glyphicon-pencil"></span>
	</button>
	</td>
	<td>
	<form action="/<%=application.getServletContextName()%>/rimuoviArticolo?id=<%=a.getIdArticolo()%>" method="post">
	<button type="submit" class="btn btn-danger btn-xs">
		<span class="glyphicon glyphicon-pencil"></span>
	</button>
	</form>
	</td>
	<jsp:include page="editArticoloModal.jsp">
		<jsp:param value="<%=a.getIdArticolo()%>" name="id"/>
	</jsp:include>
	</tr>
	<% 
		} 
	%>
	</tbody>
	</table>
	</div>
	</div>
	<footer class="footer"><%@include file="footer.html" %></footer>
	</body>
</html>
<% } 

%>
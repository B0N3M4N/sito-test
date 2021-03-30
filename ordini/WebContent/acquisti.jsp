<%@page import="com.erict.businesscomponent.model.Articolo"%>
<%@page import="com.erict.businesscomponent.ClientFacade"%>
<%
	String username = (String)session.getAttribute("username");
	if(username != null){
%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:useBean id="carrello" class="com.erict.businesscomponent.bean.Carrello" scope="session"/>
<!DOCTYPE html>
<html>
<head>
<%@include file="CDN.html" %>
<link rel="stylesheet" href="css/style.css">
<meta charset="ISO-8859-1">
<title>Acquisti</title>
</head>
<body>
<jsp:include page="nav.jsp"/>
<div class="containter">
	<div class="page-header">
		<h3>Scelta articoli</h3>
	</div>
	<p>Totale carrello:&nbsp;<%= String.format("%.2f",carrello.totaleComplessivo()) %></p>
	<div class="table-responsive">
	<table class="table table-hover" style="width:100%;">
		<thead>
			<tr>
			<th>id</th>
			<th>Marca</th>
			<th>Modello</th>
			<th>Prezzo</th>
			<th>Ordine</th>
			</tr>
		</thead>
		<tbody>
			<%
				Articolo[] a = ClientFacade.getInstance().getArticoli();
				for(int i = 0; i<a.length; i++){
			%>
				<tr>
				<td><%= a[i].getIdArticolo() %></td>
				<td><%= a[i].getMarca() %></td>
				<td><%= a[i].getModello() %></td>
				<td><%= String.format("%.2f",a[i].getPrezzo()) %>&euro;</td>
				<td>
				<form action="/<%=application.getServletContextName()%>/aggiungi" method="post">
				<input type="hidden" name="id" value="<%= a[i].getIdArticolo() %>">
				<input type="hidden" name="marca" value="<%= a[i].getMarca() %>">
				<input type="hidden" name="modello" value="<%= a[i].getModello() %>">
				<input type="hidden" name="prezzo" value="<%= a[i].getPrezzo() %>">
				<button type="submit" class="btn btn-primary btn-xs">Aggiungi</button>
				</form>
				</td>
				</tr>
				<% } %>
				</tbody>
			</table>
			<hr>
			<a href="visualizza.jsp">Riepilogo dati </a>
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
<%
	String username = (String)session.getAttribute("username");
	if(username != null){
%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:useBean id="carrello" class="com.erict.businesscomponent.bean.Carrello" scope="session"/>
<%@page import="java.util.Enumeration"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="CDN.html" %>
<link rel="stylesheet" href="css/style.css">
<meta charset="ISO-8859-1">
<title>Riepilogo acquisti</title>
</head>
<body>
<jsp:include page="nav.jsp"/>
<div class="containter">
	<div class="page-header">
		<h3>Riepilogo dati del carrello</h3>
	</div>
	<p>Totale carrello:&nbsp;<%= String.format("%.2f",carrello.totaleComplessivo()) %></p>
	<div class="table-responsive">
	<table class="table table-hover" style="width:100%;">
		<thead>
			<tr>
			<th style="width:200px;">Marca</th>
			<th style="width:200px;">Modello</th>
			<th style="width:200px;">Parziale</th>
			<th style="width:200px;">Quantit&agrave;</th>
			<th style="width:200px;">Rimuovi</th>
			</tr>
		</thead>
		<tbody>
			<%
				Enumeration<String[]> articoli = carrello.getProdotti();
				while(articoli.hasMoreElements()){
					String[] prodotto = articoli.nextElement();
				%>
			<tr>
				<td><%= prodotto[0] %></td>
				<td><%= prodotto[1] %></td>
				<td><%= String.format("%.2f",carrello.totaleParziale(prodotto[4])) %></td>
				<td><%= prodotto[3] %></td>
				<td>
					<form action="/<%=application.getServletContextName()%>/rimuovi?id=<%= prodotto[4]%>" method="post">
						<button type="submit" class="btn btn-danger btn.xs">Rimuovi</button>
					</form>
					</td>
					</tr>
				<%
					}
				%>
				</tbody>
				</table>
				</div>
				<hr>
				<a href="acquisti.jsp">Torna alla scelta degli articoli</a>
				<%
					if(carrello.getArticoli() != 0){
				%>
				<div class="panel panel-success" style="margin-top : 50px;">
					<div class="panel-heading">
					<h4><strong>Conferma ordine</strong></h4>
					<div style="text-align: right;">Totale articoli nel carrello:
					<%= carrello.getArticoli() %>
					</div>
					</div>
					<div class="panel-body">
					<form action="/<%=application.getServletContextName()%>/conferma" method="post">
   <button type="submit" class="btn btn-success">
    &#10003; Acquista prodotti
   </button>
   </form>
   </div>
  </div>
  <%
   }
  %>  
</div>
<footer class="footer"><%@include file="footer.html" %></footer>
</body>
</html>
<%
} else {
 response.sendRedirect("accessonegato.jsp");
}
%>
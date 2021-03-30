<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="CDN.html"%>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/style.css">

<title>Home Page</title>

</head>
<body>
 <jsp:include page="nav.jsp" />
 <div class="well"
  style="background-image: url('img/b.jpg'); background-repeat: repeat-x;">
  <h3 style="color: #FFF">Negozio on-line</h3>
  
 <p>
  <a class="btn btn-primary btn-lg" href="registra.jsp" role="button">
   Registrati gratis &raquo; </a>
 </p>
 </div>

 <div class="container">
  <div>
   <div id="myCarousel" class="carousel slide" data-ride="carousel">
    <ol class="carousel-indicators">
     <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
     <li data-target="#myCarousel" data-slide-to="1"></li>
     <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>

    <div class="carousel-inner">
     <div class="item active">
      <img src="img/iphone.jpg" alt="Apple iPhone">
     </div>

     <div class="item">
      <img src="img/s20.jpg" alt="Samsung s20">
     </div>

     <div class="item">
      <img src="img/airpods.jpg" alt="Apple airpods">
     </div>
    </div>

    <a class="left carousel-control" href="#myCarousel" data-slide="prev"> 
    <span class="glyphicon glyphicon-chevron-left"></span> 
    <span class="sr-only">Previous</span>
    </a> <a class="right carousel-control" href="#myCarousel"
    data-slide="next"> 
    <span class="glyphicon glyphicon-chevron-right"></span> 
    <span class="sr-only">Next</span>
    </a>
   </div>
  </div>
  
 </div>
 
 <footer class="footer"><%@ include file="footer.html"%></footer>
 
</body>
</html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel=stylesheet type=text/css href=styles.css media=all>
<title>Welcome to SimulaFin!</title>
</head>
<body>
<div class=topnav><a class=plaina href="welcome">SimulaFin</a></div>
<div class=catnav> 
  <p style="font-size:2em;font-weight:bold;color:rgba(255, 255, 255, 0.8);">Users</p>
  <nav>
  	<ul>
      <li><a href="finduser">Find User</a></li>
      <li><a href="usercreate">Create User</a></li>
      <li><a href="userupdate">Update User Password</a></li>
      <li><a href="updateemail">Update User Email</a></li>
      <li><a href="updateaddress">Update User Address</a></li>
      <li><a href="userdelete">Delete User</a></li>
      
    </ul>
  </nav>
</div>
<div class=catnav>
  <p style="font-size:2em;font-weight:bold;color:rgba(255, 255, 255, 0.8);">Portfolios</p>
    <nav>
      <ul>
      <li><a href="findportfolio">Find Portfolio</a></li>
      <li><a href="portfoliocreate">Create Portfolio</a></li>
      <li><a href="portfoliodelete">Delete Portfolio</a></li>
      <li><a href="portfolioupdate">Update Portfolio</a></li>
      </ul>
    </nav>
</div>
<div class=catnav>
  <p style="font-size:2em;font-weight:bold;color:rgba(255, 255, 255, 0.8);">Stocks</p>
    <nav>
      <ul>
       <li><a href="findstock">Find Stock</a></li>
      <li><a href="findhistorical_price">Find Historical Prices</a></li>
      </ul>
    </nav>
</div>
</body>

</html>

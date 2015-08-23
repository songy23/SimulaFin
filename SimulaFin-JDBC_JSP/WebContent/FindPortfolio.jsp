<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel=stylesheet type=text/css href=styles.css media=all>
<title>Find Portfolio</title>
</head>
<body>
<div class=topnav><a class=plaina href="welcome">SimulaFin</a></div>
	<form action="findportfolio" method="post">
		<h1>Search for Portfolios by UserName</h1>
		<p>
			<label for="userName">UserName</label>
			<input id="userName" name="userName" value="${fn:escapeXml(param.userName)}" type=text>
		</p>
		<p>
			<input type="submit">
			<br/><br/><br/>
			<span id="successMessage"><b>${messages.success}</b></span>
		</p>
	</form>
	<br/>
	<br/>
	
	<h1>User's Portfolios</h1>
        <table border="1">
            <tr>
                <th>Portfolio_Id</th>
                <th>UserName</th>
                <th>Portfolio_Name</th>
                <th>Update</th>
                <th>Delete</th>
            </tr>
            <c:forEach items="${portfolios}" var="portfolio" >
	            <tr>
	  
	                <td><c:out value="${portfolio.getPortfolio_Id()}" /></td>
	                <td><c:out value="${portfolio.getUserName()}" /></td>
	                <td><a href="findportfolio_stock?portfolio_id=<c:out value="${portfolio.getPortfolio_Id()}" />"><c:out value="${portfolio.getPortfolio_Name()}" /></a></td>
	            	<td><a href="portfolioupdate?Portfolio_Id=<c:out value="${portfolio.getPortfolio_Id()}" />">Update Portfolio</a></td>
	            	<td><a href="portfoliodelete?portfolio_ID=<c:out value="${portfolio.getPortfolio_Id()}" />">Delete Portfolio</a></td>
	            </tr> 
	        </c:forEach>
		    
	</table>
</body>
</html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel=stylesheet type=text/css href=styles.css media=all>
<title>Find Portfolio Stocks</title>
</head>
<body>
<div class=topnav><a class=plaina href="welcome">SimulaFin</a></div>
	<form action="findportfolio_stock" method="post">
		<h1>Search for Portfolio_Stocks by Portfolio_ID</h1>
		<p>
			<label for="portfolio_id">Portfolio_ID</label>
			<input id="portfolio_id" name="portfolio_id" value="${fn:escapeXml(param.portfolio_id)}" type=text>
		</p>	
		<br/>
		<p>
			<input type="submit">
			<br/><br/><br/>
			<span id="successMessage"><b>${messages.success}</b></span>
		</p>
	</form>
	<br/>
	
	<h1>Portfolio's Stocks</h1>
        <table border="1">
            <tr>
                <th>Portfolio_Id</th>
                <th>Portfolio_Stock_Id</th>
                <th>Ticker</th>
                <th>ShareAmount</th>
                <th>Update</th>
                <th>Delete</th>
            </tr>
            <c:forEach items="${portfolio_stocks}" var="portfolio_stock" >
	            <tr>	  
	                <td><c:out value="${portfolio_stock.getPortfolio_Id()}" /></td>
	                <td><c:out value="${portfolio_stock.getPortfolio_Stock_Id()}" /></td>
	                <td><a href="findstock?ticker=<c:out value="${portfolio_stock.getTicker()}" />"><c:out value="${portfolio_stock.getTicker()}" /></a></td>
	                <td><c:out value="${portfolio_stock.getShareAmount()}" /></td>
	                <td><a href="portfolio_stockupdate?Portfolio_Stock_Id=<c:out value="${portfolio_stock.getPortfolio_Stock_Id()}" />">Update</a></td>
	                <td><a href="portfolio_stockdelete?Portfolio_Stock_ID=<c:out value="${portfolio_stock.getPortfolio_Stock_Id()}" />">Delete</a></td>
	            </tr> 
	        </c:forEach>
	</table>
</body>
</html>
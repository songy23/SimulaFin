<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel=stylesheet type=text/css href=styles.css media=all>
<title>Find a User</title>
</head>
<body>
<div class=topnav><a class=plaina href="welcome">SimulaFin</a></div>
	<form action="findstockbyindustry" method="post">
		<h1>Search for Stocks by Industry</h1>
		<p>
			<label for="Industry">Industry</label>
			<input id="Industry" name="Industry" value="${fn:escapeXml(param.Industry)}" type=text>
		</p>
		<p>
			<input type="submit">
			<br/><br/><br/>
			<span id="successMessage"><b>${messages.success}</b></span>
		</p>
	</form>
	
	<h1>Matching Stocks</h1>
        <table border="1">
            <tr>
                <th>Ticker</th>
                <th>Industry</th>
            </tr>
            <c:forEach items="${stocks}" var="stock" >
	            <tr>
	                <td><a href="findstock?ticker=<c:out value="${stock.getTicker()}" />"><c:out value="${stock.getTicker()}" /></a></td>
	                <td><c:out value="${stock.getIndustry()}" /></td>
	            </tr> 
	         </c:forEach>
	</table>
</body>
</html>
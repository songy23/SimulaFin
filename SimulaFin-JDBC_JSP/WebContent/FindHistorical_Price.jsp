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
	<form action="findhistorical_price" method="post">
		<h1>Search for Historical Prices of a Stock</h1>
		<p>
			<label for="Ticker">Ticker</label>
			<input id="Ticker" name="Ticker" value="${fn:escapeXml(param.Ticker)}" type=text>
		</p>
		<p>
			<input type="submit">
			<br/><br/><br/>
			<span id="successMessage"><b>${messages.success}</b></span>
		</p>
	</form>
	<br/>
	<br/>
	<h1>Matching Historical Prices</h1>
        <table border="1">
            <tr>
                <th>Ticker</th>
                <th>Date</th>
                <th>Open</th>
                <th>High</th>
                <th>Low</th>
                <th>Close</th>
                <th>Volume</th>
            </tr>
            <c:forEach items="${historical_Prices}" var="historical_Price" >
                <tr>
                    <td><c:out value="${historical_Price.getTicker()}" /></td>
                    <td><fmt:formatDate value="${historical_Price.getDate()}" pattern="yyyy-MM-dd"/></td>
                    <td><c:out value="${historical_Price.getOpen()}" /></td>
                    <td><c:out value="${historical_Price.getHigh()}" /></td>
                    <td><c:out value="${historical_Price.getLow()}" /></td>
                    <td><c:out value="${historical_Price.getClose()}" /></td>
                    <td><c:out value="${historical_Price.getVolume()}" /></td>
                </tr>
            </c:forEach>
	        
       </table>
</body>
</html>

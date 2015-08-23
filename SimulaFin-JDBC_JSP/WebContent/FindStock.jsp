<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel=stylesheet type=text/css href=styles.css media=all>
<title>Find Stock</title>
</head>
<body>
<div class=topnav><a class=plaina href="welcome">SimulaFin</a></div>
	<form action="findstock" method="post">
		<h1>Search for a Stock by its Ticker Symbol</h1>
		<p>
			<label for="ticker">Ticker</label>
			<input id="ticker" name="ticker" value="${fn:escapeXml(param.ticker)}" type=text>
		</p>
		<p>
			<input type="submit">
			<br/><br/><br/>
			<span id="successMessage"><b>${messages.success}</b></span>
		</p>
	</form>
	<br/>
	
	
	<h1>Matching Stock</h1>
        <table border="1">
            <tr>
                <th>Ticker</th>
                <th>Industry</th>
                <th>Yearly_range</th>
                <th>Market Capitalization</th>
                <th>Price/Earning Ratio</th>
                <th>Dividend Yield</th>
                <th>Earnings Per Share</th>
                <th>Shares</th>
                <th>Beta</th>
                <th>Institution Ownership</th>
            </tr>
            <tr>
                <td><a href="findhistorical_price?Ticker=<c:out value="${stock.getTicker()}" />"><c:out value="${stock.getTicker()}" /></a></td>
                <td><a href="findstockbyindustry?Industry=<c:out value="${stock.getIndustry()}" />"><c:out value="${stock.getIndustry()}" /></a></td>
                <td><c:out value="${stat.getYearly_range()}" /></td>
                <td><c:out value="${stat.getMktCap()}" /></td>
                <td><c:out value="${stat.getP_E()}" /></td>
                <td><c:out value="${stat.getDiv_yield()}" /></td>
                <td><c:out value="${stat.getEPS()}" /></td>
                <td><c:out value="${stat.getShares()}" /></td>
                <td><c:out value="${stat.getBeta()}" /></td>
                <td><c:out value="${stat.getInstOwn()}" /></td>
            </tr> 

	</table>
	<button class="myButton" onclick="window.open('portfolio_stockcreate')">Add to Portfolio</button>
	<button class="myButton" onclick="window.open('portfoliocreate')">Create Portfolio</button>
	
</body>
</html>

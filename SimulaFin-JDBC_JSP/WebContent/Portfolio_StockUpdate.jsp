<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel=stylesheet type=text/css href=styles.css media=all>
<title>Welcome to SimulaFin!</title>
</head>
<body>
<div class=topnav><a class=plaina href="welcome">SimulaFin</a></div>
	<h1>Update a Stock in a Portfolio with new Ticker and Share Amount</h1>
	<form action="portfolio_stockupdate" method="post">
		<p>
			<label for="Portfolio_Stock_Id">Portfolio_Stock_Id</label>
			<input id="Portfolio_Stock_Id" name="Portfolio_Stock_Id" value="${fn:escapeXml(param.Portfolio_Stock_Id)}">
		</p>
		<p>
			<label for="Ticker">New Ticker</label>
			<input id="Ticker" name="Ticker" value="">
		</p>
		<p>
			<label for="ShareAmount">New ShareAmount</label>
			<input id="ShareAmount" name="ShareAmount" value="">
		</p>
		<p>
			<input type="submit">
		</p>
	</form>
	<br/><br/>
	<p>
		<span id="successMessage"><b>${messages.success}</b></span>
	</p>
</body>
</html>
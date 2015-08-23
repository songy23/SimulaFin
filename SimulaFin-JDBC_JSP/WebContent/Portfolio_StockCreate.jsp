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
	<h1>Create Portfolio_Stock</h1>
	<form action="portfolio_stockcreate" method="post">
		<p>
			<label for="Portfolio_ID">Portfolio_ID</label>
			<input id="Portfolio_ID" name="Portfolio_ID" value="${fn:escapeXml(param.Portfolio_ID)}" type=text>
		</p>
		<p>
			<label for="Ticker">Ticker</label>
			<input id="Ticker" name="Ticker" value="${fn:escapeXml(param.Ticker)}" type=text>
		</p>
		<p>
			<label for="ShareAmount">ShareAmount</label>
			<input id="ShareAmount" name="ShareAmount" value="" type=text>
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
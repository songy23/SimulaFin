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
	<h1>Create Portfolio</h1>
	<form action="portfoliocreate" method="post">
		<p>
			<label for="userName">userName</label>
			<input id="userName" name="userName" value="" type=text>
		</p>
		<p>
			<label for="portfolio_Name">portfolio_Name</label>
			<input id="portfolio_Name" name="portfolio_Name" value="" type=text>
		</p>
		<p>
			<input type="submit">
		</p>
		
		<br/>
	</form>
	<br/><br/>
	<p>
		<span id="successMessage"><b>${messages.success}</b></span>
	</p>
</body>
</html>
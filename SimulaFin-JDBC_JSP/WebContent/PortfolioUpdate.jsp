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
	<h1>Update a Portfolio's Name</h1>
	<form action="portfolioupdate" method="post">
		<p>
			<label for="Portfolio_Id">Portfolio_Id</label>
			<input id="Portfolio_Id" name="Portfolio_Id" value="${fn:escapeXml(param.Portfolio_Id)}" type=text>
		</p>
		<p>
			<label for="Portfolio_Name">New Portfolio_Name</label>
			<input id="Portfolio_Name" name="Portfolio_Name" type=text>
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
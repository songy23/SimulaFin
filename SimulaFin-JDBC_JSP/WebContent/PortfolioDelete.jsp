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
	<h1>${messages.title}</h1>
	<form action="portfoliodelete" method="post">
		<p>
				<label for="portfolio_ID">Portfolio_ID</label>
				<input id="portfolio_ID" name="portfolio_ID" value="${fn:escapeXml(param.portfolio_ID)}" type=text>
		</p>
		<p>
			<span id="submitButton" <c:if test="${messages.disableSubmit}"></c:if>>
			<input type="submit">
			</span>
		</p>
	</form>
	<br/><br/>
	
</body>
</html>
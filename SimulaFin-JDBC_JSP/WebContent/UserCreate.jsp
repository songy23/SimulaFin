<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel=stylesheet type=text/css href=styles.css media=all>
<title>Welcome to SimulaFin!</title>
</head>
<body>
<div class=topnav><a class=plaina href="welcome">SimulaFin</a></div>
	<h1>Create User</h1>
	<form action="usercreate" method="post">
		<p>
			<label for="username">UserName</label>
			<input id="username" name="username" value="" type=text>
		</p>
		<p>
			<label for="password">Password</label>
			<input id="password" name="password" value="" type=text>
		</p>
		<p>
			<label for="gender">Gender</label>
			<input id="gender" name="gender" value="" type=text>
		</p>
		<p>
			<label for="address">Address</label>
			<input id="address" name="address" value="" type=text>
		</p>
		<p>
			<label for="email">Email</label>
			<input id="email" name="email" value="" type=text>
		</p>
		<p>
			<label for="profession">Profession</label>
			<input id="profession" name="profession" value="" type=text>
		</p>
		<p>
			<label for="education_level">Education Level</label>
			<input id="education_level" name="education_level" value="" type=text>
		</p>
		<p>
			<label for="dob">DoB (yyyy-mm-dd)</label>
			<input id="dob" name="dob" value="" type=text>
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
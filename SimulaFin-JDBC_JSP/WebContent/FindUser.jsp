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
	<form action="finduser" method="post">
		<h1>Search for a User by UserName</h1>
		<p>
			<label for="userName">UserName</label>
			<input id="userName" name="userName" value="${fn:escapeXml(param.userName)}" type=text>
		</p>
		<p>
			<input type="submit">
			<br/><br/><br/>
			<span id="successMessage"><b>${messages.success}</b></span>
		</p>
	</form>
	<br/>
	<div id="userCreate"><a href="usercreate">Create User</a></div>
	<br/>
	<h1>Matching User</h1>
        <table border="1">
            <tr>
                <th>UserName</th>
                <th>DoB</th>
                <th>Gender</th>
                <th>Address</th>
                <th>Email</th>
                <th>Profession</th>
                <th>Education Level</th>
                <th>User Portfolios</th>
                <th>Delete User</th>
                <th>Update User</th>
            </tr>
            <tr>
                <td><c:out value="${user.getUser_Name()}" /></td>
                <td><fmt:formatDate value="${user.getDoB()}" pattern="yyyy-MM-dd"/></td>
                <td><c:out value="${user.getGender()}" /></td>
                <td><a href="updateaddress?userName=<c:out value="${user.getUser_Name()}" />"><c:out value="${user.getAddress()}" /></a></td>
                <td><a href="updateemail?userName=<c:out value="${user.getUser_Name()}" />"><c:out value="${user.getEmail()}" /></a></td>
                <td><c:out value="${user.getProfession()}" /></td>
                <td><c:out value="${user.getEducation_Level()}" /></td>
                <td><a href="findportfolio?userName=<c:out value="${user.getUser_Name()}"/>">Portfolios</a></td>
                <td><a href="userdelete?username=<c:out value="${user.getUser_Name()}"/>">Delete</a></td>
                <td><a href="userupdate?userName=<c:out value="${user.getUser_Name()}"/>">Update Password</a></td>
            </tr> 

	</table>
</body>
</html>

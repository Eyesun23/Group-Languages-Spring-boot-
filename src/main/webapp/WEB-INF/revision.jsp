<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit Language</title>
<style>
	.header {
	margin-left: 1100px;
	margin-top: 30px;
	
	}
	
	.editForm {
		margin-left: 200px;
	
	}
	
	h1 {
		text-align: center;
	}

</style>
</head>
<body>
	<div class="header">
		<a href="/language/delete/${index}">Delete</a>
		<a href="/">Dashboard</a>
	</div>
	<h1>Please Edit <c:out value="${language.name}" /></h1>
	<div class="editForm">
		<form action="/language/update/${index}" method="post">
			<label for="name">Name: </label><input type="text" value="${language.name}" name="name" />
			<label for="creator">Creator: </label><input type="text" value="${language.creator}" name="creator" />
			<label for="version">Version: </label><input type="text" value="${language.version}" name="version" />
			<button type="submit">Update Language</button>
		</form>
	</div>
</body>
</html>
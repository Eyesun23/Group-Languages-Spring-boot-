<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Languages</title>
<style>
	h1 {
		text-align: center;	
		margin-top: 50px;
	
	}
	
	h3 {
		text-align: center;	
	
	}

</style>
</head>
<body>
	<h1><c:out value="${language.name}" /></h1>
	<h3>Creator: <c:out value="${language.creator}" /></h3>
	<h3>Version: <c:out value="${language.version}" /></h3>
</body>
</html>
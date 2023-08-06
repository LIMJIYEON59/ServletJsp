<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
	<h1>로그인</h1>
	<form action="<%=request.getContextPath()%>/login" method="post">
		<input type="text" name="mid"> 
		<input type="password" name="mpass"> <input type="submit">
	</form>
</body>
</html>
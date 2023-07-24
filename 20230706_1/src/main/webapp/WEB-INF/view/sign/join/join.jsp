<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
	<h1>회원가입</h1>
	<form action=" <%=request.getContextPath()%>/join" method="post"> <!--포스트를 쓸 때:전달되는 데이터 양이 많거나 비밀스러울 때  -->
	<input type="text" name="mid">
	<input type="password" name="mpass">
	<input type="text" name="mnickname">
		<input type="submit">
	</form>
</body>
</html>
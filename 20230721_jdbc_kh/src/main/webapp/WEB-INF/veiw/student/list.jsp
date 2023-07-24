<%@page import="kh.test.jdbckh.student.model.vo.StudentVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생 리스트</title>
</head>
<body>
	<h2>학생 리스트</h2>
	<%
	// JSP Tag <%...이다 여기 안에는 자바문법을 따르면된다.
	String a = (String)request.getAttribute("aaa");
	String b = (String)request.getAttribute("bbb");
	int c = (int)request.getAttribute("ccc"); //()괄호 안에 int나 Integer 쓴다.
	List<StudentVo> volist = (List<StudentVo>)request.getAttribute("studentList");
	%>
	<!-- 이제 화면에 뿌려보겠다. (주석처리 하나씩 해야함) -->
	<%-- <%=a %> --%>
	<%-- <%=b %> --%>
	<%-- <%=c %> --%>
	<%-- <%= volist %> --%>
	<table border= "1">
		<tr>
			<td>학번</td>
			<td>이름</td>	
			<td>입학일</td>	
		</tr>
		<%
		for(int i=0; i<volist.size(); i++){
			 StudentVo vo = volist.get(i);
		%>	
		
		<!-- tr td는 html꺼라 < % 안에 들어갈 수가 없다 -->
		<!-- 클릭시 이동 -->
		<tr> 
			<td><a href="<%=request.getContextPath()%>/student/get?sno=<%=vo.getStudentNO()%>"><%=vo.getStudentNO()%></a></td>
			<td><%=vo.getStudentName()%></td>	
			<td><%=vo.getEntranceDate()%></td>	
		</tr>
		 
		
		<%
		}
		%>			
	</table>
	
</body>
</html>

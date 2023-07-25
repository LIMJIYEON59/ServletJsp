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
	<div>
		<from action="<%=request.getContextPath() %>/student/List" method="get">
			<input type="search" name="searchWord">
			<input type="submit" value="찾기">
		</fotm>
	</div>

	
	<%
	// JSP Tag <%...이다 여기 안에는 자바문법을 따르면된다.
	List<StudentVo> volist = (List<StudentVo>)request.getAttribute("studentList");
	String searchWord = (String)request.getAttribute("studentList");
	if(searchWord != null){
		%>
		<h3><%=searchWord %>검색결과</h3>
		<h5><a href="<%=request.getContextPath() %>/student/List">전체보기</a></h5>
		<%
	}
	if(volist == null || volist.size() == 0) {
	//if(volist == null) P
	//if(volist.size() == 0) {
	%>
	<h2>결과물이 없습니다.</h2>		
	<%
	}else{
	%>
	
	<table border= "1">
		<tr>
			<td>학생 번호</td>
			<td>학과 번호</td>
			<td>학생 이름</td>	
			<td>학생 주소</td>	
			<td>입학일</td>	
			<td>휴학일</td>	
			<td>지도 교수 번호</td>	
		</tr>
		<%
		for(int i=0; i<volist.size(); i++){
			 StudentVo vo = volist.get(i);
		%>	
		
		<!-- tr td는 html꺼라 < % 안에 들어갈 수가 없다 -->
		<!-- 클릭시 이동 -->
		<tr> 
			<td>
			<a href="<%=request.getContextPath()%>/student/get?sno=<%=vo.getStudentNO()%>">
			<%=vo.getStudentNO()%>
			</a></td>			
			<td>
			<a href="<%=request.getContextPath()%>/student/get?sno=<%=vo.getStudentNO() %>">
			<%=vo.getStudentName() %>
			</a>
			</td>
			<td><%=vo.getEntranceDate() %></td>
			<td><%=vo.getStudentAddress() %></td>
		</tr>	
		<%
		}	//for
		%>	
				
	</table>
	
	
	<div>
	<%
	for(int i=1; i<=10; i++) {
	%>
		<a href="<%=request.getContextPath()%>/student/list?pageNo=<%=i%>"><span><%=i%></span></a>
		,
	<%
	}  //for
	%>
	</div>
	<%
	}  //else
	%>
	
</body>
</html>

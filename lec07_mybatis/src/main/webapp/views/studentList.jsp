<%@page import="com.gn.dao.StudentDao"%>
<%@page import="com.gn.dto.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		StudentDao dao = new StudentDao();  // 객체 생성
		List<Student> list = dao.selectAll(); // 학생 목록 조회
	    for(Student st : list) {
	%>
	    <p>
	        번호: <%= st.getStudentNo() %> <br>
	        이름: <%= st.getStudentName() %> <br>
	        나이: <%= st.getStudentAge() %>
	    </p>
	<%
	    }
	%>
	
</body>
</html>
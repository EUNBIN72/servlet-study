<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>include 연습</title>
</head>
<body>
	<h2>=== start ===</h2>
	<%@ include file="scripting_element.jsp" %>
	<h2>=== end ===</h2>
	<% int multiple = sum * 3; %>
	<!-- scripting_element.jsp 의 내용을  전부 가져와서 sum이라는 변수 사용 가능 -->
	<p>계산 결과 : <%= multiple %></p>
</body>
</html>
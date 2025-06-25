<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	String message = (String)request.getAttribute("writer");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>익명 처리하기</title>
</head>
<body>
	<h1>익명</h1>
	<p><%= message %></p>

</body>
</html>
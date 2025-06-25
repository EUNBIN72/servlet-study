<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	String user_phone = (String)request.getAttribute("user_phone"); 
	String user_email = (String)request.getAttribute("user_email"); 
	int bookPrice = (int)request.getAttribute("bookPrice");
	String bookTitle = (String)request.getAttribute("bookTitle"); 
	int borrow_period = (int)request.getAttribute("borrow_period");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>도서 대출 내역</h1>
	<h4>[고객 정보]</h4>
	<ul>
		<li>고객명: <%= request.getAttribute("user_name") %></li>
		<li>전화번호: <%= user_phone %></li>
		<li>이메일: <%= user_email %></li>
	</ul>
	
	<h4>[대출 정보]</h4>
	<ul>
		<li>도서 제목: <%= bookTitle %></li>
		<li>대출 기간: <%= borrow_period %>일</li>
	</ul>
	
	<h3>대출 금액:  <%= bookPrice %>원</h3>

</body>
</html>
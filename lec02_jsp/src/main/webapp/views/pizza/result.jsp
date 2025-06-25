<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String user_name = (String)request.getAttribute("user_name"); 
	String user_phone = (String)request.getAttribute("user_phone"); 
	String user_email = (String)request.getAttribute("user_email"); 
	String pizza_size = (String)request.getAttribute("pizza_size");
	String[] pizza_topping = (String[])request.getAttribute("pizza_topping");
	Integer pizza_price = (Integer)request.getAttribute("pizza_price");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>주문내역</h1>
<h4>[고객정보]</h4>
<ul>
	<li>성함 : <%= user_name %></li>
	<li>전화번호 : <%= user_phone %></li>
	<li>이메일 : <%= user_email %></li>
</ul>
<h4>[주문정보]</h4>
<ul>
	<li>
		사이즈 : <%= pizza_size %>
	</li>
	<li>
		토핑 : 
		<ul>
			<% for(int i = 0; i < pizza_topping.length; i++){ %>
			<li><%= pizza_topping[i] %></li>
		<% } %>
			
		</ul>
	</li>
</ul>
<h4>위와 같이 주문하셨습니다.</h4>
<h3>총 가격 : <%= pizza_price %>원</h3>
<h4>즐거운 식사 시간되세요~</h4>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>스크립팅</title>
</head>
<body>
	<%-- Scriptlet : 일반적인 자바 코드 --%>
	<% 
		int sum = 0;
		for (int i = 1; i <= 10; i++) {
			sum += i;
		}
		out.println("총합 : " + sum);  // 내장객체
		// System.out.println으로 쓰게 되면 콘솔에만 출력됨
	%>
	<br>
	<%-- Expression : (화면에) 출력 --%>  
	<%= "총합 : " + sum %>
	<br>
	<%-- Declaration : 선언 --%>
	<%! int visitCount = 0; %>
	
	<%
		int tempCount = 0;
		visitCount++;
		tempCount++;
	%>
	<p>선언 태그 : <%= visitCount %></p>
	<p>스크립틀릿 : <%= tempCount %></p>
</body>
</html>
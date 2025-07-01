<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>별 출력 결과</title>
</head>
<body>

	<%
	    String countStr = request.getParameter("count");
	    int count = 0;

       	count = Integer.parseInt(countStr);
	    request.setAttribute("count", count);
	%>

	<h2>별 계단 출력 결과</h2>

    <c:forEach var="i" begin="1" end="${count}">
	    <c:forEach var="j" begin="1" end="${i}">
	            ⭐
	    </c:forEach>
   		<br>
    </c:forEach>

</body>
</html>
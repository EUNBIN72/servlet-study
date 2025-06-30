<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>mybatis</title>
</head>
<body>
	<!-- 1. index.jsp에 목록조회 a태그 생성 
		 2. 목록조회 요청을 받는 Servlet(Controller) 
		 3. Service에 정보 전달
		 4. DAO에 데이터베이스 연결 요청
		 5. Mapper에 있는 쿼리 실행 -->
		 
	<ol>
		<li>
			<a href="<c:url value='/student/list'/>">학생 목록 조회</a>
		</li>
	</ol>
		 
		 
	<h2>과제) JSTL의 forEach 사용하여 별찍기</h2>
    <form action="views/star.jsp" method="get">
        <label>숫자를 선택하세요: </label>
        <select name="count">
            <c:forEach var="i" begin="1" end="5">
                <option value="${i}">${i}</option>
            </c:forEach>
        </select>
        <button type="submit">출력하기</button>
    </form>


</body>
</html>
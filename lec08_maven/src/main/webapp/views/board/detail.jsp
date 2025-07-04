<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 상세 보기</title>
</head>
<body>
	<p>제목 : ${b.boardNo }</p>
	<p>작성자 : ${b.boardWriter } </p>
	<p>내용 : ${b.boardContent } </p>
	<p>작성일 : ${b.regDate } </p>
	
	<c:if test="${not empty attach }">
	    <h4>첨부파일</h4>
	    <img src="C://upload/board/***"><br>
	    <a href="C://upload/board/***">*** 다운로드</a>
	</c:if>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키, 세션</title>
</head>
<body>
	<h1>Cookie</h1>
	<ul>
		<li>
			<a href="/makeCookie">쿠키 생성</a>
		</li>
		<li>
			<a href="/editCookie">쿠키 수정</a>
		</li>
		<li>
			<a href="/deleteCookie">쿠키 삭제</a>
		</li>
		<li>
			<a href="/practiceCookie">쿠키 연습하기</a>
		</li>
	</ul>
	<h2>현재 쿠키 값 확인</h2>
	<!-- 자바 코드(스크립틀릿) -->
	<%  //
		// 1. 클라이언트가 보낸 쿠키 배열 가져오기
		Cookie[] cookies = request.getCookies();
		String userId = "쿠키 없음";
	
		// 2. 쿠키 배열에서 원하는 쿠키 찾기
		if(cookies != null) {
			for(Cookie c : cookies) {
				if (c.getName().equals("user_id")) {
					userId = c.getValue();
					break;
				}
			}
		}
	%>
	<p>user_id 쿠키값 : <%= userId %></p>
	<br>
	<a href="/changePage">방문 횟수 추적하기</a>
	
	
	<h1>Session</h1>
	<ol>
		<li>
			<a href="/createSession">세션 생성</a>
		</li>
		<li>
			<a href="/updateSession">세션 수정</a>
		</li>
		<li>
			<a href="/removeSession">세션 삭제</a>
		</li>
	</ol>
	
	<%
		String memberId = "세션 없음";
		// session이 null이 아니면
		if (session != null) {
			if (session.getAttribute("member_id") != null) {
				memberId = (String)session.getAttribute("member_id");
			}
		}
	%>
	<p>세션 정보 : <%= memberId %></p>
</body>
</html>
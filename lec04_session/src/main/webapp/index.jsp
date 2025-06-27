<%@page import="com.gn.dto.Account"%>
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
	<li>
		<a href="/changePage">방문 횟수 추적하기</a>
	</li>
	
	
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
	

	<%
		Account account = null;
		if (session != null) {
			// 사용자의 아이디가 admin이고, 비밀번호가 admin1234일 때 : account 정보와 같을 때
			if (session.getAttribute("account") != null) {
				// 정상 로그인
				Account a = (Account)session.getAttribute("account");
	%>
		<p><%= a.getName() %> 님 환영합니다!<p>
		<a href="/logout">로그아웃</a>
		
	<%
			} else {
	%>
		<!-- 정보를 servlet에 넘겨주려면 name값을 만들어야 됨 -->
		<form action="/login" method="post">
			<label for="account_id">아이디 : </label>
			<input type="text" name="login_id" id="account_id"><br>
			<label>비밀번호 : </label>
			<input type="password" name="login_pw" id="account_id">
			<input type="submit" value="로그인">
		</form>
	<%
			}
		}
		
	 %> <br>


		
	<form action="/productList" multiple="multiple" method="post">
		<select name="products">
			<option value="키보드">키보드</option>
			<option value="마우스">마우스</option>
			<option value="모니터">모니터</option>
		</select>
	    <button type="submit">장바구니 추가</button>
	</form>
	
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<!-- 
			1. 사용자 닉네임 입력
			2. 쿠키에 저장
			3. 쿠키 삭제
		 -->
	<h2>닉네임</h2>
	<form action = "/saveNick" method="post">
		<input type="text" id="user_Nick" name="user_Nick">
		<button type="submit">닉네임 저장</button>
	</form>
	
	<% 
		String userNick = "______";
		Cookie[] cookies = request.getCookies();
	
		// 2. 쿠키 배열에서 원하는 쿠키 찾기
		if(cookies != null) {
			for(Cookie c : cookies) {
				if (c.getName().equals("user_Nick")) {
					userNick = c.getValue();
					break;
				}
			}
		}
	%>
	
	<p>닉네임 :<%= userNick %></p>
	
	<form action = "/removeNick" method="post">
		<button type="submit">닉네임 삭제</button>
	</form>

</body>
</html>
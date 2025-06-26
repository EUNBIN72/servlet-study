<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 방문 횟수를 저장하는 쿠키를 생성합니다.
쿠키의 key값은 visit_count입니다.
쿠키의 유효기간은 1일입니다.
한번 방문할때마다 쿠키의 값을 1증가시킵니다.
사용자에게 현재 방문 횟수를 아래와 같이 보여주세요. -->

	<%
    // 기본 방문 횟수를 1로 설정
    int count = 1;

    // 기존 쿠키 배열 가져오기
    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
        for (Cookie cookie : cookies) {
            if ("visit_count".equals(cookie.getName())) {
                // 쿠키에서 이전 방문 횟수 가져오기
                count = Integer.parseInt(cookie.getValue()) + 1;
            }
        }
    }
			
			
			
	%>
	


	<p> 당신은 이 페이지를
		<strong> 숫자 <%= count %></strong>번 방문했습니다.
	</p>
</body>
</html>
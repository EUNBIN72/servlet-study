<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>방명록 화면</title>
</head>
<body>

	<!-- 
		1. 이름과 메시지를 입력받음
		<등록> 버튼 클릭 시 AJAX의 POST 방식으로 서버에 요청
	 -->
	 <h1>방명록</h1>
	 <form action = "/guestList" method="post">
		 <label for="guest_Name">이름 : </label>
		<input type="text" id="guest_Name" name="guest_Name">
		<br>
		<label for="guest_Message">메시지 : </label>
		<input type="text" id="guest_Message" name="guest_Message">
		<button type="submit" id="register_btn">등록</button>
	</form>
	
	
	
	
	<ul>
		<li></li>
	</ul>
	
	
	

</body>
</html>
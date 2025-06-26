package com.gn.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/editCookie")
public class EditCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public EditCookieServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// user_id 라는 name을 가진 쿠키의 value를 admin으로 수정
		Cookie c = new Cookie("user_id", "user02");
		
		// 기존과 동일한 유지 시간 설정
		c.setMaxAge(60 * 60 * 24);
		
		response.addCookie(c);
		// => index.jsp 화면에서 <쿠키 수정> 클릭 후 새로고침 했을 때 변경된 아이디 화면 노출
		// 뒤로 돌아가는 것은 새로고침은 아님
		// 쿠키를 수정하고 메인화면에서 변경된걸 확인하려면 뒤로 돌아가서 새로고침을 해줘야 됨(root path에서 새로고침)
		
		// sendRedirect : 브라우저가 새로운 요청을 다시 보내게 하는 메소드
		// 매개 변수로 작성된 url에 다시 요청을 보냄
		response.sendRedirect("/");  // root path를 다시 요청하는 것임
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

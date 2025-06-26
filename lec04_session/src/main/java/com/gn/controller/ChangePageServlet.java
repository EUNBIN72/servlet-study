package com.gn.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/changePage")
public class ChangePageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ChangePageServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		방문 횟수를 저장하는 쿠키를 생성합니다.
//		쿠키의 key값은 visit_count입니다.
		Cookie c = new Cookie("visit_count", Integer.toString(visit_count));
		
//		쿠키의 유효기간은 1일입니다.
		c.setMaxAge(60 * 60 * 24);
		
//		한번 방문할때마다 쿠키의 값을 1증가시킵니다.
//		사용자에게 현재 방문 횟수를 아래와 같이 보여주세요.
		response.addCookie(c);
		
		//ChangePageServlet은 /views/countPage.jsp 페이지로 화면 전환하는 기능이 있습니다
		response.sendRedirect("/views/countPage.jsp");
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

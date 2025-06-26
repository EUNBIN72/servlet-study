package com.gn.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/deleteCookie")
public class DeleteCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
    public DeleteCookieServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 삭제하고 싶은 쿠키와 같은 key로 쿠키 생성
		Cookie c = new Cookie("user_id", "");
		
		// 2. 유표기간을 0으로 설정
		c.setMaxAge(0);
		
		// 3. 응답에 추가
		response.addCookie(c);
		
		// 4. 기존에 작업중인 Servlet 종료하고 새로은 요청 발생
		response.sendRedirect("/");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

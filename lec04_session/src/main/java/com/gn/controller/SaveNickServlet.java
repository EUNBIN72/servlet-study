package com.gn.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/saveNick")
public class SaveNickServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SaveNickServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String user_Nick = request.getParameter("user_Nick");
		
		Cookie c =  new Cookie("user_Nick", user_Nick);  // key / Value
		
		// 2. 쿠키 유지 시간 설정(초 단위)
		// 닉네임을 입력한 후 닉네임 저장을 누르면 1시간동안 쿠키 정보가 저장
		c.setMaxAge(60 * 60);  // (60 * 60) = 1시간
		
		// 3. 응답에 쿠키 추가하여 브라우저에 전달
		response.addCookie(c);
		
		// 쿠키 연습하기 화면 전환
		response.sendRedirect("/practiceCookie");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

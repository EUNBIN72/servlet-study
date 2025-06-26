package com.gn.controller;

import java.io.IOException;

import com.gn.dto.Account;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		// 사용자의 아이디가 admin이고, 비밀번호가 admin1234일 때 정상 로그인
		// 정상 로그인 일 경우 session에 account라는 이름으로 사용자 정보를 저장
		
		// 계정 정보 하드코딩
		String correctId = "admin";
		String correctPw = "admin1234";
		String name = "관리자";
		
		// index에서 name 값을 가져와(login_id와 login_pw)
		// 하나의 정보를 가져옴 request.getParameter();
		// 여러개 정보를 가져옴 request.getParameterValues();
		String loginId = request.getParameter("login_id");
		String loginPw = request.getParameter("login_pw");
		
		// 가져온 정보가 원래의 정보와 같으면
		if (loginId.equals(correctId) && loginPw.equals(correctPw)) {
			// session 정보를 만들어
			HttpSession session = request.getSession(true);
			// Account 객체 생성
			// Account의 사용자 아이디와 이름을 a에 저장
			Account a = new Account(loginId, name);
			
			// account라는 객체를  session에 넣음
			session.setAttribute("account", a);
			session.setMaxInactiveInterval(60 * 30);  // 30분(보통 30분임)
		}
		// 화면 전환
		response.sendRedirect("/");
	}
		

		

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

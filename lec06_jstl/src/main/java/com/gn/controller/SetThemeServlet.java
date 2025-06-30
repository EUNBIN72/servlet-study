package com.gn.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/setTheme")
public class SetThemeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public SetThemeServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		// index의 name 값을 키로 받아옴
		// 그걸 변수(p)에 저장해서 사용할거임
		String p = request.getParameter("theme");
		
		request.setAttribute("theme", p);
		
		RequestDispatcher view = request.getRequestDispatcher("/views/sample.jsp");
		view.forward(request, response);
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

package com.gn.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/board/write")
public class ReceiveTitlePrefixServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ReceiveTitlePrefixServlet() {
        super();
    }

      
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("==== 요청 확인 ====");
		String title = request.getParameter("title"); // name이 title인 값이 들어옴
		System.out.println(title);
		
		RequestDispatcher view = getServletContext().getRequestDispatcher("/views/titleShow.jsp");
		request.setAttribute("title", title);
		view.forward(request, response);
	}

 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}

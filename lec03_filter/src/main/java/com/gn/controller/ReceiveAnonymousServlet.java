package com.gn.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/comment/write")
public class ReceiveAnonymousServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ReceiveAnonymousServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String writer = request.getParameter("writer"); // name이 writer인 값이 들어옴
		System.out.println(writer);
		
		RequestDispatcher view = getServletContext().getRequestDispatcher("/views/writerShow.jsp");
		request.setAttribute("writer", writer);
		view.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

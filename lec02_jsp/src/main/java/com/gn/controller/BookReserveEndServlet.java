package com.gn.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/bookReserveEnd")
public class BookReserveEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public BookReserveEndServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String user_name = request.getParameter("user_name");
		String user_phone = request.getParameter("user_phone");
		String user_email = request.getParameter("user_email");
		String book_name = request.getParameter("book_name");
		int borrow_period = Integer.parseInt(request.getParameter("borrow_period"));
		
//		System.out.println(user_name);
//		System.out.println(user_phone);
//		System.out.println(user_email);
//		System.out.println(book_name);
//		System.out.println(borrow_period);
		
		String bookTitle = "";
		int bookPrice = 0;
		
		switch(book_name) {
		case "1" : 
			bookTitle = "자바 프로그래임 입문";
			bookPrice = 1500 +500 * (borrow_period - 1);
			break;
		case "2" : 
			bookTitle = "웹 개발의 기초";
			bookPrice = 1800 +500 * (borrow_period - 1);
			break;
		case "3" :
			bookTitle = "데이터베이스 시스템";
			bookPrice = 2000 +500 * (borrow_period - 1);
			break;
		}
		
		request.setAttribute("user_name", user_name);
		request.setAttribute("user_phone", user_phone);
		request.setAttribute("user_email", user_email);
		request.setAttribute("borrow_period", borrow_period);
		request.setAttribute("bookTitle", bookTitle);
		request.setAttribute("bookPrice", bookPrice);
		
		RequestDispatcher view
		 = request.getRequestDispatcher("views/book/confirm.jsp");
		view.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

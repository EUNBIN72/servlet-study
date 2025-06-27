package com.gn.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.gn.dto.Product;


@WebServlet("/productList")
public class ProdutListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ProdutListServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Product> list = new ArrayList<Product>();
		list.add(new Product(1001, "키보드", 25000));
		list.add(new Product(1002, "마우스", 15000));
		list.add(new Product(1003, "모니터", 180000));
		
		// 요청 객체에 속성을 추가 / 데이터 저장 가능
		// list의 값들을 productList로 사용 가능하다
		request.setAttribute("productList", list);
		
		
		RequestDispatcher view = request.getRequestDispatcher("/views/productList.jsp");
	    view.forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

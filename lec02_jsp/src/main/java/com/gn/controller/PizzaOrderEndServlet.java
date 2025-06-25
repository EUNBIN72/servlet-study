package com.gn.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/pizzaOrderEnd")
public class PizzaOrderEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PizzaOrderEndServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");  // 인코딩

		String user_name = request.getParameter("user_name");
		String user_phone = request.getParameter("user_phone");
		String user_email = request.getParameter("user_email");

		String pizza_size = request.getParameter("pizza_size");
		String[] pizza_topping = request.getParameterValues("pizza_topping");

		int[] pizza_size_price = {15900, 21000, 27900};
		int[] pizza_topping_price = {2000, 1000};

//		System.out.println(user_name);
//		System.out.println(user_phone);
//		System.out.println(user_email);
//		System.out.println(pizza_size);
//		System.out.println(pizza_topping);
		
		
		int sizePrice = 0;
		int toppingPrice = 0;

		if (pizza_size != null) {
			switch (pizza_size) {
				case "1":
					pizza_size = "small";
					sizePrice = pizza_size_price[0];
					break;
				case "2":
					pizza_size = "medium";
					sizePrice = pizza_size_price[1];
					break;
				case "3":
					pizza_size = "large";
					sizePrice = pizza_size_price[2];
					break;
			}
		}

//		if ("1".equals(pizza_topping)) {
//			pizza_topping = ""
//			toppingPrice = Integer.parseInt(pizza_topping_price[0]);
//		} else {
//			toppingPrice = Integer.parseInt(pizza_topping_price[1]);
//		}
		
		String[] top = new String[pizza_topping.length];
		
		for (int i = 0; i < pizza_topping.length; i++) {
			if ("1".equals(pizza_topping[i])) {
				toppingPrice += pizza_topping_price[0];
				top[i] = "새우";
			} else if ("2".equals(pizza_topping[i])) {
				toppingPrice += pizza_topping_price[1];
				top[i] = "고구마";
			} else if ("3".equals(pizza_topping[i])) {
				toppingPrice += pizza_topping_price[1];
				top[i] = "감자";
			} else if ("4".equals(pizza_topping[i])) {
				toppingPrice += pizza_topping_price[1];
				top[i] = "파인애플";
			}
		}

		int pizza_price = sizePrice + toppingPrice;

		request.setAttribute("user_name", user_name);
		request.setAttribute("user_phone", user_phone);
		request.setAttribute("user_email", user_email);
		request.setAttribute("pizza_price", pizza_price);
		request.setAttribute("pizza_size", pizza_size);
		request.setAttribute("pizza_topping", top);

		RequestDispatcher view = request.getRequestDispatcher("views/pizza/result.jsp");
		view.forward(request, response);

		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

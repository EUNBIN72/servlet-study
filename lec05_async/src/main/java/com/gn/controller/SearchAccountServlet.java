package com.gn.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.gn.dto.Account;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/searchAccount")
public class SearchAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SearchAccountServlet() {
        super();
    }

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 3. Servlet에 Account List 목록에서
		// 해당 이름이 존재하는지 확인
		// 이름이 포함된 사람 목록을 응답받아
		List<Account> list = new ArrayList<Account>();
		list.add(new Account(1, "김철수"));
		list.add(new Account(2, "이영희"));
		list.add(new Account(3, "홍길동"));
		list.add(new Account(4, "김가남"));

		// 이름을 가져와서
		String name = request.getParameter("name");
		
		
		// 아래서 사용하기 위해 밖으로 빼내줌
//		JSONObject obj = new JSONObject();
		
		
		// 배열의 목록 만들기
		JSONArray arr = new JSONArray();
		
		// 해당 이름이 존재하는지 확인
		for(Account a : list) {
			// 배열을 꺼내오기
			if(a.getName().contains(name)) {
				JSONObject obj = new JSONObject();
				obj.put("no", a.getNo());
				obj.put("name", a.getName());
				arr.add(obj);
			}
			
			
			
//			if(a.getName().equals(name)) {
//				obj.put("no", a.getNo());
//				obj.put("name", a.getName());
//			}
		}
		
		// 껍데기 만들고 위에 내용을 담아줌
		JSONObject result = new JSONObject();
		result.put("arr", arr);
		
		
		
		response.setContentType("application/json; charset=utf-8");
//		response.getWriter().print(obj);
		
		response.getWriter().print(result);
				
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

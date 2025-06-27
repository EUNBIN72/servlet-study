package com.gn.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.gn.dto.Account;
import com.gn.dto.Book;

@WebServlet("/searchBook")
public class SearchBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SearchBookServlet() {
        super();
    }

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Book> list = new ArrayList<Book>();
        list.add(new Book(1, "자바의 정석", "김철수"));
        list.add(new Book(2, "스프링 입문", "이순신"));
        list.add(new Book(3, "MySQL 실습", "홍길동"));
        list.add(new Book(4, "웹 개발 가이드", "유관순"));
		
		// 도서 이름을 가져와서
		String name = request.getParameter("name");
		
		// 배열 목록 만들기
		JSONArray arr = new JSONArray();
		
		// 해당 도서 이름이 존재하는지 확인
		for(Book b : list) {
			// 배열을 꺼내오기
			if(b.getName().contains(name)) {
				JSONObject obj = new JSONObject();
				obj.put("no", b.getNo());
				obj.put("name", b.getName());
				obj.put("author", b.getAuthor());
				arr.add(obj);
			}
		}
		
		// 껍데기를 만들고 위에 내용을 담아줌
		JSONObject result = new JSONObject();
		result.put("arr", arr);
		
		// 응답의 콘텐츠 타입을 설정
		// application/json : 클라이언트에게 응답 데이터가 JSON 형식임을 알림
		// charset=utf-8 : 문자 인코딩 방식이 UTF-8임을 지정
		// 이 설정을 하지 않으면, 클라이언트가 데이터를 잘못 해석할 수 있음
		response.setContentType("application/json; charset=utf-8");
		
		// 클라이언트에게 데이터를 전송
		// response.getWriter()는 PrintWriter 객체를 반환하며, 이를 통해 문자열 데이터를 출력할 수 있음
		// result 변수에 들어있는 값을 클라이언트에게 보냄
		// 이 result는 일반적으로 JSON 문자열임 (예: {"status":"ok", "message":"Success"})
		response.getWriter().print(result);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

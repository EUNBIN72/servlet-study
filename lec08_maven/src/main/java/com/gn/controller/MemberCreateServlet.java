package com.gn.controller;

import java.io.IOException;

import org.json.simple.JSONObject;

import com.gn.service.MemberService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/memberCreate")
public class MemberCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private  MemberService service = new MemberService();
       

    public MemberCreateServlet() {
        super();
    }

    // a태그라서 get방식으로 들어옴
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/views/member/create.jsp").forward(request, response);
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// POST 방식이니까 인코딩 먼저
		request.setCharacterEncoding("utf-8");
		
		// 정보 받아옴
		String id = request.getParameter("memberId");
		String pw = request.getParameter("memberPw");
		System.out.println(id + " : " + pw);
		
		// Service에  정보 들고 가서 -> Dao -> Interface -> mapper 
		JSONObject obj = new JSONObject();
		obj.put("res_code", "500");
		obj.put("res_msg", "회원가입 중 오류가 발생했습니다.");
		
		int result = service.insertMember(id, pw);
		
		if (result > 0) {
			obj.put("res_code", "200");
			obj.put("res_msg", "회원가입 성공!!");
		} 
		
		response.setContentType("application/json; charset=utf-8");
		response.getWriter().print(obj);
		
	}

}

package com.gn.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.gn.dto.Student;
import com.gn.service.StudentService;


@WebServlet("/student/delete")
public class StudentDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentService service = new StudentService();
       

    public StudentDeleteServlet() {
        super();
    }

    // a태그는 무조건 get으로 옴
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 화면단에서 전달받은 정보 가져오기
		int no = Integer.parseInt(request.getParameter("no"));
//		System.out.println(no);
		
		// service한테 부탁해서 deleteStudent
		// 번호 주면서 부탁
		// 결과는 int 형태로 반환
		int result = service.deleteStudent(no);
		
		// 만약에 결과가 0보다 크면 : 목록 화면 전환 다시 요청 (sendRedirect)
		// 0보다 크지 않다면 : 수정 화면 재요청 -> 반드시 쿼리 스트링 사용!!
		if(result > 0) { 
			response.sendRedirect("/student/list");
		} else {
			response.sendRedirect("/student/detail?no="+ no);
		}
	}
	


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}

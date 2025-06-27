package com.gn.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/postResultAjax")
public class PostResultAjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PostResultAjaxServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 요청 데이터 인코딩
		request.setCharacterEncoding("UTF-8");
		
		// 값 가져오기(파라미터 수집)
		// 계산하기 위해 int 자료형으로 가져옴
		int kor = Integer.parseInt(request.getParameter("kor"));
		int eng = Integer.parseInt(request.getParameter("eng"));
		int math = Integer.parseInt(request.getParameter("math"));
		
		// 연산 처리 : 총점, 평균, 합격여부
		int total = (kor + eng + math);
		double avg = total / 3.0;
//		double avg = (double)total / 3;
		
		// 서버에서 총점과 평균, 그리고 합격 여부를 계산하여 반환
	
		// 
		PrintWriter out = response.getWriter();
		
		// 모든 과목이 40점 이상이고, 평균이 60점 이상인 경우 합격
		// 삼항 연산자
//		String result = ((avg >= 60) && (kor>=40) && (eng>=40) && (math>=40)) ? "합격" : "불합격";
		
		if ((avg >= 60) && (kor>=40) && (eng>=40) && (math>=40)) {
			out.print("총점: "+ total + "  평균: " + String.format("%.2f", avg) + "  합격입니다.");
		} else {
			out.print("총점: "+ total + "  평균: " + String.format("%.2f", avg) + "  과락입니다.");
		}
	
		
		
		// 응답 설정
        response.setContentType("text/plain; charset=UTF-8");
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

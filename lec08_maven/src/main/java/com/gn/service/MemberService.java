package com.gn.service;

import java.util.List;

import com.gn.dao.MemberDao;
import com.gn.dto.Board;
import com.gn.dto.Member;

public class MemberService {
	// DAO한테 부탁해서 DB에서 정보 조회, 등록, 수정, 삭제
	private MemberDao dao = new MemberDao();

	public int insertMember(String memberId, String memberPw) {
		// DTO(Member)
		// 바구니에 담아(여기서 바구니 이름이 param임)
		Member param = new Member();
		param.setMemberId(memberId);
		param.setMemberPw(memberPw);

		// dao가서 부탁
		return dao.insertMember(param);
	}
	

	// 1. service : 바구니 옮겨담아서 dao 한테 전달하기
	// 2. dao : 인터페이스한테 db 연결 요청하기
	// 3. Mapper : mapper.xml한테 쿼리 호출하기
	// 4. xml : select * 쿼리 구성 + resultMap (memberResultMap)
	public Member selectMember(String id, String pw) {
		Member param = new Member();
		param.setMemberId(id);
		param.setMemberPw(pw);
		
		Member result = dao.selectMember(param);
		return result;
	}
		


	
	
	
	

}

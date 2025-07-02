package com.gn.service;

import com.gn.dao.MemberDao;
import com.gn.dto.Member;

public class MemberService {
	// DAO한테 부탁해서 DB에서 정보 조회, 등록, 수정, 삭제
	private MemberDao dao = new MemberDao();

	public int insertMember(String id, String pw) {
		// DTO(Member)
		Member param = new Member();
		param.setMemberId(id);
		param.setMemberPw(pw);

		return dao.insertMember(param);
	}
	
	
	
	

}

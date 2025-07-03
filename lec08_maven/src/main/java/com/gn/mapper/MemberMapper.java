package com.gn.mapper;

import com.gn.dto.Member;

public interface MemberMapper {
	
	Member insertMember(Member param);
	
	Member selectMember(Member param);

}

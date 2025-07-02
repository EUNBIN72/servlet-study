package com.gn.mapper;

import com.gn.dto.Member;

// Mapper는 SQL 쿼리문을 정의하고 실행하는 공간
public interface BoardMapper {
	
	Member insert(Member param);

}

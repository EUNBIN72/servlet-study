package com.gn.mapper;

import java.util.List;

import com.gn.dto.Attach;
import com.gn.dto.Board;

// Mapper는 SQL 쿼리문을 정의하고 실행하는 공간
public interface BoardMapper {
	
	List<Board> selectBoardList(Board param);
	
	int selectBoardCount();
	
	int insertBoard(Board param);
	
	int insertAttach(Attach param);
}

package com.gn.mapper;

import java.util.List;

import com.gn.dto.Student;


//Mapper는 SQL 쿼리문을 정의하고 실행하는 공간
public interface StudentMapper {
	List<Student> selectAll();
}

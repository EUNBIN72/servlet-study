package com.gn.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.gn.common.SessionTemplate;
import com.gn.dto.Student;

// Student 테이블에 대한 DB 작업을 담당
public class StudentDao {
	
	// Student 객체들의 리스트를 반환하는 메서드
	// 모든 학생 정보를 DB에서 가져오는 역할
	public List<Student> selectAll(){
		
		// 데이터베이스 접근(MyBatis)
		// 1. SqlSession 생성 (MyBatis에서 DB와 연결하기 위한 세션 SqlSession을 생성)
		SqlSession session = SessionTemplate.getSqlSession(true);
		
		// 2. SQL 실행
		List<Student> list = session.selectList("com.gn.mapper.StudentMapper.selectAll");
		
		// 3. 세션 종료
		session.close();
		
		// 4. 결과 반환
		return list;
	}
	
	public Student selectOne(int studentNo) {
		SqlSession session = SessionTemplate.getSqlSession(true);
		Student student = session.selectOne("com.gn.mapper.StudentMapper.selectOne", studentNo);
		session.close();
		return student;
	}
	
	public List<Student> selectOneByName(String studentName) {
		SqlSession session = SessionTemplate.getSqlSession(true);
		List<Student> student = session.selectList("com.gn.mapper.StudentMapper.selectOneByName", studentName);
		session.close();
		return student;
	}
	
	public int insert(Student param) {
		SqlSession session = SessionTemplate.getSqlSession(true);
		int result = session.insert("com.gn.mapper.StudentMapper.insert", param);
		session.close();
		return result;
	}
	
	
}

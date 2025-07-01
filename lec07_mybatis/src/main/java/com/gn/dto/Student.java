package com.gn.dto;
// 데이터를 담는 바구니
// 정보를 넣었다가 뺐다가 함

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
// 기본 생성자
@NoArgsConstructor
// 매개 변수 생성자
@AllArgsConstructor
// toString
@ToString

public class Student {
	private int studentNo;
	private String studentName;
	private int studentAge;
}

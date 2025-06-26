package com.gn.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

// 기본 생성자와 getter/setter
@Data
// 매개변수 있는 생성자
@AllArgsConstructor

public class Account {
	
	private String correctId;
	private String name;
	
	
	
}

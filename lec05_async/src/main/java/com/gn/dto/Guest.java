package com.gn.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

//LOMBOK
//기본 생성자 
@NoArgsConstructor
//매개변수 생성자
@AllArgsConstructor
//getter
@Getter

public class Guest {
	private String name;
	private String message;
	private String date;

}

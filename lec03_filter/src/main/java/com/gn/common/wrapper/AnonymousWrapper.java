package com.gn.common.wrapper;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;

public class AnonymousWrapper extends HttpServletRequestWrapper{

	public AnonymousWrapper(HttpServletRequest request) {
		super(request);
	}
	
	@Override
	public String getParameter(String name) {
		
		String value = super.getParameter(name);
		if (!(name.equals("writer") || value == null)) {
			return value;
		} 
		return "익명";
	}
	

}

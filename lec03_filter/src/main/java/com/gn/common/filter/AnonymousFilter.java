package com.gn.common.filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

import com.gn.common.wrapper.AnonymousWrapper;
import com.gn.common.wrapper.TitlePrefixWrapper;


@WebFilter("/comment/write")
public class AnonymousFilter extends HttpFilter implements Filter {
       
  
    public AnonymousFilter() {
        super();
    }


	public void destroy() {
	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// 객체화
		AnonymousWrapper wrappedRequest 
			= new AnonymousWrapper((HttpServletRequest)request);
	
		chain.doFilter(wrappedRequest, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}

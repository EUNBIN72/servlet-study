package com.gn.common.filter;

import java.io.IOException;

import com.gn.common.wrapper.TitlePrefixWrapper;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;


@WebFilter("/board/write")
public class TitlePrefixFilter extends HttpFilter implements Filter {
       
  
    public TitlePrefixFilter() {
        super();
    }


	public void destroy() {
	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// 객체화
		TitlePrefixWrapper wrappedRequest 
			= new TitlePrefixWrapper((HttpServletRequest)request);
		
		chain.doFilter(wrappedRequest, response);
		
//		또는 ->
//		HttpServletRequest httpReq = (HttpServlettRequest)request;
//		TitlePrefixWrapper wrapper = new TitlePrefixWrapper(httpReq);
//		chain.doFilter(wrapper, response);
//		
	}


	public void init(FilterConfig fConfig) throws ServletException {
	}

}

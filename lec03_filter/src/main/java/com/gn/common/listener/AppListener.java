package com.gn.common.listener;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;


@WebListener
public class AppListener implements ServletContextListener {


    public AppListener() {
    }


    public void contextInitialized(ServletContextEvent sce)  { 
    	System.out.println("서버 시작 시 호출");  // 서버가 실행되는 동시에 출력해줌
    }


    public void contextDestroyed(ServletContextEvent sce)  { 
    	System.out.println("서버 종료 시 호출");  // 사실상 서버가 멈출 일은 없음
    	// 실습할 때는 JVM이 먼저 내려가기 때문에 볼 일은 없을 듯
    }
	
}

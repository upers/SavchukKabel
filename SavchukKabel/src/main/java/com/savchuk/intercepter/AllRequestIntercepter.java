package com.savchuk.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AllRequestIntercepter extends HandlerInterceptorAdapter {
	
	private static final Log log = LogFactory.getLog(AllRequestIntercepter.class);
	
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    	log.info("pre request uri: " + request.getRequestURI());
        return true;
    }
}

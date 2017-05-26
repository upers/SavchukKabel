package com.savchuk.intercepter;

import java.lang.reflect.Method;
import java.util.Enumeration;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.savchuk.annotations.PrintRequest;

public class RequestPrinterIntercepter extends HandlerInterceptorAdapter {

	private static final Logger log = Logger.getLogger(RequestPrinterIntercepter.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		log.info("pre request uri: " + request.getRequestURI());		
		log.info("Method " + request.getMethod());
		System.out.println("---------------------------------------");
		
		HandlerMethod hm=(HandlerMethod)handler; 
		Method method=hm.getMethod();
		
		boolean isPrint = method.getDeclaringClass().isAnnotationPresent(PrintRequest.class);
		if (isPrint == false)
			isPrint = method.isAnnotationPresent(PrintRequest.class);
		
		if (isPrint)
			printRequestData(request);
		
		return true;
	}
	
	private void printRequestData(HttpServletRequest request) {
		log.info("ContentType: " + request.getContentType());
		log.info("------------Request Header--------------------------");
		Enumeration<String> headerNames = request.getHeaderNames();
		while (headerNames.hasMoreElements()) {

			String headerName = headerNames.nextElement();
			log.info(headerName);

			Enumeration<String> headers = request.getHeaders(headerName);
			while (headers.hasMoreElements()) {
				String headerValue = headers.nextElement();
				log.info(headerValue);
			}
		}
		log.info("----------------------------------------------------");

		log.info("");

		log.info("------------Request Parameters--------------------------");
		Enumeration<String> enumName = request.getParameterNames();
		while (enumName.hasMoreElements()) {
			String name = enumName.nextElement();
			log.info("ParamerName: " + name + " Param val: " + request.getParameter(name));
		}
		log.info("----------------------------------------------------");
	}

}

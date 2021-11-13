package com.priyank.lc.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;


//this is approach 2 to initialize the web application using spring
//this class is made so that spring makes the dispatcher servlet for us no need to write loveCalculatorApplicationInitialzer.class which implements WebApplicationInitializer 
public class Approach2LCAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	public Approach2LCAppInitializer() {
		System.out.println("inside Approach2LCAppInitializer");
		// TODO Auto-generated constructor stub
	}

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		@SuppressWarnings("rawtypes")
		Class arr[] = {LoveCalculatorApplicationConfig.class};
		return arr;
	}

	@Override
	protected String[] getServletMappings() {
		String arr[] = {"/"};
		return arr;
	}

}

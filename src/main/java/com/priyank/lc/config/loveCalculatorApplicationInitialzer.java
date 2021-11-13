package com.priyank.lc.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

//import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
//import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;


//NOT USING THIS CLASS FOR NOW AS WE ARE USING Approach2LCAppInitializer



//this is approach 1 to initialize web application 2nd approach is Approach2LCAppInitializer.class
//if you are using approach 1 please uncomment implements WebApplicationInitializer and also override the method onStartup
public class loveCalculatorApplicationInitialzer// implements WebApplicationInitializer 
{
	//@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		
		//XmlWebApplicationContext is used to configure the xml file where all beans will be there
		//below code it commented because we are not using xml way configuration previously added just to see how xml works
		//now only java based configuration is done in LoveCalculatorApplicationConfig file, so now we use AnnotationConfigWebApplicationContext
		
		//XmlWebApplicationContext webApplicationContext = new XmlWebApplicationContext();
		//webApplicationContext.setConfigLocation("classpath:application-config.xml");
		
		
		AnnotationConfigWebApplicationContext webApplicationContext = new AnnotationConfigWebApplicationContext();
		webApplicationContext.register(LoveCalculatorApplicationConfig.class);
		
		//create dispatcher servlet obj
		DispatcherServlet dispatcherServlet = new DispatcherServlet(webApplicationContext);//don't forget to add webApplicationContext obj in dispatcher servlet
		//or else dispatcher servlet will look for the myDispatcherServlet-servlet.xml which is written below.
		//adding parameter to the dispatcher servlet of XmlWebApplicationContext will take the same file mentioned in it.
		//or else it will take default servlet which is metioned below (myDispatcherServlet).
		
		//register dispatcher servlet with servlet
		ServletRegistration.Dynamic myCustomServletRegistration= servletContext.addServlet("myDispatcherServlet", dispatcherServlet);
		myCustomServletRegistration.setLoadOnStartup(1);
		myCustomServletRegistration.addMapping("/mywebsite.com/*");
		
	}

}

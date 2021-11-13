package com.priyank.lc.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.format.Formatter;
import org.springframework.format.FormatterRegistrar;
import org.springframework.format.FormatterRegistry;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.priyank.lc.formatter.PhoneFormatter;


//this file is for configuration of beans and componentscan which we write in xml now we are using only java files no xml needed
//soo basically it is a replacement for xml file.

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "com.priyank.lc")
//@PropertySource("classpath:messages.properties")
public class LoveCalculatorApplicationConfig implements WebMvcConfigurer{ //implemented WebMvcConfigurer to use addFormatters method
	
	//creating bean for view resolver for our hello-world.jsp
	@Bean
	InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	
	
	//configuring properties file
	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("messages");
		return messageSource;
	}
	
	@Bean
	public LocalValidatorFactoryBean validator() {
		
		LocalValidatorFactoryBean localValidatorFactoryBean = new LocalValidatorFactoryBean();
		localValidatorFactoryBean.setValidationMessageSource(messageSource());
		return localValidatorFactoryBean;
	}
	
	@Override
		public Validator getValidator() {
			return validator();
		}
	
	@Override
	public void addFormatters(FormatterRegistry registry) {
		System.out.println("inside addFormatter");
		registry.addFormatter(new PhoneFormatter());
	}
	


}

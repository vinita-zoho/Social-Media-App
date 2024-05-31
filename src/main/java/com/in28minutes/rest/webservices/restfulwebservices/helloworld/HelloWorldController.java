package com.in28minutes.rest.webservices.restfulwebservices.helloworld;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	private MessageSource messageSource;
	
	
	public HelloWorldController(MessageSource messageSource) {
		super();
		this.messageSource = messageSource;
	}
	
	@GetMapping(path ="hello-world")
	public String helloWorld()
	{
		return "hello-world";
	}

	@GetMapping(path = "hello-world-bean/path-variable/{name}")
	public HelloWorldBean helloWorldBean(@PathVariable String name)
	{
		return new HelloWorldBean("Hello World :: " + name);
	}
	
	@GetMapping(path ="hello-world-internationalized")
	public String helloWorldInternationalized()
	{
		Locale locale = LocaleContextHolder.getLocale();
		return messageSource.getMessage("good.morning.message", null, "Default Message", locale);
	}
	

}

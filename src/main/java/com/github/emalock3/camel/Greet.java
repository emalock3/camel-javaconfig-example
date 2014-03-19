package com.github.emalock3.camel;

import org.apache.camel.Consume;
import org.springframework.stereotype.Component;

@Component
public class Greet {
	public static final String URI = "direct:hello";
	
	@Consume(uri = URI)
	public String hello(String name) {
		return String.format("Hello, %s!", name);
	}
}

package com.github.emalock3.camel;

import java.util.Arrays;
import java.util.List;

import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.spring.javaconfig.CamelConfiguration;
import org.apache.camel.spring.javaconfig.Main;
import org.springframework.context.annotation.Configuration;

@Configuration
public class App extends CamelConfiguration {
	
	public static void main(String... args) throws Exception {
		Main main = new Main();
		main.setConfigClassesString(App.class.getName());
		main.setBasedPackages(App.class.getPackage().getName());
		main.start();
		ProducerTemplate template = main.getCamelTemplate();
		template.requestBody("direct:start1", "World");
		template.requestBody("direct:start2", "World");
		main.stop();
	}
	
	@Override
	public List<RouteBuilder> routes() {
		return Arrays.asList(
				new Greet1RouteBuilder(), 
				new Greet2RouteBuilder()
				);
	}

}

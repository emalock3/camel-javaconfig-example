package com.github.emalock3.camel;

import org.apache.camel.builder.RouteBuilder;

public class Greet1RouteBuilder extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("direct:start1")
			.to(Greet.URI)
			.log("greet1 ${body}");
	}

}

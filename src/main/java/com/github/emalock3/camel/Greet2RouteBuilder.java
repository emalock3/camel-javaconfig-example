package com.github.emalock3.camel;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.apache.camel.builder.RouteBuilder;

class Greet2RouteBuilder extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("direct:start2")
			.to(Greet.URI)
			.process(e -> e.getIn().setBody(
					e.getIn().getBody(String.class).chars()
						.filter(cp -> Character.isAlphabetic(cp))
						.flatMap(cp -> IntStream.of(cp, cp, cp))
						.mapToObj(cp -> String.valueOf(Character.toChars(cp)))
						.collect(Collectors.joining())
				))
			.log("greet2 ${body}");
	}

}

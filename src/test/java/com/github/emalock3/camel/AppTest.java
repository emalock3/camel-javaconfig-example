package com.github.emalock3.camel;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class AppTest extends CamelTestSupport {
	
	@Produce(uri = "direct:start")
	protected ProducerTemplate template;
	
	@Test
	public void test() {
	}

}

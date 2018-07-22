package com.springboot.app.dictionary.test;

import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
	private static AtomicInteger counter = new AtomicInteger(1);
	
	@RequestMapping(value="/greet/{name}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public Greeting greet(@PathVariable("name") String name) {
		return new Greeting(counter.getAndIncrement(), "Hello " + name);
	}
	
	@RequestMapping(value="/greet", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public Greeting greet() {
		return new Greeting(counter.getAndIncrement(), "Hello User..!");
	}
}

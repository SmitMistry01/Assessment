package com.edigest.start;

import org.springframework.web.bind.annotation.*;

@RestController
public class Hello {
	@GetMapping("/hello")
	public String hello() {
		return "Hello, World!";
	}
}
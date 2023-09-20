package com.fluffynow.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class Welcome {
	
	@GetMapping("/welcome")
	public String welcomeFunction () {
		return "Welcome to my system.";
	}

}

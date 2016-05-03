package com.javaaround.springboot.controller;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

	@RequestMapping("/hello")
	public String home() {
		return "Hello World!";
	}
	
}

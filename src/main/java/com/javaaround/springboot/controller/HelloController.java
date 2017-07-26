package com.javaaround.springboot.controller;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.javaaround.springboot.confiq.GlobalProperties;

@RestController
public class HelloController {
	

	@RequestMapping("/hello")
	public String home() {
		GlobalProperties global = new GlobalProperties();
		return "Hello World!" + global.getEmail();
	}
	
}

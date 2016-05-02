package com.javaaround.springboot.controllers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.javaaround.springboot.configuration.AppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = AppConfiguration.class)
@WebAppConfiguration
public class HelloControllerTests {

	@Test
	public void contextLoads() {
	}

}

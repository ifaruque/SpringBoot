package com.javaaround.springboot.controller;
import com.javaaround.springboot.Application;

import java.net.URL;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestTemplate;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.beans.factory.annotation.Value;

@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(classes = MockServletContext.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest({"server.port=0"})
public class HelloControllerTest {

	@Value("${local.server.port}")
    private int port;

	//private MockMvc mvc;
	private URL base;
	private RestTemplate template;

	@Before
	public void setUp() throws Exception {
		//mvc = MockMvcBuilders.standaloneSetup(new HelloController()).build();
		this.base = new URL("http://localhost:" + "8080" + "/hello");
		template = new TestRestTemplate();
	}

	@Test
	public void getHello() throws Exception {
		/*System.out.println("Test using MockMvc");
		mvc.perform(MockMvcRequestBuilders.get("/hello").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().string(equalTo("Hello Wor")));*/
		ResponseEntity<String> response = template.getForEntity(base.toString(), String.class);
		assertThat(response.getBody(), equalTo("Hello World"));
	
	}
	
}

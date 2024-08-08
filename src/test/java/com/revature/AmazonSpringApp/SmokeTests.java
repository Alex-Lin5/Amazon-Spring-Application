package com.revature.AmazonSpringApp;

import com.revature.AmazonSpringApp.controller.HomeController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class SmokeTests {
	@LocalServerPort
	private int port;
	private String hostUrl = "http://localhost:";

	@Autowired
	private TestRestTemplate restTemplate;
	@Autowired
	private HomeController homeController;
	@Autowired
	private MockMvc mockMvc;

	@Test
	void contextLoads() throws Exception {
		assertThat(homeController).isNotNull();
	}
	@Test
	void homePageReturnMessage() throws Exception{
		assertThat(this.restTemplate.getForObject(hostUrl+port+"/", String.class))
				.contains("Home");
	}
	// context started without server, controller/web layer mock test
	@Test
	void ControllerHomePageReturnMessage() throws Exception{
		this.mockMvc.perform(get("/"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().string(containsString("Home")));
	}

}

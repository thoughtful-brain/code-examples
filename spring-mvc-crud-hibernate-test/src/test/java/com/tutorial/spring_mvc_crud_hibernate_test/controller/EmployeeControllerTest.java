package com.tutorial.spring_mvc_crud_hibernate_test.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import java.nio.charset.Charset;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.context.WebApplicationContext;

import com.tutorial.spring_mvc_crud_hibernate_test.AppConfig;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class EmployeeControllerTest {

	private MockMvc mockMvc;
	private final MediaType content = new MediaType(MediaType.APPLICATION_JSON.getType(),
			MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));
	private final MediaType post_content = new MediaType(MediaType.APPLICATION_FORM_URLENCODED.getType(),
			MediaType.APPLICATION_FORM_URLENCODED.getSubtype(), Charset.forName("utf8"));
	@Autowired
	private WebApplicationContext webApplicationContext;

	@Before
	public void setup() throws Exception {
		this.mockMvc = webAppContextSetup(this.webApplicationContext).build();
	}

	@Test
	public void home() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.get("/").contentType(this.content))
				.andExpect(MockMvcResultMatchers.status().isOk()).andExpect(view().name("employee"));
	}

	@Test
	public void getAllEmployees() throws Exception {
		String expectedJson = "{'Result' : 'OK'}";
		this.mockMvc.perform(MockMvcRequestBuilders.get("/get").contentType(this.content))
				.andExpect(MockMvcResultMatchers.status().isOk()).andExpect(content().json(expectedJson))
				.andDo(MockMvcResultHandlers.print());
	}

	@Test
	public void saveEmployee() throws Exception {
		String expectedJson = "{'Result' : 'OK'}";
		this.mockMvc
				.perform(MockMvcRequestBuilders.post("/save-edit").contentType(this.post_content)
						.param("employeeName", "Test").param("age", "25").param("designation", "TL"))
				.andExpect(MockMvcResultMatchers.status().isOk()).andExpect(content().json(expectedJson))
				.andDo(MockMvcResultHandlers.print());
	}

	@Test
	public void deleteEmployee() throws Exception {
		String expectedJson = "{'Result' : 'OK'}";
		this.mockMvc
				.perform(
						MockMvcRequestBuilders.post("/delete").contentType(this.post_content).param("employeeId", "12"))
				.andExpect(MockMvcResultMatchers.status().isOk()).andExpect(content().json(expectedJson))
				.andDo(MockMvcResultHandlers.print());
	}

}

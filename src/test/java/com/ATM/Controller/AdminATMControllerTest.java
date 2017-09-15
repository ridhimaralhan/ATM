package com.ATM.Controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.ATM.Service.ATMService;
import com.ATM.controller.ATMAdminController;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class)

public class AdminATMControllerTest extends AbstractJUnit4SpringContextTests {

	@Mock
	ATMService atmServiceMock;

	@InjectMocks
	private ATMAdminController atmAdminController;

	private MockMvc mockMvc;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(atmAdminController).build();
	}

	@Test
	public void Test_adminAddNotes() throws Exception {
		mockMvc.perform(get("/AddNotesPage")).andExpect(status().isOk());
	}

	@Test
	public void Test_adminRemoveNotes() throws Exception {
		mockMvc.perform(get("/removeNotesPage")).andExpect(status().isOk());
	}

	@Test
	public void Test_addNotes() throws Exception {
		mockMvc.perform(post("/addNotes").param("Denomination", "20").param("Count", "1")).andExpect(status().isOk());
	}

	@Test
	public void Test_removeNotes() throws Exception {
		mockMvc.perform(post("/removeNotes").param("Denomination", "20").param("Count", "1"))
				.andExpect(status().isOk());
	}
}

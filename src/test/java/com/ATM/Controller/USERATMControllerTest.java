package com.ATM.Controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.HashMap;
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
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.ATM.Service.ATMService;
import com.ATM.controller.ATMUserController;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class)
@WebAppConfiguration
public class USERATMControllerTest extends AbstractJUnit4SpringContextTests {

	@Mock
	ATMService atmServiceimpl;

	@InjectMocks
	private ATMUserController atmUserController;

	private MockMvc mockMvc;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(atmUserController).build();
	}

	@Test
	public void Test_withdrawlpage() throws Exception {
		HashMap<Integer, Integer> hs = new HashMap<Integer, Integer>();
		hs.put(50, 1);
		hs.put(20, 0);
		when(atmServiceimpl.retrieveNotes(50)).thenReturn(hs.toString());
		mockMvc.perform(get("/withdrawlPage")).andExpect(status().isOk());
	}

	@Test
	public void Test_retrunNotes_50() throws Exception {

		HashMap<Integer, Integer> hs = new HashMap<Integer, Integer>();
		hs.put(50, 1);
		hs.put(20, 0);
		when(atmServiceimpl.retrieveNotes(50)).thenReturn(hs.toString());
		mockMvc.perform(post("/displaynotes").param("amount", "50")).andExpect(status().isOk());

	}

	@Test
	public void Test_retrunNotes_20() throws Exception {
		HashMap<Integer, Integer> hs = new HashMap<Integer, Integer>();
		hs.put(50, 0);
		hs.put(20, 1);
		when(atmServiceimpl.retrieveNotes(20)).thenReturn(hs.toString());
		mockMvc.perform(post("/displaynotes").param("amount", "20")).andExpect(status().isOk());

	}

}

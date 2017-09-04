package com.nokia.netactplus.webmonitor.controller;

import javax.servlet.ServletContext;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({"classpath:spring/applicationContext-dao.xml", "classpath:spring/applicationContext-ehcache.xml",
	"classpath:spring/applicationContext-service.xml", "classpath:spring/servlet-context.xml"})
public class NasdaControllerTest {

	@Autowired
	private NasdaController nasdaController;

	@Autowired
	private ServletContext context;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.standaloneSetup(nasdaController).build();
	}

	@Test
	public void testListAll() throws Exception {
		ResultActions resultActions = this.mockMvc.perform(MockMvcRequestBuilders.get("/webmonitor/nasda/motree/clab1795"));
		MvcResult mvcResult = resultActions.andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
		String result = mvcResult.getResponse().getContentAsString();
		System.err.println("get result: " + result);
	}

}

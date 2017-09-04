package com.nokia.netactplus.webmonitor.controller;

import javax.servlet.http.HttpServletRequest;

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
public class FMControllerTest {

	@Autowired
	private FMController fmController;

	@Autowired
	private HttpServletRequest request;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.standaloneSetup(fmController).build();
	}

	//@Test
	public void testListAll() throws Exception {
		String dn = "PLMN-PLMN%2FDCAP-DEMO";
		ResultActions resultActions = this.mockMvc.perform(MockMvcRequestBuilders.get("/webmonitor/fm/alarm/list/CloudLab1507/" + dn));
		MvcResult mvcResult = resultActions.andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
		String result = mvcResult.getResponse().getContentAsString();
		System.err.println("get result: " + result);
	}

	@Test
	public void testContext() {
		String path = request.getServletContext().getRealPath("WEB-INF/static/upload");
		System.out.println(path);
	}

}

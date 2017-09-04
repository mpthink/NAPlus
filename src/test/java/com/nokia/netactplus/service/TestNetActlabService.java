package com.nokia.netactplus.service;

import java.sql.Connection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.nokia.netactplus.webmonitor.dao.Connect2OracleFactory;
import com.nokia.netactplus.webmonitor.service.INasdaService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/applicationContext-dao.xml", "classpath:spring/applicationContext-ehcache.xml",
	"classpath:spring/applicationContext-service.xml"})
public class TestNetActlabService {

	@Autowired
	private Connect2OracleFactory dbFactory;

	@Autowired
	private INasdaService nasdaService;

	@Autowired
	private EhCacheCacheManager ehcacheManager;

	@Test
	public void testGetLabInfoByName() throws InterruptedException {
		//System.out.println(ehcacheManager.getCacheNames());
		String host1 = "10.92.67.49";
		String host2 = "10.92.100.250";
		Connection conn2 = dbFactory.getDBConnection(host2);
		System.out.println(conn2);

		Connection conn3 = dbFactory.getDBConnection(host2);
		System.err.println(conn3);
		//		List<NASDA_OBJECTS> objects2 = nasdaService.getNasdaMOs(host2, null);
		//		for (NASDA_OBJECTS object : objects2) {
		//			System.err.println(object.toString());
		//		}

		//Connection conn1 = dbFactory.getDBConnection(host1);
		//		List<NASDA_OBJECTS> objects1 = nasdaService.getNasdaMOs(host1, null);
		//		for (NASDA_OBJECTS object : objects1) {
		//			System.out.println(object.toString());
		//		}



	}
}

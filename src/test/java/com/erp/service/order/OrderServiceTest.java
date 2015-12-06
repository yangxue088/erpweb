package com.erp.service.order;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@WebAppConfiguration
@ContextHierarchy({ @ContextConfiguration(locations = "classpath:application-context.xml"), @ContextConfiguration(locations = "classpath:dispatcher/dispatcher-context.xml") })
public class OrderServiceTest {
	
	@Autowired
	private OrderService orderService;

	@Test
	public void testSync() {
		orderService.sync();
	}

}

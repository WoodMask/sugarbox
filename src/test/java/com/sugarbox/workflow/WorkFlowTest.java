package com.sugarbox.workflow;

import org.activiti.engine.ProcessEngine;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:WEB-INF/defaultServlet.xml", "classpath:WEB-INF/applicationContext.xml"})
public class WorkFlowTest {

	@Autowired
	private ProcessEngine processEngine;
	
	@Test
	public void hello() {
		System.out.println(processEngine);
	}
}

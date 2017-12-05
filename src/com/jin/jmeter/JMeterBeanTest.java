package com.jin.jmeter;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @describe
 * @author 锦锦金
 * @date 2017年12月4日
 */
public class JMeterBeanTest {
	private static int count = 0;

	@Before
	public void setUp() throws Exception {
		 System.out.println("开始测试");  
	}

	@After
	public void tearDown() throws Exception {
		 System.out.println("测试结束");  
	}

	@Test
	public void testGetName() {
		JMeterBean jmb = new JMeterBean("小锦");
		System.out.println("getName:" + jmb.getName()+" "+(count++));
		assertEquals("小锦", jmb.getName());
	}

	@Test
	public void testSetName() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetFriend() {
		JMeterBean jmb = new JMeterBean("小锦", "小婵");
		System.out.println("getFriend:" + jmb.getFriend()+" "+(count++));
		assertEquals("小婵", jmb.getFriend());
	}

	@Test
	public void testSetFriend() {
		fail("Not yet implemented");
	}

}

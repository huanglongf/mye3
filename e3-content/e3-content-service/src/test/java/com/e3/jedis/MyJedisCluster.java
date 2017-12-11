package com.e3.jedis;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import redis.clients.jedis.JedisCluster;

public class MyJedisCluster {
	
	@Test
	public void testJedis(){
		ApplicationContext app = new ClassPathXmlApplicationContext("classpath*:spring/jedis.xml");
		
		JedisCluster jc = app.getBean(JedisCluster.class);
		jc.set("cd", "山");
	}
}

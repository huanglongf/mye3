package com.e3.jedis;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class MyJedis {
	
	
	@Test
	public void linkSingleRedisWithoutPool(){
		
		JedisPoolConfig poolConfig = new JedisPoolConfig();
		
		poolConfig.setMaxTotal(20000);
		poolConfig.setMaxIdle(20);
		JedisPool jp = new JedisPool(poolConfig,"192.168.17.131", 6379);
		
		Jedis jedis = jp.getResource();
		jedis.set("username", "张三丰天下无敌入网费");
	}
	@Test
	public void linkClusterRedisWithoutPool(){
		
		JedisPoolConfig poolConfig = new JedisPoolConfig();
		
		poolConfig.setMaxTotal(2000);
		poolConfig.setMaxIdle(20);
		
		Set<HostAndPort> nodes = new HashSet<HostAndPort>();
		
		nodes.add(new HostAndPort("192.168.17.131", 7001));
		nodes.add(new HostAndPort("192.168.17.131", 7002));
		nodes.add(new HostAndPort("192.168.17.131", 7003));
		nodes.add(new HostAndPort("192.168.17.131", 7004));
		nodes.add(new HostAndPort("192.168.17.131", 7005));
		nodes.add(new HostAndPort("192.168.17.131", 7006));
		nodes.add(new HostAndPort("192.168.17.131", 7007));
		nodes.add(new HostAndPort("192.168.17.131", 7008));
		
		
		JedisCluster jc = new JedisCluster(nodes, poolConfig);
		jc.set("username","张三丰天下无敌入网费");
	}
}

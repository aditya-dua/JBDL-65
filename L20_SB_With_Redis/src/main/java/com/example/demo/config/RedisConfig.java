package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@Configuration
@EnableRedisRepositories
public class RedisConfig {

	@Bean
	public JedisConnectionFactory connectionFactory() {
		// Redis Localhost
		RedisStandaloneConfiguration config = new RedisStandaloneConfiguration("localhost", 6379);
		
		// Redis Cloud
		RedisStandaloneConfiguration configCloud = new RedisStandaloneConfiguration();
		
		configCloud.setHostName("redis-16438.c264.ap-south-1-1.ec2.cloud.redislabs.com");
		
		
		configCloud.setPassword("BMkqVno6mlwRmmrkpTy8eDqVdOdoz9c9");
		configCloud.setPort(16438);
		configCloud.setUsername("default");
		//return new JedisConnectionFactory(config);
		return new JedisConnectionFactory(configCloud);
		
	}
	
	@Bean
	public RedisTemplate<String, Object> template(){
		RedisTemplate<String, Object> template = new RedisTemplate<String, Object>();
		template.setConnectionFactory(connectionFactory());
		
		return template;
	}
	
}

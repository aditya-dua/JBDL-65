package com.example.demo.repositories;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.models.User;
import com.example.demo.utils.Constants;

@Repository
public class UserCacheRepository {

	@Autowired
	RedisTemplate<String, Object> redisTemplate;
	
	
	public void save(User user) {
		this.redisTemplate.opsForValue().set(getKey(user.getUserId()), user,Constants.USER_REDIS_KEY_EXPIRY,TimeUnit.SECONDS);
	}
	
	public User get(int userId) {
		return (User) this.redisTemplate.opsForValue().get(getKey(userId));
	}
	
	private String getKey(int userId) {
		return Constants.USER_REDIS_KEY_PREFIX+userId;
	}
}

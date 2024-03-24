package com.example.demo.entity.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Product;

@Repository
public class ProductDAORepo {

	private static final String HASH_KEY = "JBDL65-Product";
	
	@Autowired
	private RedisTemplate<String, Object> template;
	
	public Product save(Product product) {
		
		template.opsForHash().put(HASH_KEY, product.getId(), product);
		
		
		return product;
	}
	
	public List<Object> getAll(){
		return template.opsForHash().values(HASH_KEY);
	}
}

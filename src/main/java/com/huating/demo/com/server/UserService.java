package com.huating.demo.com.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import com.huating.demo.com.dao.UserMapper;
import com.huating.demo.com.domain.User;

@Service
public class UserService {

	@Autowired
	private UserMapper userMapper;
	@Autowired
	private StringRedisTemplate redisTemplate;   
	
	public int addUser(User u) {
		int addUser = userMapper.addUser(u);
		redisTemplate.opsForValue().set("uid"+u.getId(), u.getName());
		return addUser;
	}
	
	public User getUserByid(int id) {
		String string = redisTemplate.opsForValue().get("uid"+id);
		User user= new User();
		user.setName(string);
		if(user.getName()!=null) {
			System.out.println("走缓存了");
			
			return user;
		}
		User userByid = userMapper.getUserByid(id);
		System.out.println("meiyou走缓存");
		return userByid;
	}
}

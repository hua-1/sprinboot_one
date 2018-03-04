package com.huating.demo.com.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.huating.demo.com.domain.User;
import com.huating.demo.com.server.UserService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/user")
public class UserControler {

	@Autowired
	private UserService userService;
	
	
	@RequestMapping(value="/addUser",method=RequestMethod.POST)
	@ApiOperation("addUser")
	public int addUser(@RequestBody User u) {
		int addUser = userService.addUser(u);
		return addUser;
	}
	@RequestMapping(value="getUserByid",method=RequestMethod.GET)
	public User getUserByid(int id) {
		User userByid = userService.getUserByid(id);
		return userByid;
	}
}

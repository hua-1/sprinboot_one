package com.huating.demo.com.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.huating.demo.com.domain.User;

public interface UserMapper {

	@Insert("insert into tb_user(name,city,address)"
			+ " values(#{u.name},#{u.city},#{u.address})")
	int addUser(@Param("u") User u);
	@Select("select * from tb_user where id=#{id}")
	User getUserByid(@Param("id") int id);
}

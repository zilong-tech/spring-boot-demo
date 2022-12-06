package com.demo.dao;


import com.demo.domain.User;
import org.apache.ibatis.session.ResultHandler;

import java.util.List;

public interface UserMapper {
	
	List<User> getAll();
	
	User getOne(Long id);

	void insert(User user);

	void update(User user);

	void delete(Long id);

	List<User>  getUsers(Integer id);

	List<User> selectUsers(Integer id);

}
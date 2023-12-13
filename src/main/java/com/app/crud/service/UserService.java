package com.app.crud.service;

import java.util.List;


import com.app.crud.entity.User;

public interface UserService {

	void addUser(User user);

	List<User> getUsers();

	

	User getUser(Long id);

	void saveOrUpdate(User user);

	void DeleteById(Long id);

	
	

}

package com.app.crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.app.crud.entity.User;
import com.app.crud.repository.UserRepository;

@Service
public class UserServiceimpl implements UserService{
@Autowired
public UserRepository userRepository;
	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		userRepository.save(user);
	}
	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}
	@Override
	public User getUser(Long id) {
		// TODO Auto-generated method stub
		 User user=userRepository.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Invalid user id:"+id));
		 return user;
	}
	@Override
	public void saveOrUpdate(User user) {
		// TODO Auto-generated method stub
		userRepository.save(user);
	}
	@Override
	public void DeleteById(Long id) {
		// TODO Auto-generated method stub
		userRepository.deleteById(id);
	}
	
	
}

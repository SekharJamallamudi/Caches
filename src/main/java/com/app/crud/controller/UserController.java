package com.app.crud.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.crud.entity.User;
import com.app.crud.service.UserService;


@RestController
@RequestMapping("/user")
@CacheConfig(cacheNames ="User")
public class UserController {
@Autowired
public UserService userService;
 
@PostMapping("/add")
public String addUser(@RequestBody User user)
{
userService.addUser(user);
return "success add user";
}
@GetMapping
public List<User>getUsers()
{
	return userService.getUsers();
}
@GetMapping("/get/{id}")
@Cacheable(key="#id")
public User getUser(@PathVariable Long id)
{
	
	return userService.getUser(id);
}

@PutMapping("/user/{id}")
@CachePut(key="#id")
public ResponseEntity<Object> getUser(@RequestBody User user) {
    userService.saveOrUpdate(user);
    return new ResponseEntity<>("User is updated successfully", HttpStatus.OK);
}

@DeleteMapping("{id}")
@CacheEvict(key="#id")
public String DeleteById(@PathVariable Long id )
{
	 userService.DeleteById(id);
	 return "Deleted SuccesFully...";
}

}

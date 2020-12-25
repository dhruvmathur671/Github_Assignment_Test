package com.deluxeinterio.initial.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.deluxeinterio.initial.dto.LoginDto;
import com.deluxeinterio.initial.model.User;
import com.deluxeinterio.initial.service.UserService;
import com.google.common.net.MediaType;


@RestController
public class UserController {
	
	@Autowired
	UserService userService;

@RequestMapping(value = "/users", method = RequestMethod.GET)
public List<User> getUsers() {

	return userService.getAllUsers();

}

@RequestMapping(value = "/insertuser", method = RequestMethod.POST)
public void insertUser(@RequestBody User user) {
	userService.insertUser(user);

}
@GetMapping("/checkHealth")
public String fun(){return "Working !!!";}


@PostMapping(value = "/login")
public boolean loginUser(@RequestBody LoginDto loginDto) {
	return userService.loginUser(loginDto);

}

}

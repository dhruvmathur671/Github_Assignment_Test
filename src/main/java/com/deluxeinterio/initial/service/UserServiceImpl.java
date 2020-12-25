package com.deluxeinterio.initial.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.deluxeinterio.initial.dao.UserDao;
import com.deluxeinterio.initial.dto.LoginDto;
import com.deluxeinterio.initial.model.User;


@Service
public class UserServiceImpl implements UserService {

	@Autowired
 private UserDao userDao;
	
	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	public List<User> getAllUsers() {
		List<User> user = (List<User>) userDao.findAll();
		return user;
	}

	@Override
	public void insertUser(User user) {
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		userDao.save(user);
		
	}

	@Override
	public boolean loginUser(LoginDto loginDto) {
		String storedpassword = userDao.getStoredPassword(loginDto.getUserName());
		System.out.println(loginDto.getPassword());
		passwordEncoder.matches(loginDto.getPassword(), storedpassword);
		return passwordEncoder.matches(loginDto.getPassword(), storedpassword);
	}

	


	

}
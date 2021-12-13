package com.git.userservice.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.git.dataaccesslayer.entity.User;
import com.git.dataaccesslayer.repository.UserRepository;
import com.git.userservice.exception.UserAlreadyExistException;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	@Transactional
	public User saveUser(User user) throws UserAlreadyExistException {
		System.out.println(user);
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		if(userRepository.findByUserId(user.getId()) != null) {
			throw new UserAlreadyExistException("User already exist");
		}
		user.setPassword(
				encoder.encode(
						user.getPassword()));
		return userRepository.save(user);
	}
}

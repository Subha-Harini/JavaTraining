package com.git.userservice.test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.git.dataaccesslayer.entity.User;
import com.git.dataaccesslayer.repository.UserRepository;
import com.git.userservice.exception.UserAlreadyExistException;
import com.git.userservice.service.UserService;

@ExtendWith(SpringExtension.class)
public class UserServiceTest {
	
	@InjectMocks
	UserService userService;
	
	@Mock
	UserRepository userRepository;
	
	@Mock
	User user;
	
	@Mock
	PasswordEncoder encoder;
	
	@Test
	public void saveUserTest() throws UserAlreadyExistException {
		//User us = new User("asj","name","password",0, "", "");
		when(userRepository.findByUserId(Mockito.any())).thenReturn(user);
		
		assertThrows(UserAlreadyExistException.class,() -> userService.saveUser(user));
	}
	
	@Test
	public void saveNewUserTest() throws UserAlreadyExistException {
		User us = null;
		when(userRepository.findByUserId(Mockito.any())).thenReturn(us);
		when(user.getPassword()).thenReturn("password");
		when(encoder.encode(Mockito.anyString())).thenReturn("");
		userService.saveUser(user);
	}

}

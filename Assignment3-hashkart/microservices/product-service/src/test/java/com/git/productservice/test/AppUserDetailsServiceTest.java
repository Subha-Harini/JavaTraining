package com.git.productservice.test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.git.productservice.security.AppUserDetailsService;
import com.git.dataaccesslayer.entity.User;
import com.git.dataaccesslayer.repository.UserRepository;

@ExtendWith(SpringExtension.class)
public class AppUserDetailsServiceTest {
	
	@InjectMocks
	AppUserDetailsService appUserDetailsService;
	
	@Mock
	UserRepository userRepository;
	
	@Mock
	org.springframework.security.core.userdetails.User user;
	
	@Test
	void loadUserByUsernameExpTest() {
		assertThrows(UsernameNotFoundException.class,() -> appUserDetailsService.loadUserByUsername(""));
	}
	@Test
	void loadUserByUsernameTest() {
		User usr = new User("asj","name","password",0, "", "");
		when(userRepository.findByUsername(Mockito.anyString())).thenReturn(usr);
		appUserDetailsService.loadUserByUsername("username");
	}


}

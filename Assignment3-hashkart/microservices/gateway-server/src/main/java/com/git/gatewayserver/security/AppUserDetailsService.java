package com.git.gatewayserver.security;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.git.dataaccesslayer.repository.UserRepository;



@Service
public class AppUserDetailsService implements UserDetailsService {
	
	
	@Autowired
	private UserRepository userRepository;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println(username);
		com.git.dataaccesslayer.entity.User user = userRepository.findByUsername(username);
		
		if(user != null) {
			System.out.println(user);
			return new User(user.getUsername(), user.getPassword(),
					new ArrayList<>());
		}else {
			throw new UsernameNotFoundException("Username not found");
		}
				
	}

}

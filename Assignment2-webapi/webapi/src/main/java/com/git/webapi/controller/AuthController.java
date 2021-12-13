package com.git.webapi.controller;

import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
public class AuthController {
	
	
	@GetMapping("/authenticate")
	public Map<String, String> authenticate(@RequestHeader("Authorization") String authHeader){
		Map<String, String> data = new HashMap();
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String user = authentication.getName();
		data.put("token", generateJwt(getUser(authHeader)));
		return data;
	}
	
	private String getUser(String authHeader) {
		String encodedCredentials = authHeader.split(" ")[1];
		String decodedCredentials = new String (Base64.getDecoder().decode(encodedCredentials));
		return decodedCredentials.split(":")[0];
	}
	
	 private String generateJwt(String user) {
		 JwtBuilder builder = Jwts.builder();
	        builder.setSubject(user);
	        builder.setIssuedAt(new Date());
	        builder.setExpiration(new Date((new Date()).getTime() + 1200000));
	        builder.signWith(SignatureAlgorithm.HS256, "secretkey");
	        String token = builder.compact();
	    return token;
	 }

}

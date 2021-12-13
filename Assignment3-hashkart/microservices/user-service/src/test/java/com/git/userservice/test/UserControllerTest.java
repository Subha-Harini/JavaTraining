package com.git.userservice.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.git.dataaccesslayer.entity.User;
import com.git.userservice.controller.UserController;
import com.git.userservice.service.UserService;
import com.google.gson.Gson;

@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
public class UserControllerTest {
	
private MockMvc mockMvc;
   
	//private Gson m;
    
    @InjectMocks
    private UserController controller;
    
    @Mock
    UserService userService;
    
    @Mock
    User user;
    
    @BeforeEach
    void setupEach(){
    	 //m = new Gson();
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }
    
    @Test
	void postUserTest( ) throws Exception {
    	String jsonRequest = "\r\n"
    			+ "{\r\n"
    			+ "        \"id\": \"H0002\",\r\n"
    			+ "        \"username\": \"Subha\",\r\n"
    			+ "        \"password\": \"password\",\r\n"
    			+ "        \"contact\": \"9952601095\",\r\n"
    			+ "        \"securityQuestion\":\"what is your favourite color\",\r\n"
    			+ "        \"answer\":\"red\"\r\n"
    			+ "    }";
    	  RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/user/signup")
                  .contentType(MediaType.APPLICATION_JSON_VALUE).content(jsonRequest).characterEncoding("utf-8");
          MvcResult result =mockMvc.
        		  perform(requestBuilder).
        		  andReturn();
          assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
	}

}

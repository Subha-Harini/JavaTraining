package com.git.billservice.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.git.billservice.controller.CartController;
import com.git.billservice.service.CartService;
import com.git.dataaccesslayer.entity.Cart;
import com.google.gson.Gson;

@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
public class CartControllerTest {
	private MockMvc mockMvc;
	
	//private Gson m;

    @InjectMocks
    private CartController controller;
    
    @Mock
    CartService cartService;
    
    @Mock
    Cart cart;
    
    static HttpHeaders header;

    @BeforeAll
    static void setup(){
        header = new HttpHeaders();
        header.setBasicAuth("Authorization", "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJoYXJpbmkiLCJpYXQiOjE2MzgzNjk0NzAsImV4cCI6MTYzODM3MDY3MH0.xeivceb0uVJqTDz3qScMvpO6Q2sxDBOFI-8l9AyFPmE");
    }
    
    
    @BeforeEach
    void setupEach(){
    	// m = new Gson();
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }
    
    @Test
	void postCartTest( ) throws Exception {
    	String jsonRequest = "{\r\n"
    			+ "    \"userId\" : \"H0002\",\r\n"
    			+ "    \"productId\" : \"4\",\r\n"
    			+ "    \"quantity\" : \"2\"\r\n"
    			+ "}\r\n"
    			+ "";
    	  RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/hashkart/cart")
                  .contentType(MediaType.APPLICATION_JSON_VALUE).content(jsonRequest);
          MvcResult result =mockMvc.
        		  perform(requestBuilder).
        		  andReturn();
          assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
	}
}

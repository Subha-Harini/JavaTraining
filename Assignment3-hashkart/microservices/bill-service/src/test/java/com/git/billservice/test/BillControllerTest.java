package com.git.billservice.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.git.billservice.controller.BillController;
import com.git.billservice.service.BillService;
import com.git.dataaccesslayer.entity.UserBill;
import com.google.gson.Gson;


@ExtendWith(SpringExtension.class)
public class BillControllerTest {
	
	private MockMvc mockMvc;
    
   // private Gson m = new Gson();
    
    @InjectMocks
    private BillController controller;
    
    @Mock
    BillService billService;;
    
    @Mock
    UserBill userBill;
    
    static HttpHeaders header;

    @BeforeAll
    static void setup(){
        header = new HttpHeaders();
        header.setBasicAuth("Authorization", "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJoYXJpbmkiLCJpYXQiOjE2MzgzNjk0NzAsImV4cCI6MTYzODM3MDY3MH0.xeivceb0uVJqTDz3qScMvpO6Q2sxDBOFI-8l9AyFPmE");
    }
    
    @BeforeEach
    void setupEach(){
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }
    
    @Test
	void postBillsTest( ) throws Exception {
    	String jsonRequest = "{\r\n"
    			+ "    \"userId\" : \"H0003\",\r\n"
    			+ "    \"productList\" : [\r\n"
    			+ "    {\r\n"
    			+ "        \"productId\" : \"1\",\r\n"
    			+ "        \"quantity\" : \"2\"\r\n"
    			+ "    },\r\n"
    			+ "    {\r\n"
    			+ "        \"productId\" : \"2\",\r\n"
    			+ "        \"quantity\" : \"3\"\r\n"
    			+ "    }\r\n"
    			+ "    ],\r\n"
    			+ "    \"billId\":\"0\"\r\n"
    			+ "}";
    	  RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/hashkart/bill")
                  .contentType(MediaType.APPLICATION_JSON_VALUE).content(jsonRequest).headers(header);
          MvcResult result =mockMvc.perform(requestBuilder).andReturn();
          assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
	}

}

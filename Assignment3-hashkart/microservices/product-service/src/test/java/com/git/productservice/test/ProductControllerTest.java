package com.git.productservice.test;

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

import com.git.dataaccesslayer.entity.Product;
import com.git.productservice.controller.ProductController;
import com.git.productservice.service.ProductService;
import com.google.gson.Gson;

@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
public class ProductControllerTest {
	
private MockMvc mockMvc;
	
	//private Gson m;

    @InjectMocks
    private ProductController controller;
    
    @Mock
    ProductService productService;
    
    @Mock
    Product product;
    
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
	void postProductTest( ) throws Exception {
    	String jsonRequest = "{\r\n"
    			+ "    \"productName\": \"Men's regular t-shirt\",\r\n"
    			+ "    \"product_type\": \"clothing\",\r\n"
    			+ "    \"price\": 400,\r\n"
    			+ "    \"quantityAvailable\": 15,\r\n"
    			+ "    \"rating\": 5,\r\n"
    			+ "    \"brand\": \"Fastrack\",\r\n"
    			+ "    \"category\": {\r\n"
    			+ "        \"id\": 2,\r\n"
    			+ "        \"category\": \"Fashion\"\r\n"
    			+ "    }\r\n"
    			+ "}\r\n"
    			+ "";
    	  RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/hashkart/products")
                  .contentType(MediaType.APPLICATION_JSON_VALUE).content(jsonRequest);
          MvcResult result =mockMvc.
        		  perform(requestBuilder).
        		  andReturn();
          assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
	}
    
    @Test
	void getProductTest( ) throws Exception {
    	
    	  RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/hashkart/products");
          MvcResult result =mockMvc.
        		  perform(requestBuilder).
        		  andReturn();
          assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
	}
    
    @Test
	void getProductByIdTest( ) throws Exception {
    	
    	  RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/hashkart/products/1");
          MvcResult result =mockMvc.
        		  perform(requestBuilder).
        		  andReturn();
          assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
	}
    
    @Test
  	void getProductsSortByPriceTest( ) throws Exception {
      	
      	  RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/hashkart/products/sort-by-price");
            MvcResult result =mockMvc.
          		  perform(requestBuilder).
          		  andReturn();
            assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
  	}
    
    @Test
  	void getProductsSortByRatingTest( ) throws Exception {
      	
      	  RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/hashkart/products/sort-by-rating");
            MvcResult result =mockMvc.
          		  perform(requestBuilder).
          		  andReturn();
            assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
  	}
    

}

package com.git.billservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.git.billservice.service.BillService;
import com.git.dataaccesslayer.entity.UserBill;

@RestController
@RequestMapping("/hashkart/bill")
public class BillController {
	@Autowired
	BillService billService;
	
	@PostMapping
	String postBills(@RequestBody UserBill userBill ) {
		return billService.userBills(userBill);
	}
}

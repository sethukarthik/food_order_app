package com.myapp.foodieapp.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.foodieapp.address_service.AddressInterface;
import com.myapp.foodieapp.model.Address;

@RestController
public class AddressController {

	private AddressInterface addImp;
	
	
}

package com.hotel.HotelMS.Controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/staffs")
public class StaffController {
	
	@GetMapping
	public ResponseEntity<List<String>> getStaffs(){
		List<String> list=Arrays.asList("Sonu", "Rohit", "Shyam", "Ram");
		return new ResponseEntity<>(list,org.springframework.http.HttpStatus.OK);
	}

}

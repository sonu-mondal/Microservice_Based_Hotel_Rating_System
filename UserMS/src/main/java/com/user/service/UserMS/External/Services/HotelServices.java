package com.user.service.UserMS.External.Services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.user.service.UserMS.Entity.Hotel;

@FeignClient(name="HOTEL-SERVICE")
public interface HotelServices {
	
	@GetMapping("/hotels/{hotelId}")
	public Hotel getHotel(@PathVariable("hotelId") String hotelId);

}

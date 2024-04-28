package com.hotel.HotelMS.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.HotelMS.Entity.Hotel;
import com.hotel.HotelMS.Payload.ApiResponse;
import com.hotel.HotelMS.Service.HotelServiceImpl;

@RestController
@RequestMapping("/hotels")
public class HotelController {
	
	@Autowired
	private HotelServiceImpl hotelServiceImpl;
	
	//create
	@PostMapping("/add")
	public ResponseEntity<Hotel> addHotelDetails(@RequestBody Hotel hotel){
		Hotel hotel1=this.hotelServiceImpl.addHotelDetails(hotel);
		return new ResponseEntity<>(hotel1, HttpStatus.CREATED);
	}
	
	//get all hotel
	@GetMapping("/getall")
	public ResponseEntity<List<Hotel>> getAllHotel(){
		List<Hotel> allHotel=this.hotelServiceImpl.getAllHotel();
		return new ResponseEntity<List<Hotel>>(allHotel, HttpStatus.OK);
	}
	
	//get single hotel by id
	@GetMapping("/{hotelId}")
	public ResponseEntity<Hotel> getHotel(@PathVariable int hotelId){
		Hotel hotel=this.hotelServiceImpl.getHotel(hotelId);
		return new ResponseEntity<Hotel>(hotel, HttpStatus.OK);
	}
	
	//delete hotel
	@DeleteMapping("/delete/{hotelId}")
	public ResponseEntity<ApiResponse> deleteById(@PathVariable int hotelId){
		this.hotelServiceImpl.deleteHotel(hotelId);
		return new ResponseEntity<>(new ApiResponse("Hotel details has been deleted successfully !!", true), HttpStatus.OK);
		
	}

}

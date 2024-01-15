package com.hotel.HotelMS.Service;

import java.util.List;

import com.hotel.HotelMS.Entity.Hotel;

public interface HotelService {
	
	//create/add hotel details
	public Hotel addHotelDetails(Hotel hotel);	
	
	//getall hotel details
	public List<Hotel> getAllHotel();	
	
	//get particular hotel details
	public Hotel getHotel(int hotelId);	
	
	//delete hotel details
	public void deleteHotel(int hotelId);
}

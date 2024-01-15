package com.hotel.HotelMS.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.HotelMS.Entity.Hotel;
import com.hotel.HotelMS.Exception.ResourceNotFoundException;
import com.hotel.HotelMS.Repository.HotelRepository;

@Service
public class HotelServiceImpl implements HotelService{
	
	@Autowired
	private HotelRepository hotelRepository;

	@Override
	public Hotel addHotelDetails(Hotel hotel) {
		return this.hotelRepository.save(hotel);
	}

	@Override
	public List<Hotel> getAllHotel() {
		return this.hotelRepository.findAll();
	}

	@Override
	public Hotel getHotel(int hotelId) {
		return this.hotelRepository.findById(hotelId).orElseThrow(()->new ResourceNotFoundException("The hotel with the given hotelId is not present !! : "+hotelId));
	}

	@Override
	public void deleteHotel(int hotelId) {
		Hotel hotel=this.hotelRepository.findById(hotelId).orElseThrow(()->new ResourceNotFoundException("The hotel with the given hotelId is not present !! : "+hotelId));
		this.hotelRepository.delete(hotel);
	}

}

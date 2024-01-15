package com.hotel.HotelMS.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.HotelMS.Entity.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Integer>{

}

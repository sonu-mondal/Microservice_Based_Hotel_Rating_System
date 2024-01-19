package com.hotel.HotelMS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class HotelMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelMsApplication.class, args);
	}

}

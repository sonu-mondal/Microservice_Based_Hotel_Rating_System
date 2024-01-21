package com.user.service.UserMS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
public class UserMsApplication {
	//The below config bean we can also create in seperate config class
	
//	//creating bean of resttemplate to use in user service
//		@Bean
//		public RestTemplate restTemplate() {
//			return new RestTemplate();
//		}

	public static void main(String[] args) {
		SpringApplication.run(UserMsApplication.class, args);
	}

}

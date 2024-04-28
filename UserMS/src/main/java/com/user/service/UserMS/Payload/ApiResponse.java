package com.user.service.UserMS.Payload;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ApiResponse {
	
	private String message;
	private boolean success;
	private HttpStatus status;
	


	public ApiResponse(String message, boolean success) {
		super();
		this.message = message;
		this.success = success;
		
	}
	
	
	
}

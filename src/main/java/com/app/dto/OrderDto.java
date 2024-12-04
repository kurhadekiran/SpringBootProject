package com.app.dto;

import org.springframework.web.multipart.MultipartFile;

import com.app.entities.Users;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
//@NoArgsConstructor
//@AllArgsConstructor
@Getter
@Setter
@ToString
public class OrderDto {

	@JsonProperty(access = Access.READ_ONLY)
	private Long id;
	
	private MultipartFile productUrl; 
	private String productImage;
	
	@JsonProperty(access = Access.WRITE_ONLY)
    private Long buyerId;
	
	private String buyerName;
	
	private String addreass;
	
	private String mobileNo;
	
	private Double price;
	
}

package com.app.dto;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProductDto {
	
@JsonProperty(access = Access.READ_ONLY)
private Long id;

private MultipartFile productUrl; 
private String productImage;

private String title;
private String description;
private String rating;
private Double price;

@JsonProperty(access = Access.WRITE_ONLY)
private Long supplier_id;
	
}

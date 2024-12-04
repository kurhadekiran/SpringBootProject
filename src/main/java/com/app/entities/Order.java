package com.app.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "order_tbl")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Order extends BaseEntity {
	
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long orderid;
    
	private String productImage;
	
	private Double price;
	
	private String buyerName;
	
	private String addreass;
	
	private Double mobileNo;
	
	public Order(String productImage, Double price, String buyerName, String addreass, Double mobileNo) {
		super();
		this.productImage = productImage;
		this.price = price;
		this.buyerName = buyerName;
		this.addreass = addreass;
		this.mobileNo = mobileNo;	
	}

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="buyerId")
	private Users buyer;
	

	
	
	
	
	
}

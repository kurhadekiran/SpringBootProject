
//package com.app.entities;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.Table;
//
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//@Entity
//@Table(name = "order_tbl")
//@NoArgsConstructor
//@AllArgsConstructor
//@Getter
//@Setter
//public class Order  {
//	
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long productId;
//	
//	@ManyToOne
//	@JoinColumn(name="buyerId")
//	private Users buyer;
//	
//	private String Buyername;
//	
//	private String productPrice;
//	
//	
//}

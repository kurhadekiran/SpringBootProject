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

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "product_tbl")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(exclude = { "users" } ,callSuper=true)
public class Product extends BaseEntity  {
//	
//@Id
//@GeneratedValue(strategy = GenerationType.IDENTITY)
//private Long product_id;	
	
private String productImage;
private String title;
private String description;
private String rating;   
private Double price;
//private Long supplier_id;
@JsonIgnore
@ManyToOne(fetch = FetchType.LAZY)
//@JoinColumn(name="supplier_id",  insertable = false, updatable = false)
@JoinColumn(name="supplier_id")
private Users supplier;

public Product(String productImage,String title,String description,String rating,Double price ) {
	super();
	this.productImage=productImage;
	this.title=title;
	this.description=description;
	this.rating=rating;
	this.price=price;
}

}

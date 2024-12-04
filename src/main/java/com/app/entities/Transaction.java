package com.app.entities;

import javax.persistence.Entity;
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
@Table(name = "transaction_tbl")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Transaction extends BaseEntity {

//@Id
//@GeneratedValue(strategy = GenerationType.IDENTITY)	
//private Long transactionId;
	private String buyerName;

	private String productName;
     
	private String investorName;
	private Long  amount;

	private String productImage;
	
@JsonIgnore
@ManyToOne
@JoinColumn(name="investorId")
private Users investor;

public Transaction(String buyerName, String productName, String investorName, Long amount, String productImage) {
	super();
	this.buyerName = buyerName;
	this.productName = productName;
	this.investorName = investorName;
	this.amount = amount;
	this.productImage = productImage;

}



	
}
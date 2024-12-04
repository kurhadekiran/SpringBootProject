package com.app.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "secure_users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(exclude = {"password","products"} ) // toString excluding password

public class Users extends BaseEntity  {
	
	@Column(length = 20)
	private String firstName;
	@Column(length = 20)
	private String lastName;
	@Column(length = 30, unique = true)
	private String email;
	@Column(length = 300, nullable = false)
	private String password;
	@Enumerated(EnumType.STRING)
	@Column(length = 30)
	private UserRole role;
	
	@OneToMany(mappedBy = "supplier",
			cascade = CascadeType.ALL ,
			orphanRemoval = true)
	private List<Product> products =new ArrayList<>();
	
	@OneToMany(mappedBy = "buyer",
			cascade = CascadeType.ALL ,
			orphanRemoval = true)
	private List<Order> orders =new ArrayList<>();
//	
//	
	@OneToMany(mappedBy = "investor",
			cascade = CascadeType.ALL ,
			orphanRemoval = true)
	private List<Transaction> trans =new ArrayList<>();
	
	
	public void addProduct(Product p) {
    products.add(p);  // supplier to product 	
    p.setSupplier(this);
	}
	
	public void  removeProduct(Product p) {
		products.remove(p);
		p.setSupplier(null);
	}
	
	public void addOrder(Order order) {
		orders.add(order);
		order.setBuyer(this);
		
	}
//	
	public void  removeOrder(Order order) {
		orders.remove(order);
		order.setBuyer(null);
	}
//	
	public void addTransaction(Transaction t) {
		trans.add(t);
		t.setInvestor(this);
	}
//	
	public void removeTransaction(Transaction t) {
		trans.remove(t);
		t.setInvestor(null);
	}

    public Users(String firstName, String lastName, String email, String password, UserRole role){
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.role = role;
	}

	
	
}

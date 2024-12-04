//package com.app.entities;
//import java.time.LocalDate;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.JoinColumn;
//import javax.persistence.MapsId;
//import javax.persistence.OneToOne;
//import javax.persistence.Table;
//
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//import lombok.ToString;
//
//@Entity
//@Table(name="user_adr")
//@NoArgsConstructor
//@Getter
//@Setter
//@ToString
//public class Address extends BaseEntity {
//	@Column(length=30)
//	private String addressLine1;
//	@Column(length=30)
//	private String addressLine2;
//	@Column(length=20)
//	private String city;
//	@Column(length=20)
//	private String state;
//	@Column(length=20)
//	private String country;
//	@Column(length=20,name="zip_code")
//	private String zipCode;
//	//one-to-one , uni dir Address 1--->1 Employee
//	//owning side : Address (since FK)
//	@OneToOne (fetch = FetchType.LAZY)//mandatory , o.w hib throws MappingExc
//	@JoinColumn(name="user_id")//optional : to specify name of FK col
//	@MapsId//optional BUT reco : to use shared PK between Emp n Address
//	private Users owner;
//	private LocalDate someDate;
//	public Address(String street, String city, String state, String country, String zipCode) {
//		super();
//		this.addressLine1=addressLine1;
//		this.addressLine2=addressLine2;	
//		this.city = city;
//		this.state = state;  
//		this.country = country;
//		this.zipCode = zipCode;
//	}	
//	
//}

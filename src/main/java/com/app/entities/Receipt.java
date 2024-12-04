//package com.app.entities;
//
//import java.time.LocalDateTime;
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
//@Table(name="order_tbl")
//@NoArgsConstructor
//@AllArgsConstructor
//@Getter
//@Setter
//public class Receipt {
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int receiptId;
//
//    @ManyToOne
//    @JoinColumn(name = "buyerId")
//    private Users buyer;
//
//    @ManyToOne
//    @JoinColumn(name = "productId")
//    private Product product;
//    
//    @ManyToOne
//    @JoinColumn(name = "investorId")
//    private Users investor;
//    
//    
//
//   // private int quantity;
//    private double amount;
//    
//    private LocalDateTime purchaseDate;
//}

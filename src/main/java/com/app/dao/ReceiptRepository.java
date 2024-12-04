//package com.app.dao;
//
//import java.util.List;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//
//
//import com.app.entities.Receipt;
//
//
//public interface ReceiptRepository extends JpaRepository<Receipt, Integer> {
//
//	@Query(value = "SELECT * FROM Receipt WHERE buyerId = ?1", nativeQuery = true)
//   // List<Receipt> getReceiptsByBuyerId(int customer);
//    List<Receipt> getReceiptsByBuyerId(Long buyerId);
//
//}

//package com.app.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.app.entities.Receipt;
//import com.app.service.ReceiptService;
// 
//@RestController
//@CrossOrigin
//public class ReceiptController {
//	
//	@Autowired
//	private ReceiptService receiptService;
//
//	//@PostMapping("/generate-receipt/{bookId}/{customerId}/{InvestorId}")
//	@PostMapping("/generate-receipt/{bookId}/{customerId}/{InvestorId}")
//	public ResponseEntity<?> generateReceipt(@PathVariable Long buyerId, @PathVariable Long productId, @PathVariable Long investorId) {
//	    Receipt receipt = receiptService.generateReceipt(buyerId, productId, investorId);
//	    if (receipt != null) {
//	        return ResponseEntity.ok(receipt);
//	    } else {
//	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Unable to generate receipt. Please check the input data.");
//	    }
//	}
//
//	@GetMapping("/order-History")
//	public List<Receipt> getReceipt(){
//		return receiptService.getAllReceipts();
//	}
//
//	@GetMapping("/order-History/{buyerId}")
//	public List<Receipt> getReceiptById(@PathVariable Long buyerId){
//		return receiptService.getReceiptsByBuyerId(buyerId);
//	}
//}

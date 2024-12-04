//package com.app.service;
//
//import java.time.LocalDateTime;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.app.dao.ProductDao;
//import com.app.dao.ReceiptRepository;
//import com.app.dao.UserEntityDao;
//import com.app.dto.ProductDto;
//import com.app.entities.Product;
//import com.app.entities.Receipt;
//import com.app.entities.Users;
//
//
//
//@Service
//public class ReceiptService 
//{
//	@Autowired
//	private ReceiptRepository receiptRepository;
//
//	@Autowired
//	private ProductDao productRepo;
//
//	@Autowired
//	private UserEntityDao userDao;
//
//	//public Receipt generateReceipt(int buyerId, int productId, int quantity)
//	public Receipt generateReceipt(Long buyerId, Long productId, Long investorId) {
//	    Users buyer = userDao.findById(buyerId).orElse(null);
//	    Product product = productRepo.findById(productId).orElse(null);
//	    Users investor = userDao.findById(investorId).orElse(null);
//
//	    if (buyer != null && product != null && investor != null) {
//	        double amount = product.getPrice();
//	        Receipt receipt = new Receipt();
//	        receipt.setBuyer(buyer);
//	        receipt.setProduct(product);
//	        receipt.setInvestor(investor);
//	        receipt.setAmount(amount);
//	        receipt.setPurchaseDate(LocalDateTime.now());
//
//	        // Update book stock
//	       
//	        productRepo.save(product);
//
//	        return receiptRepository.save(receipt);
//	    }
//
//	    return null; 
//	}
//	
//	public List<Receipt> getAllReceipts(){
//		return receiptRepository.findAll();
//	}
//	
//	public List<Receipt> getReceiptsByBuyerId(Long buyerId) {
//        return receiptRepository.getReceiptsByBuyerId(buyerId);
//    }
//}

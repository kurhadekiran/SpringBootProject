package com.app.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.OrderDto;
import com.app.dto.TransactionDto;
import com.app.entities.Order;
import com.app.entities.Product;
import com.app.entities.Transaction;
import com.app.service.TransactService;
import com.app.service.TransactionServiceImple;

@CrossOrigin
@RestController
@RequestMapping("/transaction")
public class TransactionController {
	
@Autowired
private TransactService transactService;
	
@Autowired
private TransactionServiceImple transactionSerImpl;

@PostMapping("/add")
public String addTransaction(TransactionDto dto){
		
try {
		
	Transaction transaction = new Transaction();
		
		BeanUtils.copyProperties(dto, transaction);
	 
	try { 
	 	 
		 String fileName = dto.getProductUrl().getOriginalFilename();
	     
		 String generatedFilename =fileName; 
		 
		// String imagePath="E:\\advance Java\\Spring Boot\\project\\photos\\New folder" + generatedFilename;
		 
		 dto.setProductImage(generatedFilename);
		  
		 InputStream is =dto.getProductUrl().getInputStream();
		  	 
//		 FileOutputStream os =new FileOutputStream("E:\\advance Java\\Spring Boot\\project\\photos\\New folder"+ generatedFilename);
		 FileOutputStream os =new FileOutputStream("E:\\advance Java\\Spring Boot\\project\\photos\\New folder" + generatedFilename);

		 FileCopyUtils.copy(is, os);
		 
		// product.setProductImage(generatedFilename)
	    }
	catch(IOException e) {
		     
	} 
	System.out.println("in add product " + transaction);
	
	//Product savedProduct = productService.addProduct(product);
	
	transactService.addTransaction(dto);
	 
	return "Data inserted sucessfuly..";
	
   }
catch (Exception e) {
	e.printStackTrace();

return "Internal server error in Transaction controller";
     
}

}
@GetMapping("/investor/{investorId}")
public ResponseEntity<?> getTransactionDetailsByInvestor (@PathVariable Long investorId )throws IOException{
	System.out.println("get Transaction by Investor "+investorId);
	return ResponseEntity.ok(transactService.getAllTransactionFromInvestor(investorId));
}  

@GetMapping(path="/productImage/{id}",produces=MediaType.IMAGE_JPEG_VALUE)
public byte[] getProductImage(@PathVariable Long id) throws IOException{
	Transaction transaction =  transactionSerImpl.findTransactionById(id);
//	//Product product =getProduct(id);
//	return Files.readAllBytes(Paths.get("E:\\advance Java\\Spring Boot\\project\\photos\\New folder" +transaction.getProductImage()));
	return Files.readAllBytes(Paths.get("E:\\advance Java\\Spring Boot\\project\\photos\\New folder" +transaction.getProductImage()));

}

@GetMapping("/viewalltransaction")
public List<Transaction> getAllTransaction(){

	return 	transactionSerImpl.findAllTransaction();
}
   
}
//

//
//@GetMapping("/investor/{investorId}")
//public ResponseEntity<?> getTransactionDetailsByInvestor (@PathVariable Long investorId )throws IOException{
//	System.out.println("get Transaction by Investor "+investorId);
//	return ResponseEntity.ok(transactService.getAllTransactionFromInvestor(investorId));
//}    
//  
//@GetMapping("/{investorId}")
//public ResponseEntity<?> getTransaction(@PathVariable Long investorId) {
//    try {
//    	Transaction transaction = transactionSerImpl.findTransactionById(investorId);
//        return ResponseEntity.ok(transaction);
//    } catch (Exception e) {
//        e.printStackTrace();
//        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal server error while retrieving product");
//    }
//}
//
//
//
//}

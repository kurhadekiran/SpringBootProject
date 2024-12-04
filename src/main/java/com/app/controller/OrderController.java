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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.OrderDto;
import com.app.dto.ProductDto;
import com.app.entities.Order;
import com.app.entities.Product;
import com.app.service.OrderService;
import com.app.service.OrderServiceImple;
import com.app.service.ProductService;
import com.app.service.ProductServiceImpl;

@CrossOrigin
@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired

	private OrderService orderService;

	@Autowired
	private OrderServiceImple orderServiceImple;
	
	

@PostMapping("/add")
public String addOrder(OrderDto dto){
		
try {
		
	Order order = new Order();
		
		BeanUtils.copyProperties(dto, order);
	 
	try { 
	 	 
		 String fileName = dto.getProductUrl().getOriginalFilename();
	     
		 String generatedFilename =fileName; 
		 
		// String imagePath="E:\\advance Java\\Spring Boot\\project\\photos\\New folder" + generatedFilename;
		 
		 dto.setProductImage(generatedFilename);
		  
		 InputStream is =dto.getProductUrl().getInputStream();
		  	 
//		 FileOutputStream os =new FileOutputStream("E:\\advance Java\\Spring Boot\\project\\photos\\New folder" + generatedFilename);
		 FileOutputStream os =new FileOutputStream("E:\\advance Java\\Spring Boot\\project\\photos\\New folder" + generatedFilename);

		 FileCopyUtils.copy(is, os);
		 
		// product.setProductImage(generatedFilename)
	    }
	catch(IOException e) {
		     
	} 
	System.out.println("in add order " + order);
	
	//Product savedProduct = productService.addProduct(product);
	
	orderService.addOrder(dto);
	 
	return "Data inserted sucessfuly..";
	
   }
catch (Exception e) {
	e.printStackTrace();

return "Internal server error in Order controller";
     
}

} 

@GetMapping("/buyer/{buyerId}")
public ResponseEntity<?> getOrderDetailsByBuyer (@PathVariable Long buyerId )throws IOException{
	System.out.println("get Order by Buyer "+buyerId);
	return ResponseEntity.ok(orderService.getAllOrderFromBuyer (buyerId));
} 

@GetMapping(path="/productImage/{id}",produces=MediaType.IMAGE_JPEG_VALUE)
public byte[] getProductImage(@PathVariable Long id) throws IOException{
	Order order =  orderServiceImple.findOrderById(id);
//	//Product product =getProduct(id);
//	return Files.readAllBytes(Paths.get("E:\\advance Java\\Spring Boot\\project\\photos\\New folder" +order.getProductImage()));
	return Files.readAllBytes(Paths.get("E:\\advance Java\\Spring Boot\\project\\photos\\New folder" +order.getProductImage()));

}
@GetMapping("/viewallorders")
public List<Order> getAllOrder(){

	return 	orderServiceImple.findAllOrder();
}

}
//@GetMapping("/viewallorders")
// public List<Order> getAllOrder(){
//
//	return 	orderServiceImple.findAllOrder();
// }
//}

//
//@GetMapping("/{orderId}")
//public ResponseEntity<?> getProduct(@PathVariable Long orderId) {
//    try {
//    	Order order = orderServiceImple.findOrderById(orderId);
//        return ResponseEntity.ok(order);
//    } catch (Exception e) {
//        e.printStackTrace();
//        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal server error while retrieving order");
//    }
//}
//

//	
//
//@DeleteMapping("/delete/{orderId}")
//public String delete(@PathVariable Long orderId) {
//	orderServiceImple.deleteOrderbyId(orderId);
//	return "Order deleted sucessfully";
//}
//	
//}

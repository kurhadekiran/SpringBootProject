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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ProductDto;
import com.app.entities.Product;
import com.app.service.ProductService;
import com.app.service.ProductServiceImpl;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@CrossOrigin
@RestController
@RequestMapping("/product")
public class ProductController {

@Autowired

private ProductService productService;

@Autowired
private ProductServiceImpl productServiceImple;
//
//@PostMapping("/add")
//public ResponseEntity<?> addProduct(ProductDto dto){
//		
//try {
//		
//		Product product = new Product();
//		
//		BeanUtils.copyProperties(dto, product);
//	 
//	try {
//	 	 
//		 String fileName = dto.getProductUrl().getOriginalFilename();
//	     
//		 String generatedFilename =fileName; 
//		 
//		 String imagePath="E:\\advance Java\\Spring Boot\\project\\photos\\New folder" + generatedFilename;
//		 
//		 dto.setProductImage(imagePath);
//		  
//		 InputStream is =dto.getProductUrl().getInputStream();
//		  	 
//		 FileOutputStream os =new FileOutputStream("E:\\advance Java\\Spring Boot\\project\\photos\\New folder" + generatedFilename);
//		 
//		 FileCopyUtils.copy(is, os);
//		 
//		// product.setProductImage(generatedFilename)
//	    }
//	catch(IOException e) {
//		     
//	} 
//	System.out.println("in add product " + product);
//	
//	//Product savedProduct = productService.addProduct(product);
//	
//	return ResponseEntity.status(HttpStatus.CREATED).body(productService.addProduct(dto));
//	
//   }
//catch (Exception e) {
//	e.printStackTrace();
//
//return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal server error in Product controller");
//      }
//    }

@PostMapping("/add")
public String addProduct(ProductDto dto){
		
try {
		
		Product product = new Product();
		
		BeanUtils.copyProperties(dto, product);
	 
	try { 
	 	 
		 String fileName = dto.getProductUrl().getOriginalFilename();
	     
		 String generatedFilename =fileName; 
		 
		// String imagePath="E:\\advance Java\\Spring Boot\\project\\photos\\New folder" + generatedFilename;
		 
		 dto.setProductImage(generatedFilename);
		  
		 InputStream is =dto.getProductUrl().getInputStream();
		 FileOutputStream os =new FileOutputStream("E:\\advance Java\\Spring Boot\\project\\photos\\New folder" + generatedFilename);

//		 FileOutputStream os =new FileOutputStream("E:\\advance Java\\Spring Boot\\project\\photos\\New folder" + generatedFilename);
		 
		 FileCopyUtils.copy(is, os);
		 
		// product.setProductImage(generatedFilename)
	    }
	catch(IOException e) {
		     
	} 
	System.out.println("in add product " + product);
	
	//Product savedProduct = productService.addProduct(product);
	
	productService.addProduct(dto);
	 
	return "Data inserted sucessfuly..";
	
   }
catch (Exception e) {
	e.printStackTrace();

return "Internal server error in Product controller";
     
}
   
}

@GetMapping("/viewallproducts")
 public List<Product> getAllProduct(){

	return 	productServiceImple.findAllProduct();
 }

//@GetMapping("/{id}")
//public Product getProduct(@PathVariable Long id) {
//	System.out.println("product id"+ id);
//	return productServiceImple.findProductById(id);
//}
//@GetMapping("/buyer/{investor_id}")
@GetMapping("/supplier/{supplier_id}")
public ResponseEntity<?> getProductDetailsBySupplier (@PathVariable Long supplier_id )throws IOException{
	System.out.println("get Product by Supplier "+supplier_id);
	return ResponseEntity.ok(productService.getAllProductFromSupplier(supplier_id));
} 

@GetMapping("/{id}")
public ResponseEntity<?> getProduct(@PathVariable Long id) {
    try {
        Product product = productServiceImple.findProductById(id);
        return ResponseEntity.ok(product);
    } catch (Exception e) {
        e.printStackTrace();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal server error while retrieving product");
    }
}

@GetMapping(path="/productImage/{id}",produces=MediaType.IMAGE_JPEG_VALUE)
public byte[] getProductImage(@PathVariable Long id) throws IOException{
	
	Product product =  productServiceImple.findProductById(id);
	//Product product =getProduct(id);
	return Files.readAllBytes(Paths.get("E:\\advance Java\\Spring Boot\\project\\photos\\New folder" +product.getProductImage()));

//	return Files.readAllBytes(Paths.get("E:\\advance Java\\Spring Boot\\project\\photos\\New folder" +product.getProductImage()));
}

@DeleteMapping("/delete/{id}")
public String deleteProduct(@PathVariable Long id) {
	productServiceImple.deleteProductbyId(id);
	return "Product deleted sucessfully";
}
 
@PutMapping("/update")
public ResponseEntity<?> updateProduct(ProductDto dto ){

	System.out.println("in update emp" + dto.getId()+ "" + dto);
	
    return ResponseEntity.ok(productServiceImple.updateProduct(dto.getId(), dto));
}
}
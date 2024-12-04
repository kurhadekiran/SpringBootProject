//package com.app.controller;
//
//import java.io.IOException;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PatchMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.multipart.MultipartFile;
//import org.springframework.http.ResponseEntity;
//
//import com.app.entities.Product;
//import com.app.service.Product2ServiceImpl;
//
//
//@RestController
//@RequestMapping(value = "/product")
//public class Product2Controller {
//
//	@Autowired
//    private Product2ServiceImpl productService;
//     
//	
//    @PostMapping(value = "/create", consumes = "multipart/form-data")
//    public ResponseEntity<?> createProduct(Product product, @RequestParam("file") MultipartFile file) throws IOException {
//        productService.createProduct(product, file);
//        return ResponseEntity.ok().build();
//    }
//}

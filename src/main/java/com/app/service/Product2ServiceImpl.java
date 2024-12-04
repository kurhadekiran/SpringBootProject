//package com.app.service;
//
//import java.io.IOException;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.web.multipart.MultipartFile;
//
//import com.app.dao.ProductDao;
//import com.app.entities.Product;
//
//@Service
//public class Product2ServiceImpl {
//	@Autowired
//    private ProductDao prodDao;
//
//    @Autowired
//    private ImageHandlingService2 imageService;
//
//    @Transactional
//    public void createProduct(Product product, MultipartFile file) throws IOException {
//        Product savedProduct = prodDao.save(product);
//        if (file != null && !file.isEmpty()) {
//            imageService.uploadImage(savedProduct.getProduct_id(), file);
//        }
//    }
//}

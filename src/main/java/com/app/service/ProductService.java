package com.app.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.app.dto.ApiResponse;
import com.app.dto.ProductDto;

public interface ProductService {
	
	
//	List<ProductDto> getAllProductFromSupplier(Long supplier_id); 
//    
//    List<ProductDto> getAllProductFromAllSupplier();
    
    ProductDto addProduct(ProductDto dto);
    
    List<ProductDto> getAllProductFromSupplier(Long supplier_id) ;
    
    
//    ProductDto updateProductbyId(Long supplier_id,Long product_id);
//    
//    ApiResponse deleteProductById(Long product_id);
    
    
    
    
    
    
    
    
}

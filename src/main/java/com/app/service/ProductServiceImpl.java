package com.app.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dao.ProductDao;
import com.app.dao.UserEntityDao;
import com.app.dto.ProductDto;
import com.app.entities.Product;
import com.app.entities.Users;

@Transactional
@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductDao productRepo;
	
	@Autowired
	private UserEntityDao supplierRepo;
	
	@Autowired
	private ModelMapper mapper;
	
//	public void addProducts(Product product) {
//		productRepo.save(product);
//	}
	
	@Override
	public  ProductDto addProduct(ProductDto dto) {
		  
		Users supplier =supplierRepo.findById(dto.getSupplier_id())
				.orElseThrow(() -> new ResourceNotFoundException("Invalid  Supplier_Id!!!"));
		 
		Product product = mapper.map(dto,Product.class);
		 
		 supplier.addProduct(product);
		 
		 Product saveProduct=productRepo.save(product);
		 
		 System.out.println("product entity id " + product.getId() + " " + saveProduct.getId());
		 
		 return mapper.map(saveProduct,ProductDto.class );
		  
	}
	
	
	public Product findProductById(Long id){
		return productRepo.findById(id).get();
	}
	
	
	public List<Product> findAllProduct(){
		return productRepo.findAll();
	}
	
	
	@Override
	public List<ProductDto> getAllProductFromSupplier(Long supplier_id) {
		List<Product> productList = productRepo.findBySupplier_Id(supplier_id);
		return productList.stream().map(product -> mapper.map(product, ProductDto.class)).collect(Collectors.toList());
	}
	
	public void deleteProductbyId(Long id) {
		productRepo.deleteById(id);
	}
	
	public ProductDto updateProduct(Long id ,ProductDto dto) {
		System.out.println("in product service Imple update id" + id + "" + dto);
		Product product =productRepo.findById(id)
	.orElseThrow(() -> new ResourceNotFoundException("Invalid Product ID , product not found !!!!"));
	
	//Users supplier =supplierRepo.findById(dto.getSupplier_id())
	//		.orElseThrow(() -> new ResourceNotFoundException("Invalid Supplier Id!!!"));
	
	mapper.map(dto,product);
	System.out.println("after mapping " + product);
	
	//supplier.addProduct(product);
	dto.setId(id);
	
	return dto;

	}
	
	}	




//	
//	public void updateProductById(Long id, Product product) {
//		
//		Product temp = productRepo.findById(id).get();
//		temp.setTitle(product.getTitle());
//		temp.setDescription(product.getDescription());
//		temp.setRating(product.getRating());
//		temp.setPrice(product.getPrice());
//		
//		productRepo.save(temp);
//		
//	}
	
	


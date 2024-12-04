//package com.app.service;
//
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.StandardCopyOption;
//
//import javax.annotation.PostConstruct;
//import javax.transaction.Transactional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//import org.springframework.util.FileCopyUtils;
//import org.springframework.web.multipart.MultipartFile;
//
//import com.app.custom_exceptions.ResourceNotFoundException;
//import com.app.dao.ProductDao;
//import com.app.dto.ApiResponse;
//
//import com.app.entities.Product;
//
//@Service
//@Transactional
//public class ImageHandlingServiceImpl2 implements ImageHandlingService2 {
//	@Value("${file.upload.location}")
//	private String uploadFolder;
//
//	@Autowired
//	private ProductDao prodDao;
//
//	@PostConstruct
//	public void init() throws IOException {
//		// check if images folder exists , o.w create one
//		Path path = Path.of(uploadFolder);
//		if (!Files.exists(path)) {
//			Files.createDirectories(path);
//			System.out.println("Folder created!");
//		}
//	}
//
//	@Override
//	public ApiResponse uploadImage(Long productId, MultipartFile image) throws IOException {
//		// get emp from it's id
//		Product prodt = prodDao.findById(productId).orElseThrow(() -> new ResourceNotFoundException("Invalid Emp ID !!!"));
//		// emp : persistent
//		Path path = Path.of(uploadFolder.concat(image.getOriginalFilename()));
//		Files.write(path, image.getBytes());
//		// store the path in db
//		
//		prodt.setProductImage(path.toString());
//		//
//		
//		return new ApiResponse("File " + path.getFileName() + " uploaded successfully!");
//	}
//
//	@Override
//	public byte[] serveImage(Long productId) throws IOException {
//		// get emp from it's id
//		Product prodt = prodDao.findById(productId).orElseThrow(() -> new ResourceNotFoundException("Invalid Emp ID !!!"));
//		// emp : persistent
//		String imagePath = prodt.getProductImage();
//		if (imagePath == null)
//			throw new ResourceNotFoundException("Image not yet uploaded!!!!");
//		Path path = Path.of(imagePath);
//		return Files.readAllBytes(path);
//	}
//
//}

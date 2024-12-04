//package com.app.service;
//
//import java.time.LocalDate;
//import java.util.Map;
//
//import javax.annotation.PostConstruct;
//
//import org.modelmapper.AbstractConverter;
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.app.custom_exceptions.ResourceNotFoundException;
//import com.app.dao.AddressDao;
//import com.app.dao.UserEntityDao;
//import com.app.dto.AddressDTO;
//import com.app.dto.ApiResponse;
//import com.app.entities.Address;
//import com.app.entities.Users;
//
//@Service
//@Transactional
//public class AddressServiceImpl implements AddressService {
//	@Autowired
//	private UserEntityDao userRepo;
//
//	@Autowired
//	private AddressDao adrRepo;
//
//	@Autowired
//	private ModelMapper mapper;	
//
//	@Override
//	public AddressDTO getAddressDetails(Long addressId) {
//		// TODO Auto-generated method stub
//		return mapper.map(
//				adrRepo.findById(addressId).orElseThrow(
//						() -> new ResourceNotFoundException("Invalid user  Id Or Address not yet assigned !!!!")),
//				AddressDTO.class);
//	}
//
//	@Override
//	public ApiResponse assignUserAddress(Long userId, AddressDTO address) {
//		// validate user : can be replaced by getReferenceById : a proxy
//		Users user = userRepo.findById(userId)
//				.orElseThrow(() -> new ResourceNotFoundException("Invalid user ID!!!"));
//		// map dtp --> entity
//		Address addressEntity = mapper.map(address, Address.class);
//		// establish un dir link , adr ---> emp
//		addressEntity.setOwner(user);
//		// save adr details
//		adrRepo.save(addressEntity);
//		return new ApiResponse("Assigned new address to User , " + user.getFirstName());
//	}
//
//	@Override
//	public ApiResponse updateUserAddress(Long userId, AddressDTO address) {
//		Address addressEntity = adrRepo.findById(userId)
//				.orElseThrow(() -> new ResourceNotFoundException("Address is not yet assigned !!!! "));
//	
//		mapper.map(address, addressEntity);
//		// save adr details
//		adrRepo.save(addressEntity);
//		return new ApiResponse("Updated address for  user ");
//
//	}
//
//	@Override
//	public AddressDTO patchUserAddress(Long userId, Map<String, Object> map) {
//		// chk if adr exists
//		Address address = adrRepo.findById(userId)
//				.orElseThrow(() -> new ResourceNotFoundException("Invalid Address Id!!!!"));
//			
//		mapper.map(map,address);
//		
//		System.out.println("updated address " + address);
//		return mapper.map(address, AddressDTO.class);
//	}
//
//}

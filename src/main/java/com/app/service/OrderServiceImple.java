package com.app.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dao.OrderDao;
import com.app.dao.ProductDao;
import com.app.dao.UserEntityDao;
import com.app.dto.OrderDto;
import com.app.dto.ProductDto;
import com.app.entities.Order;
import com.app.entities.Product;
import com.app.entities.Users;

@Transactional
@Service
public class OrderServiceImple  implements OrderService{

	@Autowired
	private OrderDao orderRepo;
	
	@Autowired
	private UserEntityDao buyerRepo;
	
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public  OrderDto addOrder(OrderDto dto) {
		  
		Users buyer =buyerRepo.findById(dto.getBuyerId())
				.orElseThrow(() -> new ResourceNotFoundException("Invalid  BuyerId!!!"));
		 
		Order order = mapper.map(dto,Order.class);
		 
		 buyer.addOrder(order);
		 
		 Order saveOrder=orderRepo.save(order);
		 
		 System.out.println("order entity id " + order.getId()  + " " + saveOrder.getId());
		 
		 return mapper.map(saveOrder,OrderDto.class );
		  
	}

	
	public Order findOrderById(Long id){
		return orderRepo.findById(id).get();
	}


@Override
public List<OrderDto> getAllOrderFromBuyer(Long buyerId) {
	List<Order> orderList = orderRepo.findByBuyerId(buyerId);
	return orderList.stream().map(order -> mapper.map(order, OrderDto.class)).collect(Collectors.toList());
}

public List<Order> findAllOrder(){
	return orderRepo.findAll();
}
}
//	
//
//

//
//	public void deleteOrderbyId(Long orderId) {
//		orderRepo.deleteById(orderId);
//		
//	}
//
//	
//	
//}

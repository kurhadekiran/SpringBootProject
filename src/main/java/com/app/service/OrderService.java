package com.app.service;

import java.util.List;

import com.app.dto.OrderDto;

public interface OrderService {

	OrderDto addOrder(OrderDto dto);
    
    List<OrderDto> getAllOrderFromBuyer(Long buyerId) ;
}

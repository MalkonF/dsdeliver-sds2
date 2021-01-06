package me.malkon.dsdeliver.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import me.malkon.dsdeliver.dto.OrderDto;
import me.malkon.dsdeliver.entities.Order;
import me.malkon.dsdeliver.repositories.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository repository;

	@Transactional(readOnly = true)
	public List<OrderDto> findAll(){
		List<Order> list = repository.findOrdersWithProducts();
		return list.stream().map(x -> new OrderDto(x)).collect(Collectors.toList());
	}


}

package com.j6.service;

import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.j6.entity.Order;

public interface OrderService {

	Order create(JsonNode order);

	Order findById(Long id);

	List<Order> findByUsername(String username);

}

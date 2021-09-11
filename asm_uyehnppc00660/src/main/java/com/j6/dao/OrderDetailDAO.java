package com.j6.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.j6.entity.OrderDetail;

public interface OrderDetailDAO extends JpaRepository<OrderDetail, Long> {

}

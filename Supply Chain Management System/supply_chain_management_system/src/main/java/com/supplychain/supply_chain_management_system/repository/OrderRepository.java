package com.supplychain.supply_chain_management_system.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.supplychain.supply_chain_management_system.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByBuyerUsername(String username);
    List<Order> findByProductFarmerUsername(String farmerUsername);
}


package com.supplychain.supply_chain_management_system.service;

import java.util.List;

import com.supplychain.supply_chain_management_system.model.Order;

public interface OrderService {
    void placeOrder(String buyerUsername, Long productId, int quantity);
    List<Order> getOrdersForFarmer(String farmerUsername);
    List<Order> getOrdersForBuyer(String buyerUsername);
    void markAsShipped(Long orderId);
}


package com.supplychain.supply_chain_management_system.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supplychain.supply_chain_management_system.model.AppUser;
import com.supplychain.supply_chain_management_system.model.Order;
import com.supplychain.supply_chain_management_system.model.Product;
import com.supplychain.supply_chain_management_system.repository.OrderRepository;
import com.supplychain.supply_chain_management_system.repository.ProductRepository;
import com.supplychain.supply_chain_management_system.repository.UserRepository;
import com.supplychain.supply_chain_management_system.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

   
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public void placeOrder(String buyerUsername, Long productId, int quantity) {
        AppUser buyer = userRepository.findByUsername(buyerUsername);
        Product product = productRepository.findById(productId).orElseThrow();

        Order order = new Order();
        order.setBuyer(buyer);
        order.setProduct(product);
        order.setQuantity(quantity);
        order.setOrderDate(LocalDate.now());
        order.setStatus("Ordered");

        orderRepository.save(order);
    }

    @Override
    public List<Order> getOrdersForBuyer(String buyerUsername) {
        return orderRepository.findByBuyerUsername(buyerUsername);
    }

    @Override
    public List<Order> getOrdersForFarmer(String farmerUsername) {
        return orderRepository.findByProductFarmerUsername(farmerUsername);
    }

    @Override
    public void markAsShipped(Long orderId) {
        Order order = orderRepository.findById(orderId).orElseThrow();
        order.setStatus("Shipped");
        orderRepository.save(order);
    }
}












// @Service
// public class OrderServiceImpl implements OrderService {

//     @Autowired
//     private OrderRepository orderRepository;

//     @Autowired
//     private ProductRepository productRepository;

//     @Autowired
//     private UserRepository userRepository;

//     @Override
//     public void placeOrder(String buyerUsername, Long productId, int quantity) {
//         User buyer = userRepository.findByUsername(buyerUsername);
//         Product product = productRepository.findById(productId).orElseThrow();

//         Order order = new Order();
//         order.setBuyer(buyer);
//         order.setProduct(product);
//         order.setQuantity(quantity);
//         order.setOrderDate(LocalDate.now());
//         order.setStatus("Ordered");

//         orderRepository.save(order);
//     }

//     @Override
//     public List<Order> getOrdersForBuyer(String buyerUsername) {
//         return orderRepository.findByBuyerUsername(buyerUsername);
//     }

//     @Override
//     public List<Order> getOrdersForFarmer(String farmerUsername) {
//         return orderRepository.findByProductFarmerUsername(farmerUsername);
//     }

//     @Override
//     public void markAsShipped(Long orderId) {
//         Order order = orderRepository.findById(orderId).orElseThrow();
//         order.setStatus("Shipped");
//         orderRepository.save(order);
//     }
// }

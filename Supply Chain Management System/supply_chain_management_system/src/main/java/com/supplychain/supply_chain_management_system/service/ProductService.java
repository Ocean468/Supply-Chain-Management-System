package com.supplychain.supply_chain_management_system.service;

import java.util.List;

import com.supplychain.supply_chain_management_system.model.AppUser;
import com.supplychain.supply_chain_management_system.model.Product;

public interface ProductService {
    void saveProduct(Product product);
    List<Product> getAllProducts();
    List<Product> getProductsByFarmer(AppUser farmer);
    Product getProductById(Long id);
    void deleteProduct(Long id);
}


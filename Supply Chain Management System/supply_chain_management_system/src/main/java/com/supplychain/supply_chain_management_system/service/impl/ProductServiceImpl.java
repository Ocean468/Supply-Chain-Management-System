package com.supplychain.supply_chain_management_system.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supplychain.supply_chain_management_system.model.AppUser;
import com.supplychain.supply_chain_management_system.model.Product;
import com.supplychain.supply_chain_management_system.repository.ProductRepository;
import com.supplychain.supply_chain_management_system.service.ProductService;


@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository repo;

    @Override
    public void saveProduct(Product product) {
        repo.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return repo.findAll();
    }

    @Override
    public List<Product> getProductsByFarmer(AppUser farmer) {
        return repo.findByFarmer(farmer);
    }

    @Override
    public Product getProductById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public void deleteProduct(Long id) {
        repo.deleteById(id);
    }
}

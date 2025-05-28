package com.supplychain.supply_chain_management_system.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.supplychain.supply_chain_management_system.model.AppUser;
import com.supplychain.supply_chain_management_system.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByFarmer(AppUser farmer);
}


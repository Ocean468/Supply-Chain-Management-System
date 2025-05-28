package com.supplychain.supply_chain_management_system.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.supplychain.supply_chain_management_system.model.AppUser;

public interface UserRepository extends JpaRepository<AppUser, Integer> {
    AppUser findByUsername(String username);
}


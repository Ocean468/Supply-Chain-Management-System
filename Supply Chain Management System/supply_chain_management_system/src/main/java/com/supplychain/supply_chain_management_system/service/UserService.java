package com.supplychain.supply_chain_management_system.service;


import java.util.List;

import com.supplychain.supply_chain_management_system.model.AppUser;

public interface UserService {
    void save(AppUser user);
    AppUser findByUsername(String username);
    List<AppUser> getAllUsers();  // For admin
}


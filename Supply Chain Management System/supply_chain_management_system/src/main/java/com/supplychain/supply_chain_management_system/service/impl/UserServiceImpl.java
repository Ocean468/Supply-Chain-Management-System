package com.supplychain.supply_chain_management_system.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.supplychain.supply_chain_management_system.model.AppUser;
import com.supplychain.supply_chain_management_system.repository.UserRepository;
import com.supplychain.supply_chain_management_system.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repo;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Override
    public void save(AppUser user) {
        user.setPassword(encoder.encode(user.getPassword()));
        repo.save(user);
    }

    @Override
    public AppUser findByUsername(String username) {
        return repo.findByUsername(username);
    }

    @Override
    public List<AppUser> getAllUsers() {
        return repo.findAll();  // ✅ Works correctly
    }
}


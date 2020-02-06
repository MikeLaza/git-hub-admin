package com.iba.dias.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iba.dias.admin.repository.AdminRepository;

@Service
public class AdminService {
    @Autowired
    private AdminRepository repository;
}

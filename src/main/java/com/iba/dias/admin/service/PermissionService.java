package com.iba.dias.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iba.dias.admin.repository.PermissionRepository;

@Service
public class PermissionService {
    @Autowired
    private PermissionRepository repository;
}

package com.iba.dias.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iba.dias.admin.repository.ActionRepository;

@Service
public class ActionService {
    @Autowired
    private ActionRepository repository;
}

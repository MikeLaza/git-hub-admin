package com.iba.dias.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iba.dias.admin.model.ActionType;
import com.iba.dias.admin.repository.ActionTypeRepository;

@Service
public class ActionTypeService {
    @Autowired
    private ActionTypeRepository repository;
}

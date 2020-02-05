package com.iba.dias.admin.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iba.dias.admin.model.Admin;
import com.iba.dias.admin.repository.AdminRepository;

@RestController
@RequestMapping("/admins")
public class AdminController {
    @Autowired
    private AdminRepository repository;

    @GetMapping
    public ResponseEntity<List<Admin>> getAllAdmins() {
        return ResponseEntity.ok().body(repository.findAll());
    }

    @GetMapping(value = "/{id}")
    private ResponseEntity<Admin> accountById(@PathVariable Long id) {
        return this.repository
                .findById(id)
                .map(ResponseEntity.accepted()::body)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    private ResponseEntity<Admin> addAccount(@Valid @RequestBody Admin entity) {
        return ResponseEntity
                .ok()
                .body(this.repository.save(entity));
    }

    @PutMapping(value = "/{id}")
    private ResponseEntity<Admin> updateAccount(@RequestBody Admin entity, @PathVariable Long id) {
        return this.repository
                .findById(id)
                .map(accountFound -> {
                    accountFound.merge(entity);
                    return ResponseEntity
                            .accepted()
                            .body(this.repository.save(entity));
                }).orElse(ResponseEntity.notFound().build());
    }


}

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

import com.iba.dias.admin.model.Permission;
import com.iba.dias.admin.repository.PermissionRepository;

@RestController
@RequestMapping("/permissions")
public class PermissionController {
    @Autowired
    private PermissionRepository repository;

    @GetMapping
    public ResponseEntity<List<Permission>> getAllAdmins() {
        return ResponseEntity.ok().body(repository.findAll());
    }

    @GetMapping(value = "/{id}")
    private ResponseEntity<Permission> accountById(@PathVariable Long id) {
        return this.repository
                .findById(id)
                .map(ResponseEntity.accepted()::body)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    private ResponseEntity<Permission> addAccount(@Valid @RequestBody Permission entity) {
        return ResponseEntity
                .ok()
                .body(this.repository.save(entity));
    }

    @PutMapping(value = "/{id}")
    private ResponseEntity<Permission> updateAccount(@RequestBody Permission entity, @PathVariable Long id) {
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

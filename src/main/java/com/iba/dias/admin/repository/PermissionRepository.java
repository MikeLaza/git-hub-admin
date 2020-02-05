package com.iba.dias.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iba.dias.admin.model.Permission;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, Long> {
}

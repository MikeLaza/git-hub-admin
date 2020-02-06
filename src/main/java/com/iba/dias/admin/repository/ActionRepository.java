package com.iba.dias.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iba.dias.admin.model.Action;

public interface ActionRepository  extends JpaRepository<Action, Long> {
}

package com.API.first.repository;

import com.API.first.model.ClienteModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<ClienteModel, Integer> {
}

package com.API.first.repository;

import com.API.first.model.VendasModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendasRepository extends JpaRepository<VendasModel, Integer> {
}

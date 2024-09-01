package com.API.first.repository;
import com.API.first.model.ColecaoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ColecaoRepository  extends JpaRepository<ColecaoModel, Integer> {
}

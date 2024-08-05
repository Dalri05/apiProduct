package com.API.first.repository;

import com.API.first.enums.ClienteEnum;
import com.API.first.model.ClienteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClienteRepository extends JpaRepository<ClienteModel, Integer> {

    @Query("select c from ClienteModel c where c.situacao = :situacao")
    List<ClienteModel> buscarClientesInativo(@Param("situacao") ClienteEnum situacao);
}

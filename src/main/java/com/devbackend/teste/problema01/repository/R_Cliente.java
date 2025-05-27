package com.devbackend.teste.problema01.repository;

import com.devbackend.teste.problema01.model.M_Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface R_Cliente extends JpaRepository<M_Cliente, Long> {
}

package com.example.teste.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.teste.entities.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    
}

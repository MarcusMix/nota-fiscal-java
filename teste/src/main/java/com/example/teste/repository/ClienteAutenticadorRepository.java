package com.example.teste.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.teste.entities.ClienteAutenticador;

public interface ClienteAutenticadorRepository extends JpaRepository<ClienteAutenticador, Long>{
    ClienteAutenticador findByUsername(String username);
}

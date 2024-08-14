package com.example.teste.entities;

import java.security.NoSuchAlgorithmException;

import com.example.teste.util.Hashing;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ClienteAutenticador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String username;
    private String passwordHash;

    public ClienteAutenticador() {
    }

    public ClienteAutenticador(String id, String username, String passwordHash) {
        this.id = id;
        this.username = username;
        this.passwordHash = passwordHash;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return passwordHash;
    }

    public void setPassword(String passwordHash) throws NoSuchAlgorithmException {
        this.passwordHash = Hashing.hash(passwordHash);
    }

}

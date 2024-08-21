package com.example.teste.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.teste.entities.Cliente;
import com.example.teste.repository.ClienteRepository;
import com.example.teste.util.ClienteMapper;
import com.example.teste.util.Hashing;
import com.example.teste.util.ValidaEmail;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    // mudar para ClienteDTO
    public ResponseEntity <Cliente> criarCliente(Cliente cliente, HttpServletResponse response) {
        if(!ValidaEmail.validarCaracterArroba(cliente.getEmail())) {
            return ResponseEntity.status(422).build();
        }

        try {
            String id_cliente = Hashing.hash(cliente.getId().toString());
            Cookie session_cookie = new Cookie("id_cliente", id_cliente);
            session_cookie.setHttpOnly(true);
            session_cookie.setSecure(true);
            session_cookie.setMaxAge(60 * 60);
            session_cookie.setPath("/");

            response.addCookie(session_cookie);
        } catch (Exception e) {
            // TODO: handle exception
            e.getMessage();
        }

        // Cliente cliente = ClienteMapper.toEntity(clienteDTO);
        clienteRepository.save(cliente);
        return ResponseEntity.ok(cliente);

    }
    
    public List<Cliente> obterTodosClientes() {
        return clienteRepository.findAll();
    }

    public Optional<Cliente> obterClientePorId(Long id) {
        return clienteRepository.findById(id);
    }

    public Cliente atualizarCliente(Long id, Cliente cliente) {
        Optional<Cliente> clienteExistente = clienteRepository.findById(id);
        if(clienteExistente.isEmpty()) {
            return null;
        }
        
        Cliente c = clienteExistente.get();
        c.setNome(cliente.getNome());
        c.setEmail(cliente.getEmail());
        return clienteRepository.save(c);

        // if(clienteExistente.isPresent()) {
        //     Cliente c = clienteExistente.get();
        //     c.setNome(cliente.getNome());
        //     c.setEmail(cliente.getEmail());
        //     return clienteRepository.save(c);
        // } else {
        //     return null;
        // }
    }

    public boolean deletarCliente(Long id) {
        Optional<Cliente> clienteExistente = clienteRepository.findById(id);
        if (clienteExistente.isEmpty()) {
            return false;
        }
        
        clienteRepository.deleteById(id);
        return true;
        
        // if(clienteExistente.isPresent()) {
            // clienteRepository.deleteById(id);
            //     return true;
        // } else {
        //     return false;
        // }
    }
}

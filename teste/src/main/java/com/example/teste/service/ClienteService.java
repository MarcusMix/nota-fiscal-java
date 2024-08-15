package com.example.teste.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.teste.entities.Cliente;
import com.example.teste.repository.ClienteRepository;
import com.example.teste.util.ClienteMapper;
import com.example.teste.util.ValidaEmail;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    // mudar para ClienteDTO
    public ResponseEntity <Cliente> criarCliente(Cliente cliente) {
        if(!ValidaEmail.validarCaracterArroba(cliente.getEmail())) {
            return ResponseEntity.status(422).build();
        }

        // Cliente cliente = ClienteMapper.toEntity(clienteDTO);

        return ResponseEntity.status(200).build();

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

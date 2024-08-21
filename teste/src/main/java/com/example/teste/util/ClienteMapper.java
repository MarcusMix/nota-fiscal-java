package com.example.teste.util;

import java.security.NoSuchAlgorithmException;

import com.example.teste.dto.ClienteAutenticadorDTO;
import com.example.teste.dto.ClienteDTO;
import com.example.teste.dto.EnderecoDTO;
import com.example.teste.entities.Cliente;
import com.example.teste.entities.ClienteAutenticador;
import com.example.teste.entities.Endereco;

public class ClienteMapper {

    public static ClienteDTO toDTO(Cliente cliente) {
        EnderecoDTO enderecoDTO = new EnderecoDTO();
        enderecoDTO.setId(cliente.getEndereco().getId());
        enderecoDTO.setCep(cliente.getEndereco().getCep());
        enderecoDTO.setNumero(cliente.getEndereco().getNumero());
        enderecoDTO.setComplemento(cliente.getEndereco().getComplemento());

        ClienteAutenticadorDTO clienteAutenticador = new ClienteAutenticadorDTO();
        clienteAutenticador.setUsername(cliente.getClienteAutenticador().getUsername());
        clienteAutenticador.setPassword(cliente.getClienteAutenticador().getPassword());

        return new ClienteDTO(cliente.getId(), cliente.getNome(), cliente.getEmail(), enderecoDTO, clienteAutenticador);
    }
 
    public static Cliente toEntity(ClienteDTO clienteDTO) {
        Cliente cliente = new Cliente();
        cliente.setEmail(clienteDTO.getEmail());
        cliente.setNome(clienteDTO.getNome());
        cliente.setId(clienteDTO.getId());

        if (clienteDTO.getEnderecoDTO() != null) {
            Endereco endereco = new Endereco();
            endereco.setId(clienteDTO.getEnderecoDTO().getId());
            endereco.setCep(clienteDTO.getEnderecoDTO().getCep());
            endereco.setNumero(clienteDTO.getEnderecoDTO().getNumero());
            endereco.setComplemento(clienteDTO.getEnderecoDTO().getComplemento());
            cliente.setEndereco(endereco);
        }

        if(clienteDTO.getClienteAutenticadorDTO().getPassword() != null) {
            ClienteAutenticador clienteAutenticador = new ClienteAutenticador();
            clienteAutenticador.setUsername(clienteDTO.getEmail());
            try {
                clienteAutenticador.setPassword(clienteDTO.getClienteAutenticadorDTO().getPassword());
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
            cliente.setClienteAutenticador(clienteAutenticador);
        }

        return cliente;
    }
}

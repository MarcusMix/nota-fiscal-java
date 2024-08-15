package com.example.teste.dto;

public class ClienteDTO {

    private Long id;
    private String nome;
    private String email;
    private EnderecoDTO enderecoDTO;
    private ClienteAutenticadorDTO clienteAutenticadorDTO;

    public ClienteDTO(Long id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }

    public ClienteDTO(Long id, String nome, String email, EnderecoDTO enderecoDTO, ClienteAutenticadorDTO clienteAutenticadorDTO) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.enderecoDTO = enderecoDTO;
        this.clienteAutenticadorDTO = clienteAutenticadorDTO;
    }

    public ClienteDTO(ClienteAutenticadorDTO clienteAutenticadorDTO) {
        this.clienteAutenticadorDTO = clienteAutenticadorDTO;
    }

    public ClienteDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public EnderecoDTO getEnderecoDTO() {
        return enderecoDTO;
    }

    public ClienteAutenticadorDTO getClienteAutenticadorDTO() {
        return clienteAutenticadorDTO;
    }

    public void setClienteAutenticadorDTO(ClienteAutenticadorDTO clienteAutenticadorDTO) {
        this.clienteAutenticadorDTO = clienteAutenticadorDTO;
    }

    public void setEnderecoDTO(EnderecoDTO enderecoDTO) {
        this.enderecoDTO = enderecoDTO;
    }
}

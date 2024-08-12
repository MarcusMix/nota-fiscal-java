package com.example.teste.dto;

public class ProdutoDTO {
    private Long id;
    private String nome;
    private Float preco;
    private CategoriaDTO categoriaDTO;

    public ProdutoDTO() {
    }
    public ProdutoDTO(Long id, String nome, Float preco, CategoriaDTO categoriaDTO) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.categoriaDTO = categoriaDTO;
    }
    public CategoriaDTO getCategoriaDTO() {
        return categoriaDTO;
    }
    public void setCategoriaDTO(CategoriaDTO categoriaDTO) {
        this.categoriaDTO = categoriaDTO;
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
    public Float getPreco() {
        return preco;
    }
    public void setPreco(Float preco) {
        this.preco = preco;
    }

    
}

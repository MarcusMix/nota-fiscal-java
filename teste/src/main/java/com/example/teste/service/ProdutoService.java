package com.example.teste.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.teste.dto.ProdutoDTO;
import com.example.teste.entities.Produto;
import com.example.teste.repository.ProdutoRepository;
import com.example.teste.util.ProdutoMapper;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ProdutoService {
    
    @Autowired
    private ProdutoRepository produtoRepository;

    public ProdutoDTO criarProduto(ProdutoDTO produtoDTO) {
        Produto produto = ProdutoMapper.toProduto((produtoDTO));
        ProdutoDTO produtoNovo =ProdutoMapper.toProdutoDTO(produtoRepository.save(produto));
        return produtoNovo;
    }    

    public List<Produto> obterTodosProdutos() {
        return produtoRepository.findAll();
    }

    public Produto obterProdutoPorId(Long id) {
        Optional<Produto> produto = produtoRepository.findById(id);

        if (!produto.isPresent()) {
            throw new EntityNotFoundException("Produto com id " + id + " não encontrado");
        }
        return produto.get();
    }

    public Produto atualizarProduto(Produto produto) {
        Produto produtoSalvo = obterProdutoPorId(produto.getId());
        
        Optional<Produto> produtoExistente = produtoRepository.findById(produtoSalvo.getId());
        if (produtoExistente.isEmpty()) {
            return null;
        }

        Produto p = produtoExistente.get();
        p.setNome(produto.getNome());
        p.setPreco(produto.getPreco());
        p.setCategoria(produto.getCategoria());
        return produtoRepository.save(p);
    }

    public boolean deletarProduto(Long id) {
        Optional<Produto> produtoExistente = produtoRepository.findById(id);
        if (produtoExistente.isEmpty()) {
            return false;
        } 

        produtoRepository.deleteById(id);
        return true;
    }
}

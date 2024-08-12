package com.example.teste.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.teste.dto.ProdutoDTO;
import com.example.teste.service.ProdutoService;
import com.example.teste.util.ProdutoMapper;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    
    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public ProdutoDTO criarProduto(@RequestBody ProdutoDTO produtoDTO) {
        return produtoService.criarProduto(produtoDTO);
    }

    @GetMapping
    public List<ProdutoDTO> obterTodosProdutos() {
        return produtoService.obterTodosProdutos().stream().map(ProdutoMapper::toProdutoDTO).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoDTO> obterProdutoPorId(@PathVariable Long id) {
        return ResponseEntity.ok(ProdutoMapper.toProdutoDTO(produtoService.obterProdutoPorId(id)));
    }

    @PutMapping
    public ResponseEntity<ProdutoDTO> atualizarProduto(@RequestBody ProdutoDTO produtoDTO) {
        return ResponseEntity.ok(ProdutoMapper.toProdutoDTO(produtoService.atualizarProduto(ProdutoMapper.toProduto(produtoDTO))));
    }
}

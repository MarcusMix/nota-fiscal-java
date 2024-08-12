package com.example.teste.util;

import java.util.List;
import java.util.stream.Collectors;

import com.example.teste.dto.ProdutoDTO;
import com.example.teste.entities.Produto;

public class ProdutoMapper {
    public static Produto toProduto(ProdutoDTO produtoDTO) {
        return new Produto(produtoDTO.getId(), produtoDTO.getNome(), produtoDTO.getPreco(),
                CategoriaMapper.toCategoria(produtoDTO.getCategoriaDTO()));
    }

    public static ProdutoDTO toProdutoDTO(Produto produto) {
        return new ProdutoDTO(produto.getId(), produto.getNome(), produto.getPreco(),
                CategoriaMapper.toCategoriaDTO(produto.getCategoria()));
    }

    public static List<ProdutoDTO> toProdutoDTOList(List<Produto> produtos) {
        return produtos.stream().map(produto -> toProdutoDTO(produto)).collect(Collectors.toList());
    }

    public static List<Produto> toProdutoList(List<ProdutoDTO> produtosDTO) {
        return produtosDTO.stream().map(produtoDTO -> toProduto(produtoDTO)).collect(Collectors.toList());
    }
}

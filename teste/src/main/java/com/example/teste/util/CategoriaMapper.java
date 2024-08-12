package com.example.teste.util;

import com.example.teste.dto.CategoriaDTO;
import com.example.teste.entities.Categoria;

public abstract class CategoriaMapper {
        public static CategoriaDTO toCategoriaDTO(Categoria categoria) {
        return new CategoriaDTO(categoria.getId(), categoria.getNome(), categoria.getDescricao());
    }

    public static Categoria toCategoria(CategoriaDTO categoriaDTO) {
        if (categoriaDTO == null) {
            throw new IllegalArgumentException("categoriaDTO não pode ser nulo");
        }
        return new Categoria(categoriaDTO.getId(), categoriaDTO.getNome(), categoriaDTO.getDescricao());
    }
}

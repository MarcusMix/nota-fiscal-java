package com.example.teste.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.teste.entities.Categoria;
import com.example.teste.repository.CategoriaRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CategoriaService {
    
    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria criarCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public List<Categoria> obterTodasCategorias() {
        return categoriaRepository.findAll();
    }

    public Categoria obterCategoriaPorId(Long id) {

    Optional<Categoria> categoria = categoriaRepository.findById(id);

    if (categoria.isPresent()) {
        return categoria.get();
    }
    throw new EntityNotFoundException("Categoria com id " + id + " não encontrado");
    }

    public Categoria atualizarCategoria(Categoria categoria) {
        Categoria categoriaSalva = obterCategoriaPorId(categoria.getId());
        BeanUtils.copyProperties(categoria, categoriaSalva);
        return categoriaRepository.save(categoria);
    }

    public void deletarCategoria(Long id) {
        obterCategoriaPorId(id);
        categoriaRepository.deleteById(id);
    }
}

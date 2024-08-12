package com.example.teste.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.teste.dto.CategoriaDTO;
import com.example.teste.service.CategoriaService;
import com.example.teste.util.CategoriaMapper;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
    
    @Autowired
    private CategoriaService categoriaService;

    @PostMapping
    public ResponseEntity<CategoriaDTO> criarCategoria(@RequestBody CategoriaDTO categoriaDTO) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(CategoriaMapper.toCategoriaDTO(categoriaService.criarCategoria(CategoriaMapper.toCategoria(categoriaDTO))));
    }

    @GetMapping
    public ResponseEntity<List<CategoriaDTO>> obterTodasCategorias() {
        return ResponseEntity.ok(categoriaService.obterTodasCategorias().stream().map(CategoriaMapper::toCategoriaDTO).collect(Collectors.toList()));
    }


    @GetMapping("/{id}")
    public ResponseEntity<CategoriaDTO> procurarCategoriaPorId(@PathVariable Long id) {
        return ResponseEntity.ok(CategoriaMapper.toCategoriaDTO(categoriaService.obterCategoriaPorId(id)));
    }

    @PutMapping
    public ResponseEntity<CategoriaDTO> atualizarCategoria(@RequestBody CategoriaDTO categoriaDTO) {

        return ResponseEntity.ok(CategoriaMapper.toCategoriaDTO(categoriaService.atualizarCategoria(CategoriaMapper.toCategoria(categoriaDTO))));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCategoria(@PathVariable Long id) {
        categoriaService.deletarCategoria(id);
        return ResponseEntity.noContent().build();
    }
}

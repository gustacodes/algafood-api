package com.algaworks.algafood.api.controller;

import java.util.List;

import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.service.CadastroRestauranteServices;

@RestController
@RequestMapping("/restaurantes")
public class RestauranteController {

    @Autowired
    private CadastroRestauranteServices cadastroRestauranteServices;

    @PostMapping
    public ResponseEntity<?> adicionar(@RequestBody Restaurante restaurante) {

        try {
            restaurante = cadastroRestauranteServices.salvar(restaurante);

            return ResponseEntity.status(HttpStatus.CREATED).body(restaurante);

        } catch (EntidadeNaoEncontradaException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @GetMapping
    public List<Restaurante> listar() {
        return cadastroRestauranteServices.listar();
    }

    @GetMapping("/restaurante/{id}")
    public ResponseEntity<Restaurante> buscar(@PathVariable Long id) {
        Restaurante restaurante = cadastroRestauranteServices.buscar(id);

        if (restaurante != null) {
            return ResponseEntity.ok(restaurante);
        }

        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@PathVariable Long id, @RequestBody Restaurante restaurante) {

        try {

            Restaurante restauranteAtual = cadastroRestauranteServices.buscar(id);

            if(restauranteAtual != null) {

            restaurante = cadastroRestauranteServices.salvar(restaurante);

            return ResponseEntity.ok().body(restaurante);

            }

            return ResponseEntity.notFound().build();


        } catch (EntidadeNaoEncontradaException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}

package com.algaworks.algafood.api.controller;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.repository.CozinhaRepository;
import com.algaworks.algafood.domain.repository.RestauranteRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.*;

import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.service.CadastroRestauranteServices;

@RestController
@RequestMapping("/restaurantes")
public class RestauranteController {

    @Autowired
    private CadastroRestauranteServices cadastroRestauranteServices;

    @Autowired
    private CozinhaRepository cozinhaRepository;

    @Autowired
    private RestauranteRepository restauranteRepository;

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

    @GetMapping("/{id}")
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

            if (restauranteAtual != null) {
                restaurante = cadastroRestauranteServices.salvar(restaurante);
                return ResponseEntity.ok().body(restaurante);
            }

            return ResponseEntity.notFound().build();


        } catch (EntidadeNaoEncontradaException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> atualizaParcial(@PathVariable long id, @RequestBody Map<String, Object> campos) {

        Restaurante restauranteAtual = cadastroRestauranteServices.buscar(id);

        if (restauranteAtual == null) {
            return ResponseEntity.notFound().build();
        }

        merge(campos, restauranteAtual);

        return atualizar(id, restauranteAtual);
    }

    private void merge(Map<String, Object> dadosOrigem, Restaurante restauranteDestino) {

        ObjectMapper objectMapper = new ObjectMapper();
        Restaurante restauranteOrigem = objectMapper.convertValue(dadosOrigem, Restaurante.class);

        dadosOrigem.forEach((nomePropriedade, valorPropriedade) -> {

            Field field = ReflectionUtils.findField(Restaurante.class, nomePropriedade);
            field.setAccessible(true);

            Object novoValor = ReflectionUtils.getField(field, restauranteOrigem);

            //System.out.println(nomePropriedade + " = " + valorPropriedade + " = " + novoValor);
            ReflectionUtils.setField(field, restauranteDestino, novoValor);

        });
    }

}

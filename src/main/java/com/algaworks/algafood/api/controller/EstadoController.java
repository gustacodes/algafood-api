package com.algaworks.algafood.api.controller;

import java.util.List;
import java.util.Optional;

import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.model.Cidade;
import com.algaworks.algafood.domain.repository.CidadeRepository;
import com.algaworks.algafood.domain.service.CadastroEstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.algaworks.algafood.domain.model.Estado;
import com.algaworks.algafood.domain.repository.EstadoRepository;

@RestController
@RequestMapping("/estados")
public class EstadoController {

    @Autowired
    private CadastroEstadoService cadastroEstadoService;

    @Autowired
    private CidadeRepository cidadeRepository;

    @GetMapping
    public ResponseEntity<List<Estado>> listar() {
        List<Estado> estado = cadastroEstadoService.listar();
        return ResponseEntity.ok().body(estado);
    }

    @PostMapping
    ResponseEntity<Estado> salvar(@RequestBody Estado estado) {
        Estado es = cadastroEstadoService.salvar(estado);
        return ResponseEntity.status(HttpStatus.CREATED).body(es);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> remover(@PathVariable Long id) {

        try {

            Estado estado = cadastroEstadoService.buscar(id);
            Optional<Cidade> cidade = cidadeRepository.findById(estado.getId());

            if (cidade.get().getEstado().getId() != null) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body("Este estado tem um cidade");
            }

            if (estado != null) {
                cadastroEstadoService.excluir(estado);

                return ResponseEntity.noContent().build();
            }

        } catch (EntidadeNaoEncontradaException e) {

        }

        return ResponseEntity.notFound().build();
    }

}

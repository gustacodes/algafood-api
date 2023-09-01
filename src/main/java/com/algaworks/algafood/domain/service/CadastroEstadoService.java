package com.algaworks.algafood.domain.service;

import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.model.Estado;
import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CadastroEstadoService {

    @Autowired
    private EstadoRepository estadoRepository;

    public Estado salvar(Estado estado) {
        return estadoRepository.save(estado);
    }

    public List<Estado> listar() {
        return estadoRepository.findAll();
    }

    public Estado buscar(Long id) {
        return estadoRepository.findById(id).get();
    }

    public void excluir(Estado estado) {

        if (estado == null) {
            throw new EntidadeNaoEncontradaException("Estado não encontrado para exclusão");
        }

        estadoRepository.delete(estado);
    }
}

package com.algaworks.algafood.domain.repository;

import java.util.List;

import com.algaworks.algafood.domain.model.FormaPagamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormaPagamentoRepository extends JpaRepository<FormaPagamento, Long> {
    
}

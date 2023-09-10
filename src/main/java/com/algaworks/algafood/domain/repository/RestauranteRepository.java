package com.algaworks.algafood.domain.repository;

import java.math.BigDecimal;
import java.util.List;

import com.algaworks.algafood.domain.model.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

public interface RestauranteRepository extends JpaRepository<Restaurante, Long>, JpaSpecificationExecutor<Restaurante> {

    List<Restaurante> findByTaxaFreteBetween(BigDecimal taxaFreteInicial, BigDecimal taxaFreteFinal);
    //@Query("from Restaurante WHERE nome like %:nome% and cozinha.id = :id")
    List<Restaurante> consultarPorNome(String nome, Long id);
    List<Restaurante> find(String nome, BigDecimal taxaFreteInicial, BigDecimal taxaFreteFinal);
}

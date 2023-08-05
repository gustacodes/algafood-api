package com.algaworks.algafood.jpa;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.algaworks.algafood.Paris7ApiApplication;
import com.algaworks.algafood.domain.model.Cidade;
import com.algaworks.algafood.domain.repository.CidadeRepository;

public class ConsultaCidadeMain {
    public static void main(String[] args) {
        
        ApplicationContext applicationContext = new SpringApplicationBuilder(Paris7ApiApplication.class)
        .web(WebApplicationType.NONE)
        .run(args);

        CidadeRepository cidadeRepository = applicationContext.getBean(CidadeRepository.class);
        List<Cidade> cidade = cidadeRepository.listar();

        for(Cidade cidades : cidade) {
            System.out.println("A cidade de " + cidades.getNome() + " pertence ao estado de " + cidades.getEstado().getNome());
        }

    }
}

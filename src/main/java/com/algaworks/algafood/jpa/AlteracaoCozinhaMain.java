package com.algaworks.algafood.jpa;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.algaworks.algafood.Paris7ApiApplication;
import com.algaworks.algafood.domain.model.Cozinha;

public class AlteracaoCozinhaMain {
    public static void main(String[] args) {
        
        ApplicationContext applicationContext = new SpringApplicationBuilder(Paris7ApiApplication.class)
        .web(WebApplicationType.NONE)
        .run(args);

        CadastroCozinha cadastroCozinha = applicationContext.getBean(CadastroCozinha.class);

        Cozinha br = new Cozinha();
        br.setId(1L);
        br.setNome("Brasileira");

        cadastroCozinha.salvar(br);

    }
}

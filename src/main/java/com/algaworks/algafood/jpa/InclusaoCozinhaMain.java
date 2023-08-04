package com.algaworks.algafood.jpa;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.algaworks.algafood.Paris7ApiApplication;
import com.algaworks.algafood.domain.model.Cozinha;

public class InclusaoCozinhaMain {
    public static void main(String[] args) {
        
        ApplicationContext applicationContext = new SpringApplicationBuilder(Paris7ApiApplication.class)
        .web(WebApplicationType.NONE)
        .run(args);

        CadastroCozinha cadastroCozinha = applicationContext.getBean(CadastroCozinha.class);

        Cozinha br = new Cozinha();
        br.setNome("Brasileira");
        
        br = cadastroCozinha.adicionar(br);

        Cozinha jp = new Cozinha();
        jp.setNome("Japonesa");

        jp = cadastroCozinha.adicionar(jp);

        System.out.printf("%d - %s\n", br.getId(), br.getNome());
        System.out.printf("%d - %s\n", jp.getId(), jp.getNome());


    }
}

package com.restaurante.paris7api.jpa;

import com.restaurante.paris7api.Paris7ApiApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

public class Consulta {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new SpringApplicationBuilder(Paris7ApiApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);

        CadastroCozinha cadastroCozinha = applicationContext.getBean(CadastroCozinha.class);
    }
}

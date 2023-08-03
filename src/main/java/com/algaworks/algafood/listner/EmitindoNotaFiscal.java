package com.algaworks.algafood.listner;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.service.ClienteAtivadoEvent;

@Component
public class EmitindoNotaFiscal {

    @EventListener
    public void clienteAtivadoListener(ClienteAtivadoEvent event) {
        System.out.println("Emitindo nota fiscal para o cliente " + event.getCliente().getNome());
    }

    
}

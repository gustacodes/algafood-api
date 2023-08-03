package com.algaworks.algafood.listner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.notificador.NivelUrgencia;
import com.algaworks.algafood.notificador.Notificador;
import com.algaworks.algafood.notificador.TipoDoNotificador;
import com.algaworks.algafood.service.ClienteAtivadoEvent;

@Component
public class NotificacaoService {

    @Autowired
    @TipoDoNotificador(NivelUrgencia.URGENTE)
    private Notificador notificador;
    
    @EventListener
    public void clienteAtivadoListener(ClienteAtivadoEvent event) {
        notificador.notificar(event.getCliente(), "Seu cadastro no sistema está ativo");
    }
}

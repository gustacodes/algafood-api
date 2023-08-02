package com.algaworks.algafood.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.modelo.Cliente;
import com.algaworks.algafood.notificador.NivelUrgencia;
import com.algaworks.algafood.notificador.Notificador;
import com.algaworks.algafood.notificador.TipoDoNotificador;

@Component
public class AtivacaoClienteService {
    
    @TipoDoNotificador(NivelUrgencia.NORMAL)
    @Autowired
    private Notificador notificador;

    public void ativar(Cliente cliente) {
        cliente.ativar();

        notificador.notificar(cliente, "Seu cadastro no sistema está ativo");
       
    }
    
}
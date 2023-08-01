package com.algaworks.algafood.notificador;

import com.algaworks.algafood.modelo.Cliente;

public interface Notificador {
    
    void notificar(Cliente cliente, String mensagem);
    
}

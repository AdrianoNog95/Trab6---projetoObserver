package org.ProjetoObserver;

import java.util.Observable;
import java.util.Observer;

public class DispositivoClima implements Observer {

    private String nome;
    private String ultimaNotificacao;

    public DispositivoClima(String nome) {
        this.nome = nome;
    }

    public String getUltimaNotificacao() {
        return this.ultimaNotificacao;
    }

    public void registrar(EstacaoMeteorologica estacao) {
        estacao.addObserver(this);
    }

    @Override
    public void update(Observable estacao, Object arg) {
        this.ultimaNotificacao = this.nome + ", nova atualização de clima disponível: " + estacao.toString();

    }
}

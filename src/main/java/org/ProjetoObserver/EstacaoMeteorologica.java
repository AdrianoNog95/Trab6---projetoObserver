package org.ProjetoObserver;

import java.util.Observable;

public class EstacaoMeteorologica extends Observable {

    private float temperatura;
    private float umidade;

    public void atualizarMedicoes(float temperatura, float umidade) {
        this.temperatura = temperatura;
        this.umidade = umidade;
        setChanged();
        notifyObservers();
    }

    @Override
    public String toString() {
        return "EstacaoMeteorologica{" +
                "temperatura=" + temperatura +
                ", umidade=" + umidade +
                '}';
    }
}

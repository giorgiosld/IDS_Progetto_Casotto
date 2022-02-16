package it.unicam.cs.ids_progetto_casotto.model;

import java.util.List;

public class Cibo extends Consumazione{

    List<String> allergeni;

    public Cibo(String nome, double prezzo, int quantità, StatoConsumazione state, List<String> allergeni) {
        super(nome, prezzo, quantità, state);
        this.allergeni = allergeni;
    }

    public void getAllergeni(){
        for (String allergeniContenuti : allergeni) {
            System.out.print(allergeni);
        }
    }
}

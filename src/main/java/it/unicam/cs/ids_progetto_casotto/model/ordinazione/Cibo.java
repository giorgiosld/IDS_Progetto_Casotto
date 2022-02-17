package it.unicam.cs.ids_progetto_casotto.model.ordinazione;

import java.util.List;

/**
 * Classe che rappresenta un generico piatto che si trova nel men&ugrave;
 */
public class Cibo extends Consumazione{

    List<String> allergeni;

    public Cibo(String nome, double prezzo, List<String> allergeni) {
        super(nome, prezzo);
        this.allergeni = allergeni;
    }

    public void getAllergeni(){
        for (String allergeniContenuti : allergeni) {
            System.out.print(allergeni);
        }
    }
}

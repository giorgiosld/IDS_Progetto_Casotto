package it.unicam.cs.ids_progetto_casotto.model.ordinazione;

import javax.persistence.Entity;

/**
 * Classe che rappresenta un generica bibita che si trova nel men&ugrave;
 */
@Entity
public class Bibita extends Consumazione{

    private boolean aperitivo;

    /*public Bibita(String nome, double prezzo,  boolean aperitivo) {
        super(nome, prezzo);
        this.aperitivo = aperitivo;
    }*/

    public Bibita() {
        super();
    }


    /**
     * Controlla se si richiede l'aperitivo
     *
     * @return true se si vuole aperitivo altrimenti false
     */
    public boolean isAperitivo() {
        return aperitivo;
    }
}

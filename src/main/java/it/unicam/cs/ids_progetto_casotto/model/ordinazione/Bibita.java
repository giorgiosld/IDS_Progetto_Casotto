package it.unicam.cs.ids_progetto_casotto.model.ordinazione;

/**
 * Classe che rappresenta un generica bibita che si trova nel men&ugrave;
 */
public class Bibita extends Consumazione{

    private boolean aperitivo;

    public Bibita(String nome, double prezzo,  boolean aperitivo) {
        super(nome, prezzo);
        this.aperitivo = aperitivo;
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

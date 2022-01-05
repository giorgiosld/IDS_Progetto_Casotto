package it.unicam.cs.ids_progetto_casotto;

public class Bibita extends Consumazione{

    private boolean aperitivo;

    public Bibita(String nome, double prezzo, int quantità, StatoConsumazione state, boolean aperitivo) {
        super(nome, prezzo, quantità, state);
        this.aperitivo = aperitivo;
    }

    public boolean isAperitivo() {
        return aperitivo;
    }
}

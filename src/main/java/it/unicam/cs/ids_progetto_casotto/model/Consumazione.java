package it.unicam.cs.ids_progetto_casotto.model;

/**
 * Classe astratta rappresentante una generica consumazione
 */
public abstract class Consumazione {

    protected String nome;
    protected double prezzo;

    public Consumazione(String nome, double prezzo){
        this.nome = nome;
        this.prezzo = prezzo;
    }

    /**
     * Ritorna il nome della consumazione
     * @return nome consumazione
     */
    public String getNome(){
        return this.nome;
    }

    /**
     * Ritorna il costo del prodotto
     * @return costo consumazione
     */
    public double getPrezzo() {
        return this.prezzo;
    }

}

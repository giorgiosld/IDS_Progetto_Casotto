package it.unicam.cs.ids_progetto_casotto;

public abstract class Consumazione {

    protected String nome;
    protected double prezzo;
    protected int quantita;
    private StatoConsumazione state;

    public Consumazione(String nome, double prezzo, int quantita, StatoConsumazione state){
        this.nome = nome;
        this.prezzo = prezzo;
        this.quantita = quantita;
        this.state = state;
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

    /**
     * Ritorna la quantità di consumazione scelta
     * @return quantità
     */
    public int getQuantita() {
        return this.quantita;
    }

    //da cancellare metodo questo e quello sotto PENSARE SE UTILE O MENO
    protected void setStatoConsumazione(StatoConsumazione state){
        this.state = state;
    }

    protected StatoConsumazione getState(){
        return this.state;
    }
}

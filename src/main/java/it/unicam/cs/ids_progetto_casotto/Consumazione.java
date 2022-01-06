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

    public String getNome(){
        return this.nome;
    }

    public double getPrezzo() {
        return this.prezzo;
    }

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

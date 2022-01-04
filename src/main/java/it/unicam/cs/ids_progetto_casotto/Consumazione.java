package it.unicam.cs.ids_progetto_casotto;

public abstract class Consumazione {

    protected String nome;
    protected double prezzo;
    protected int quantità;
    private statoConsumazione state;

    public Consumazione(String nome, double prezzo, int quantità, statoConsumazione state){
        this.nome = nome;
        this.prezzo = prezzo;
        this.quantità = quantità;
        this.state = state;
    }

    public String getNome(){
        return nome;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public int getQuantità() {
        return quantità;
    }

    protected void setStatoConsumazione(statoConsumazione state){
        this.state = state;
    }

    protected statoConsumazione getState(){
        return state;
    }
}

package it.unicam.cs.ids_progetto_casotto;

public abstract class Consumazione {

    protected String nome;
    protected double prezzo;
    protected int quantità;
    private StatoConsumazione state;

    public Consumazione(String nome, double prezzo, int quantità, StatoConsumazione state){
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

    //da cancellare metodo questo e quello sotto PENSARE SE UTILE O MENO
    protected void setStatoConsumazione(StatoConsumazione state){
        this.state = state;
    }

    protected StatoConsumazione getState(){
        return state;
    }
}

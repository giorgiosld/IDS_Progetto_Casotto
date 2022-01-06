package it.unicam.cs.ids_progetto_casotto;

import java.util.List;

public class Comanda {

    private static int id;
    private int idComanda;
    public List<Consumazione> consumazioni;
    public double prezzoTotale;
    //chiedere per possibile creazione unico enum
    public StatoComanda state;
    //aggiungere data alla comanda

    //costruttore normale
    public Comanda(List<Consumazione> consumazioni, double prezzoTotale, StatoComanda state){
        this.idComanda = Comanda.id;
        Comanda.id++;
        this.consumazioni = consumazioni;
        this.prezzoTotale = prezzoTotale;
        this.state = state;
    }

    //possbilità di calcolare prezzo totale usando appunto getPrezzo totale
    public Comanda(List<Consumazione> consumazioni, StatoComanda state){
        this.idComanda = Comanda.id;
        Comanda.id++;
        this.consumazioni = consumazioni;
        this.state = state;
    }

    public int getIdComanda() {
        return this.idComanda;
    }

    //ottenere prezzo totale se già settato con il costruttore
    //22.23 aggiunta del controllo se creato o meno in base a come greendux stara di umore si sceglierà
    public double getPrezzoTotale() {
        if(Double.isNaN(this.prezzoTotale)){
            this.calcolaPrezzoTotale();
        }
        return this.prezzoTotale;
    }

    //calcolare prezzo totale
    public void calcolaPrezzoTotale(){
        this.prezzoTotale = this.consumazioni.stream()
                .mapToDouble(Consumazione::getPrezzo)
                .sum();
    }


    public StatoComanda getState() {
        return state;
    }

    public void setState(StatoComanda state){
        this.state = state;
    }

    public List<Consumazione> getConsumazioni() {
        return consumazioni;
    }

    @Override
    public String toString() {
        return "Comanda{" +
                "idComanda=" + id +
                ", consumazioni=" + consumazioni +
                ", prezzoTotale=" + prezzoTotale +
                ", state=" + state +
                '}';
    }
}

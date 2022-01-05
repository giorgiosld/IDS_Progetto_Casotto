package it.unicam.cs.ids_progetto_casotto;

import org.springframework.expression.spel.ast.NullLiteral;

import java.util.List;

public class Comanda {

    public int idComanda;
    public List<Consumazione> consumazioni;
    public double prezzoTotale;
    //chiedere per possibile creazione unico enum
    public StatoComanda state;
    //aggiungere data alla comanda

    //costruttore normale
    public Comanda(int idComanda, List<Consumazione> consumazioni, double prezzoTotale, StatoComanda state){
        this.idComanda = idComanda;
        this.consumazioni = consumazioni;
        this.prezzoTotale = prezzoTotale;
        this.state = state;
    }

    //possbilità di calcolare prezzo totale usando appunto getPrezzo totale
    public Comanda(int idComanda, List<Consumazione> consumazioni, StatoComanda state){
        this.idComanda = idComanda;
        this.consumazioni = consumazioni;
        this.state = state;
    }

    public int getIdComanda() {
        return idComanda;
    }

    //ottenere prezzo totale se già settato con il costruttore
    //22.23 aggiunta del controllo se creato o meno in base a come greendux stara di umore si sceglierà
    public double getPrezzoTotale() {
        if(this.prezzoTotale == Double.NaN){
            this.calcolaPrezzoTotale();
        }
        return prezzoTotale;
    }

    //calcolare prezzo totale
    public void calcolaPrezzoTotale(){
        double totale = this.consumazioni.stream()
                .mapToDouble(x -> x.getPrezzo())
                .sum();
        this.prezzoTotale = totale;
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
                "idComanda=" + idComanda +
                ", consumazioni=" + consumazioni +
                ", prezzoTotale=" + prezzoTotale +
                ", state=" + state +
                '}';
    }
}

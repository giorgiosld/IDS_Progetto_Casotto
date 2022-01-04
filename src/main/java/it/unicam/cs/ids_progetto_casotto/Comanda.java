package it.unicam.cs.ids_progetto_casotto;

import java.util.List;

public class Comanda {

    public int idComanda;
    public List<Consumazione> consumazioni;
    public double prezzoTotale;
    //chiedere per possibile creazione unico enum
    public StatoComanda state;

    public Comanda(int idComanda, List<Consumazione> consumazioni, double prezzoTotale, StatoComanda state){
        this.idComanda = idComanda;
        this.consumazioni = consumazioni;
        this.prezzoTotale = prezzoTotale;
        this.state = state;
    }

    public int getIdComanda() {
        return idComanda;
    }

    public double getPrezzoTotale() {
        return prezzoTotale;
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
}

package it.unicam.cs.ids_progetto_casotto.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * Classe che rappresenta una generica comanda contenuta all'interno del {@link it.unicam.cs.ids_progetto_casotto.controller.ControllerOrdinazione}
 */
public class Comanda {

    private static int id;
    private final int idComanda;
    public List<Consumazione> consumazioni;
    public double prezzoTotale;
    public StatoComanda statoComanda;
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    private final String orarioCreazione;

    /**
     * Crea la comanda
     *
     *
     * @param consumazioni la lista delle consumaizoni scelte
     * @param prezzoTotale prezzo totale della comanda
     * @param state stato in cui si trova la comanda
     */
    public Comanda(List<Consumazione> consumazioni, double prezzoTotale, StatoComanda state){
        this.idComanda = Comanda.id;
        Comanda.id++;
        this.consumazioni = consumazioni;
        this.prezzoTotale = prezzoTotale;
        this.statoComanda = state;
        this.orarioCreazione =  dtf.format(LocalDateTime.now());
    }

    /**
     * Crea la comanda senza saperne il prezzo totale
     *
     * @param consumazioni la lista delle consumaizoni scelte
     * @param state stato in cui si trova la comanda
     */
    public Comanda(List<Consumazione> consumazioni, StatoComanda state){
        this.idComanda = Comanda.id;
        Comanda.id++;
        this.consumazioni = consumazioni;
        this.statoComanda = state;
        this.orarioCreazione =  dtf.format(LocalDateTime.now());
    }

    /**
     * Ritorna l'id della comanda
     *
     * @return id della comanda
     */
    public int getId() {
        return this.idComanda;
    }

    /**
     * Ritorna la lista delle consumazioni presenti nella comanda
     *
     * @return lista consumazioni scelte dal cliente
     */
    public List<Consumazione> getConsumazioni() {
        return consumazioni;
    }

    /**
     * Se non presente chiama metodo per il calcolo del prezzo totale della comanda
     *
     * @return il prezzo totale della comanda
     */
    public double getPrezzoTotale() {
        if(Double.isNaN(this.prezzoTotale)){
            this.calcolaPrezzoTotale();
        }
        return this.prezzoTotale;
    }

    /**
     * Calcolo del prezzo totale della comanda
     */
    public void calcolaPrezzoTotale(){
        this.prezzoTotale = this.consumazioni.stream()
                .mapToDouble(Consumazione::getPrezzo)
                .sum();
    }

    /**
     * Ritorna lo stato della comanda
     *
     * @return stato comanda
     */
    public StatoComanda getStatoComanda() {
        return statoComanda;
    }

    /**
     * Imposta lo stato della comanda
     *
     * @param state stato da impostare
     */
    public void setStatoComanda(StatoComanda state){
        this.statoComanda = state;
    }


    /**
     * Ritorna l'orario in stringa di quando si è creata la comanda
     *
     * @return orario creazione comanda
     */
    public String getOrarioCreazione() {
        return orarioCreazione;
    }

    @Override
    public String toString() {
        return "Comanda{" +
                "idComanda=" + id +
                ", consumazioni=" + consumazioni +
                ", prezzoTotale=" + prezzoTotale +
                ", state=" + statoComanda +
                ", data creazione=" + orarioCreazione +
                '}';
    }
}

package it.unicam.cs.ids_progetto_casotto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Comanda {

    private static int id;
    private int idComanda;
    public List<Consumazione> consumazioni;
    public double prezzoTotale;
    public StatoComanda state;
    //formato data pensato in questa maniera da controllare il formato se corretto
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    private String creazioneComanda;

    /**
     * Crea la comanda
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
        this.state = state;
        this.creazioneComanda =  dtf.format(LocalDateTime.now());
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
        this.state = state;
        this.creazioneComanda =  dtf.format(LocalDateTime.now());
    }

    /**
     * Ritorna l'id della comanda
     *
     * @return
     */
    public int getIdComanda() {
        return this.idComanda;
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
    public StatoComanda getState() {
        return state;
    }

    /**
     * Imposta lo stato della comanda
     *
     * @param state stato da impostare
     */
    public void setState(StatoComanda state){
        this.state = state;
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
     * Ritorna l'orario in stringa di quando si è creata la comanda
     *
     * @return orario creazione comanda
     */
    public String getCreazioneComanda() {
        return creazioneComanda;
    }

    @Override
    public String toString() {
        return "Comanda{" +
                "idComanda=" + id +
                ", consumazioni=" + consumazioni +
                ", prezzoTotale=" + prezzoTotale +
                ", state=" + state +
                ", data creazione=" + creazioneComanda +
                '}';
    }
}

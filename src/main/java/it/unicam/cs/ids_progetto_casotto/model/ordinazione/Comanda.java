package it.unicam.cs.ids_progetto_casotto.model.ordinazione;

import it.unicam.cs.ids_progetto_casotto.controller.controller_ordinazione.ControllerOrdinazione;
import lombok.NonNull;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe che rappresenta una generica comanda contenuta all'interno del {@link ControllerOrdinazione}
 */
@Entity
public class Comanda {

    @Id
    @Column
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idComanda;
    @Column
    private double prezzoTotale;
    @Column
    @NonNull
    @OneToMany
    @JoinColumn
    private List<Consumazione> consumazioni;
    @Column
    @Enumerated(EnumType.STRING)
    private StatoComanda statoComanda;
    @Column
    private LocalDateTime orarioCreazione;


    public Comanda(){
        this.orarioCreazione = LocalDateTime.now();
        this.statoComanda = StatoComanda.CREATA;
        this.consumazioni = new ArrayList<>();
    }


    /**
     * Ritorna l'id della comanda
     *
     * @return id della comanda
     */
    public Integer getId() {
        return this.idComanda;
    }

    public void setConsumazioni(List<Consumazione> consumazioniToAdd){
        this.consumazioni.addAll(consumazioniToAdd);
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
        return this.prezzoTotale;
    }

    /**
     * Calcolo del prezzo totale della comanda
     */
    public void setPrezzoTotale(double prezzo){
        this.prezzoTotale = prezzo;
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


    @Override
    public String toString() {
        return "Comanda{" +
                "idComanda=" + idComanda +
                ", prezzoTotale=" + prezzoTotale +
                ", state=" + statoComanda +
                ", data creazione=" + orarioCreazione +
                '}';
    }
}

package it.unicam.cs.ids_progetto_casotto.model.ordinazione;

import com.fasterxml.jackson.annotation.JsonIgnore;
import it.unicam.cs.ids_progetto_casotto.controller.controller_ordinazione.ControllerOrdinazione;
import it.unicam.cs.ids_progetto_casotto.model.utenza.Utenza;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Classe che rappresenta una generica comanda contenuta all'interno del {@link ControllerOrdinazione}
 */
@Entity
@Getter
@Setter
@Table(name = "comanda")
public class Comanda {

    @Id
    @Column
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idComanda;

    @Column
    private double prezzoTotale;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.ALL})
    @JoinTable(
            name = "consumazioni_disponibile",
            joinColumns = @JoinColumn(name = "idComanda"),
            inverseJoinColumns = @JoinColumn(name = "id_")
    )
    private Set<Consumazione> consumazioni;

    @Column
    @Enumerated(EnumType.STRING)
    private StatoComanda statoComanda;

    @Column
    private LocalDateTime orarioCreazione;

    @ManyToOne(targetEntity = Utenza.class,
            cascade = CascadeType.ALL)
    @JoinColumn(name = "utenza_id", referencedColumnName = "id")
    private Utenza utenza;

    public Comanda(){
        this.orarioCreazione = LocalDateTime.now();
        this.statoComanda = StatoComanda.CREATA;
        this.consumazioni = new HashSet<>();
    }


    /**
     * Ritorna l'id della comanda
     *
     * @return id della comanda
     */
    public Integer getId() {
        return this.idComanda;
    }

    public void setConsumazioni(Set<Consumazione> consumazioniToAdd){
        this.consumazioni.addAll(consumazioniToAdd);
    }

    /**
     * Ritorna la lista delle consumazioni presenti nella comanda
     *
     * @return lista consumazioni scelte dal cliente
     */
    public Set<Consumazione> getConsumazioni() {
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

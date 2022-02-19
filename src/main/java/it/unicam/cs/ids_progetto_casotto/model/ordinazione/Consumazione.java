package it.unicam.cs.ids_progetto_casotto.model.ordinazione;

import org.springframework.jdbc.object.UpdatableSqlQuery;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.UUID;

/**
 * Classe astratta rappresentante una generica consumazione
 */
@Entity
@Table(name = "ArticoloBar")
public class Consumazione {

    @Id
    @Column(updatable = false)
    private UUID id;

    @NonNull
    @Column(unique = true)
    protected String nome;

    @Column(length = 500)
    protected double prezzo;

    /*public Consumazione(String nome, double prezzo){
        this.nome = nome;
        this.prezzo = prezzo;
    }*/
    public Consumazione(){
        this.id = UUID.randomUUID();
    }

    /**
     * Ritorna il nome della consumazione
     * @return nome consumazione
     */
    public String getNome(){
        return this.nome;
    }

    /**
     * Ritorna il costo del prodotto
     * @return costo consumazione
     */
    public double getPrezzo() {
        return this.prezzo;
    }

}

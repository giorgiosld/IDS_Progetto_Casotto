package it.unicam.cs.ids_progetto_casotto.model.utenza;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tariffa")
@Getter
@Setter
public class Tariffa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "fascia_oraria")
    private String fasciaOraria;

    @Column(name = "prezzo")
    private double prezzo;

    @Column(name = "numero_attivita")
    private int numeroAttivita;

    @JsonIgnore
    @OneToMany(mappedBy = "tariffa")
    private Set<PrenotazioneUtenza> prenotazioneUtenzaSet;

    public Tariffa() {
        this.prenotazioneUtenzaSet = new HashSet<>();
    }
}

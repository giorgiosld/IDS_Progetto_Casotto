package it.unicam.cs.ids_progetto_casotto.model.utenza;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "utenza")
public class Utenza {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "tipo")
    private String tipo;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE},
            mappedBy = "utenze")
    @JsonIgnore
    private Set<PeriodoDisponibilita> periodi;

    @OneToMany(mappedBy = "utenza")
    @JsonIgnore
    private Set<PrenotazioneUtenza> prenotazioneUtenzaSet;


    public Utenza() {
        this.periodi = new HashSet<>();
        this.prenotazioneUtenzaSet = new HashSet<>();
    }
}

package it.unicam.cs.ids_progetto_casotto.model.utenza;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "disponibilita")
public class PeriodoDisponibilita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "giorno")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate giorno;

    @Column
    private String fasciaOraria;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE})
    @JoinTable(
            name = "utenze_disponibili",
            joinColumns = @JoinColumn(name = "giorno"),
            inverseJoinColumns = @JoinColumn(name = "id_utenza")
    )
    private Set<Utenza> utenze;

    public PeriodoDisponibilita() {
        this.utenze = new HashSet<>();
    }

    public void addUtenza(Utenza utenza) {
        this.utenze.add(utenza);
    }

    public Utenza removeUtenza(int id) {
        Utenza removed = this.utenze.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
        this.utenze.remove(removed);
        return removed;
    }

    public void removeAllUtenze() {
        this.utenze.clear();
    }
}

package it.unicam.cs.ids_progetto_casotto.controller.controller_utenza;

import it.unicam.cs.ids_progetto_casotto.model.utenza.FasciaOraria;
import it.unicam.cs.ids_progetto_casotto.model.utenza.Utenza;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "periodo_utenze")
public class PeriodoUtenze {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column(name = "giorno")
    private LocalDate day;

    @Column(name = "fascia_oraria")
    private FasciaOrariaUtenze fasciaOrariaUtenze;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "booking",
            joinColumns = {
                    @JoinColumn(name = "periodo_id", referencedColumnName = "id",
                            nullable = false, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "utenze_id", referencedColumnName = "id",
                            nullable = false, updatable = false)})
    private Set<Utenza> utenze = new HashSet<>();

    public PeriodoUtenze() {}

    public Integer getId() {
        return this.id;
    }

    public LocalDate getDay() {
        return this.day;
    }

    public void setDay(LocalDate day) {
        this.day = day;
    }

    public FasciaOrariaUtenze getFasciaOrariaUtenze() {
        return this.fasciaOrariaUtenze;
    }

    public void setFasciaOrariaUtenze(FasciaOraria fasciaOraria) {
        this.fasciaOrariaUtenze = fasciaOrariaUtenze;
    }

    public Set<Utenza> getUtenze() {
        return this.utenze;
    }

    public void setUtenze(Set<Utenza> utenze) {
        this.utenze = utenze;
    }

    public void addUtenza(Utenza utenza) {
        this.utenze.add(utenza);
        utenza.getPeriodi().add(this);
    }

    public Utenza removeUtenza(Integer utenza) {
        Utenza removed = this.utenze.stream()
                .filter(t -> t.getId() == id).findFirst().orElse(null);
        this.utenze.remove(utenza);
        return removed;
    }
}

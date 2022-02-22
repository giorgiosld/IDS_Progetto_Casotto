package it.unicam.cs.ids_progetto_casotto.controller.controller_utenza;

import it.unicam.cs.ids_progetto_casotto.model.utenza.FasciaOraria;
import it.unicam.cs.ids_progetto_casotto.model.utenza.Utenza;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "booking",
            joinColumns = { @JoinColumn(name = "periodi_id") },
            inverseJoinColumns = { @JoinColumn(name = "utenze_id") })
    private List<Utenza> utenze = new ArrayList<>();

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

    public List<Utenza> getUtenze() {
        return this.utenze;
    }

    public void setUtenze(List<Utenza> utenze) {
        this.utenze = utenze;
    }

    public void addUtenza(Utenza utenza) {
        this.utenze.add(utenza);
        utenza.getPeriodi().add(this);
    }

    public Utenza removeUtenza(Integer utenza) {
        Utenza removed = this.utenze.get(utenza);
        this.utenze.remove(utenza);
        return removed;
    }
}

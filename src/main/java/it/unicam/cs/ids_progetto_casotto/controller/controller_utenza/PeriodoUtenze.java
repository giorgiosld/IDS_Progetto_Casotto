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
    @Column(updatable = false)
    private Integer id;

    @Column
    private LocalDate day;

    @Column
    private FasciaOrariaUtenze fasciaOrariaUtenze;

    @ManyToMany
    @JoinTable(
            name = "utenze_like",
            joinColumns = @JoinColumn(name = "periodo_id"),
            inverseJoinColumns = @JoinColumn(name = "utenza_id")
    )
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
    }

    public void removeUtenza(Utenza utenza) {
        this.utenze.remove(utenza);
    }
}

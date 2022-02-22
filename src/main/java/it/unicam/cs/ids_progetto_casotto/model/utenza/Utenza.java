package it.unicam.cs.ids_progetto_casotto.model.utenza;

import it.unicam.cs.ids_progetto_casotto.controller.controller_utenza.PeriodoUtenze;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Classe che definisce una generica
 * classe Utenza
 */
@Entity
@Table(name = "utenza")
public class Utenza {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "tipo")
    private Tipo tipo;

    @Column(name = "utenze")
    private int numeroPostiOccupabili;

    @ManyToMany(mappedBy = "utenze", fetch = FetchType.LAZY)
    private Set<PeriodoUtenze> periodi = new HashSet<>();

    public Utenza(){}

    /**
     * Metodo che ritorna l'id
     * dell'utenza
     *
     * @return id dell'utenza
     */
    public Integer getId(){
        return this.id;
    }

    public Tipo getTipo() { return this.tipo; }

    public void setTipo(Tipo tipo) { this.tipo = tipo; }

    public Set<PeriodoUtenze> getPeriodi() {
        return this.periodi;
    }

    /**
     * Metodo che ritorna il
     * numero di posti occupabili
     *
     * @return numero di posti
     * occupabili
     */
    public int getNumeroPostiOccupabili(){ return this.numeroPostiOccupabili; }

    public void setNumeroPostiOccupabili(int numeroPostiOccupabili) {
        this.numeroPostiOccupabili = numeroPostiOccupabili;
    }
}

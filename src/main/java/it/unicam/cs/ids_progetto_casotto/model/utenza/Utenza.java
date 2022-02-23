package it.unicam.cs.ids_progetto_casotto.model.utenza;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import it.unicam.cs.ids_progetto_casotto.controller.controller_utenza.PrenotazioneUtenzaCliente;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

/**
 * Classe che definisce una generica
 * classe Utenza
 */
@Entity
@Table(name = "utenza")
@Getter
@Setter
public class Utenza {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "tipo")
    private String tipo;


//    @Column
//    //@DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
//    @JsonFormat(pattern = "yyyy-MM-dd")
//    private LocalDate inizioPrenotazione;
//
//    @Column
//    //@DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
//    @JsonFormat(pattern = "yyyy-MM-dd")
//    private LocalDate finePrenotazione;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "utenza", cascade = CascadeType.ALL)
    private Set<PrenotazioneUtenzaCliente> listaPrenotazione;

    public Utenza(){
        this.listaPrenotazione = new HashSet<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
//    /**
//     * Metodo che ritorna l'id
//     * dell'utenza
//     *
//     * @return id dell'utenza
//     */
//    public Integer getId(){
//        return this.id;
//    }
//
//    public Tipo getTipo() { return this.tipo; }
//
//    public void setTipo(Tipo tipo) { this.tipo = tipo; }
//
//
//    /**
//     * Metodo che ritorna il
//     * numero di posti occupabili
//     *
//     * @return numero di posti
//     * occupabili
//     */
//    public int getNumeroPostiOccupabili(){ return this.numeroPostiOccupabili; }
//
//    public void setNumeroPostiOccupabili(int numeroPostiOccupabili) {
//        this.numeroPostiOccupabili = numeroPostiOccupabili;
//    }
}

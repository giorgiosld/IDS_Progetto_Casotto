package it.unicam.cs.ids_progetto_casotto.model.attivita;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.*;

/**
 * Classe che rappresenta le
 * attivit&agrave; presenti
 * nel sistema
 */

@Entity
@Getter
@Setter
@Table(name="event")
@JsonIgnoreProperties(value = {"prenotazione"}, allowSetters = true)
public class Event {

    @Id
    @Column
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @NonNull
    @Column(unique=true)
    private String nome;

   // private final String descrizione;
    @Column
    private int postiDisponibili;

    @Column
    private Integer numeroMassimoPosti;

    @Column
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime dataSvolgimento;

    @Column(length = 500)
    private  double prezzo;

    @LazyCollection(LazyCollectionOption.FALSE)
    @ManyToMany(targetEntity = Prenotazione.class, mappedBy = "eventiPrenotatiList")
    private Set<Prenotazione> prenotazione;

    public Event() {

    }

    public Integer getId(){
        return this.id;
}

    /**
     * Metodo che ritorna
     * il nome dell'attivit&agrave;
     *
     * @return nome attivit&agrave;
     */
    public String getNome() {
        return nome;
    }

    /**
     * Metodo che ritorna
     * la descrizione dell'attivit&agrave;
     *
     * @return descrizione dell'attivit&grave;
     */
  /*  public String getDescrizione() {
        return descrizione;
    }

   */

    /**
     * Metodo che ritorna
     * il numero di posti disponibili
     *
     * @return numero posti disponibili
     */
    public int getPostiDisponibili() {
        return postiDisponibili;
    }

    /**
     * Metodo che riduce di uno
     * i posti disponibili
     */
    public void riduciPostiDisponibili() {
        this.postiDisponibili--;
    }

    /**
     * Metodo che ritorna il numero
     * di posti massimo nell'attivit&agrave;
     *
     * @return numero di posti massimo
     */
    public Integer getNumeroMassimoPosti() {
//        if(numeroMassimoPosti.isEmpty()){
//            return Optional.empty();
//        }
        return numeroMassimoPosti;

    }

    /**
     * Metodo che ritorna la data
     * di svolgimento dell'attivit&agrave;
     *
     * @return data di svolgimento
     */
    public LocalDateTime getDataSvolgimento() {
        return this.dataSvolgimento;
    }

    /**
     * Metodo che modifica la data
     * di svolgimento dell'attivit&agrave;
     *
     * @param newData nuova data di svolgimento
     */
    public void setDataSvolgimento(LocalDateTime newData) {
        this.dataSvolgimento = newData;
    }

    /**
     * Metodo che ritorna il prezzo
     * dell'attivit&agrave;
     *
     * @return prezzo attivit&agrave;
     */
    public double getPrezzo() {
        return prezzo;
    }

    @Override
    public String toString() {
        return "Attivita{" +
                "nome='" + nome + '\'' +
              //  ", descrizione='" + descrizione + '\'' +
                ", postiDisponibili=" + postiDisponibili +
                ", numeroMassimoPosti=" + numeroMassimoPosti +
                ", dataSvolgimento='" + dataSvolgimento + '\'' +
                ", prezzo=" + prezzo +
                '}';
    }
}

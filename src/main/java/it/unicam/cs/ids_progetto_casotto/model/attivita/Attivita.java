package it.unicam.cs.ids_progetto_casotto.model.attivita;

import com.fasterxml.jackson.databind.JsonSerializer;
import lombok.NonNull;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.*;

/**
 * Classe che rappresenta le
 * attivit&agrave; presenti
 * nel sistema
 */

@Entity
@Table(name="Attivita")
public class Attivita {

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
    private String dataSvolgimento;
    @Column(length = 500)
    private  double prezzo;

    public Attivita() {
      /*  this.nome = nome;
        this.descrizione = descrizione;
        this.postiDisponibili = numeroMassimoPosti;
        this.numeroMassimoPosti = numeroMassimoPosti;
        this.dataSvolgimento = dataSvolgimento;
        this.prezzo = prezzo;
        */
        this.id=id;
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
    public LocalDate getDataSvolgimento() {
        LocalDate data = LocalDate.parse(this.dataSvolgimento);
        return data;
    }

    /**
     * Metodo che modifica la data
     * di svolgimento dell'attivit&agrave;
     *
     * @param newData nuova data di svolgimento
     */
    public void setDataSvolgimento(String newData) {
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

package it.unicam.cs.ids_progetto_casotto.model.attivita;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Classe che rappresenta le
 * attivit&agrave; presenti
 * nel sistema
 */
public class Attivita {

    private final String nome;
    private final String descrizione;
    private int postiDisponibili;
    private final int numeroMassimoPosti;
    private String dataSvolgimento;
    private final double prezzo;

    public Attivita(String nome, String descrizione, int numeroMassimoPosti, String dataSvolgimento, double prezzo) {
        this.nome = nome;
        this.descrizione = descrizione;
        this.postiDisponibili = numeroMassimoPosti;
        this.numeroMassimoPosti = numeroMassimoPosti;
        this.dataSvolgimento = dataSvolgimento;
        this.prezzo = prezzo;
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
    public String getDescrizione() {
        return descrizione;
    }

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
    public int getNumeroMassimoPosti() {
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
                ", descrizione='" + descrizione + '\'' +
                ", postiDisponibili=" + postiDisponibili +
                ", numeroMassimoPosti=" + numeroMassimoPosti +
                ", dataSvolgimento='" + dataSvolgimento + '\'' +
                ", prezzo=" + prezzo +
                '}';
    }
}

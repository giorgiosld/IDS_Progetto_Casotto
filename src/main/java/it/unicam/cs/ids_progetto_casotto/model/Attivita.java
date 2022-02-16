package it.unicam.cs.ids_progetto_casotto.model;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public class Attivita {

    private int idAttivita;
    private final String nome;
    private final int idTariffa;
    private int postiDisponibili;
    private String descrizione;
    private GregorianCalendar dataSvolgimento;
    private final List<String> clientiPrenotati;

    private static final int postiIllimatati = Integer.MAX_VALUE;

    public Attivita(int idAttivita, String nome, int idTariffa, int postiDisponibili, String descrizione, int year, int month, int day) {
        this.idAttivita = idAttivita;
        this.nome = nome;
        this.idTariffa = idTariffa;
        this.postiDisponibili = postiDisponibili;
        this.descrizione = descrizione;
        this.dataSvolgimento = new GregorianCalendar(year, month, day);
        this.clientiPrenotati = new ArrayList<>();
    }

    public Attivita(int idAttivita, String nome, int idTariffa, String descrizione, int year, int month, int day) {
        this.idAttivita = idAttivita;
        this.nome = nome;
        this.idTariffa = idTariffa;
        this.postiDisponibili = postiIllimatati;
        this.descrizione = descrizione;
        this.dataSvolgimento = new GregorianCalendar(year, month, day);
        this.clientiPrenotati = new ArrayList<>();
    }

    public int getIdAttivita() { return this.idAttivita; }

    public void setIdAttivita(int id) { this.idAttivita = id; }

    public String getNome() {
        return this.nome;
    }

    public int getIdTariffa() {
        return this.idTariffa;
    }

    public int getPostiDisponibili() {
        return this.postiDisponibili;
    }

    public void setPostiDisponibili(int postiDisponibili) {
        this.postiDisponibili = postiDisponibili;
    }

    public String getDescrizione() {
        return this.descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public GregorianCalendar getDataSvolgimento() {
        return this.dataSvolgimento;
    }

    public void setDataSvolgimento(int year, int month, int day) {
        this.dataSvolgimento = new GregorianCalendar(year, month, day);
    }

    public List<String> getClientiPrenotati() {
        return this.clientiPrenotati;
    }

    @Override
    public String toString() {
        return "Attivita{" +
                "idAttivita=" + idAttivita +
                ", nome='" + nome + '\'' +
                ", idTariffa=" + idTariffa +
                ", postiDisponibili=" + postiDisponibili +
                ", descrizione='" + descrizione + '\'' +
                ", dataSvolgimento=" + dataSvolgimento +
                '}';
    }
}

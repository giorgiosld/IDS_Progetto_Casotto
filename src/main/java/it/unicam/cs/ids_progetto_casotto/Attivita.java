package it.unicam.cs.ids_progetto_casotto;

import java.util.GregorianCalendar;

public class Attivita {

    private int idAttivita;
    private String nome;
    private int idTariffa;
    private int postiDisponibili;
    private String descrizione;
    private GregorianCalendar dataSvolgimento;

    public Attivita(int idAttivita, String nome, int idTariffa, int postiDisponibili, String descrizione, int year, int month, int day) {
        this.idAttivita = idAttivita;
        this.nome = nome;
        this.idTariffa = idTariffa;
        this.postiDisponibili = postiDisponibili;
        this.descrizione = descrizione;
        this.dataSvolgimento = new GregorianCalendar(year, month, day);
    }

    public int getIdAttivita() {
        return this.idAttivita;
    }

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

    public GregorianCalendar getDataSvolgimento() {
        return this.dataSvolgimento;
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

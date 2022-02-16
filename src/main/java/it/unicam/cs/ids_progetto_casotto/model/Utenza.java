package it.unicam.cs.ids_progetto_casotto.model;

public class Utenza {

    private int id;
    private boolean disponibilita;
    private Tariffa tariffa; //classe tariffa contenente attività,tempo,prezzo.
    private int postiOccupabili; //numero

    public Utenza(int id, boolean disponibilita, Tariffa tariffa, int postiOccupabili){
        this.id=id;
        this.disponibilita=disponibilita;
        this.tariffa=tariffa;
        this.postiOccupabili =postiOccupabili;

    }
    public int getId(){
        return this.id;
    }

    public boolean getDisponibilita(){
        return this.disponibilita;
    }

    public boolean setDisponibilita(boolean disponibilita){
       return this.disponibilita=disponibilita;
    }

    public int getPostiOccupabili(){

        return this.postiOccupabili;
    }
    public Tariffa getTariffa(){
        return this.tariffa;
    }

}
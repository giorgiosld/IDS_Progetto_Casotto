package it.unicam.cs.ids_progetto_casotto;

public class UtenzaSpiaggia {

    private int id;
    private boolean disponibilita;
    private double tariffa; //classe tariffa contenente attività,tempo,prezzo.
    private int postiOccupabili; //numero

    public UtenzaSpiaggia(int id, boolean disponibilita, double tariffa, int postiOccupabili){
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

}

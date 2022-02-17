package it.unicam.cs.ids_progetto_casotto.model;

/**
 * Classe che definisce una generica
 * classe Utenza
 */
public abstract class Utenza {

    private int id;
    private final int numeroPostiOccupabili;

    public Utenza(int id, int numeroPostiOccupabili){
        this.id=id;
        this.numeroPostiOccupabili = numeroPostiOccupabili;
    }

    /**
     * Metodo che ritorna l'id
     * dell'utenza
     *
     * @return id dell'utenza
     */
    public int getId(){
        return this.id;
    }

    /**
     * Metodo che ritorna il
     * numero di posti occupabili
     *
     * @return numero di posti
     * occupabili
     */
    public int getNumeroPostiOccupabili(){ return this.numeroPostiOccupabili; }
}

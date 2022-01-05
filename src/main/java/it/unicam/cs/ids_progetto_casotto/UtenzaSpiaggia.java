package it.unicam.cs.ids_progetto_casotto;

import java.util.List;

public class UtenzaSpiaggia {

    private int id;
    private boolean disponibilita;
    private double tariffa;
    private long postiDisponibili; //vedere se postidisponibili è inteso come numero o "oggetto"

    public UtenzaSpiaggia(int id, boolean disponibilita, double tariffa, long postiDisponibili){
        this.id=id;
        this.disponibilita=disponibilita;
        this.tariffa=tariffa;
        this.postiDisponibili=postiDisponibili;

    }
    public int getId(){
        return this.id;
    }

    public boolean getDisponibilità(){
        return this.disponibilita;
    }

    public boolean setDisponibilita(boolean disponibilita){
       return this.disponibilita=disponibilita;
    }

    public long getPostiDisponibili(List<UtenzaSpiaggia>Utenze ){

         long utenzeDisponibili = Utenze.stream()
                    .filter(u->u.getDisponibilità() == true)
                    .count();

        return utenzeDisponibili;
    }
    public String getSoni(

    )
}

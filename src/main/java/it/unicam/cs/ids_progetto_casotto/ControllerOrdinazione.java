package it.unicam.cs.ids_progetto_casotto;

import java.util.ArrayList;
import java.util.List;

public class ControllerOrdinazione {

    private List<Comanda> comande;

    public ControllerOrdinazione(){
        this.comande = new ArrayList<>();
    }

    public void creaComande(Comanda comanda){
        comande.add(comanda);
    }

    public List<Comanda> getComande(){
        return comande;
    }

    //notifica inviata in broadcast o a singolo staff memeber
    public void notificaStaff(Comanda comanda){

    }

    //modificare iniviaImporto piu che prezzo totale richiedere la comanda dal quale si vuole calcolare importo
    //sempluce utilizzo di get PrezzoTotale
    public double inviaImporto(Comanda comanda){
        return comanda.getPrezzoTotale();
    }
}

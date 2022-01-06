package it.unicam.cs.ids_progetto_casotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ControllerOrdinazione {

    private final List<Comanda> comande;
    private final List<Consumazione> consumazioni;

    public ControllerOrdinazione(){
        this.comande = new ArrayList<>();
        this.consumazioni = new ArrayList<>();
    }

    public Comanda creaComanda(Consumazione ... consumazione){
        if (consumazione == null) { throw new NullPointerException("Ci dispiace, c'è stato un errore nella selezione"); }
        List<Consumazione> consumaziones = new ArrayList<>();
        Collections.addAll(consumaziones, consumazione);
        double prezzoTot = consumaziones.stream()
                .mapToDouble(Consumazione::getPrezzo)
                .sum();
        return new Comanda(consumaziones, prezzoTot, StatoComanda.CREATA);
    }

    public List<Comanda> getComande(){
        return comande;
    }

    public List<Consumazione> getConsumazioni(String idUtenza) { return this.consumazioni; }

    //notifica inviata in broadcast
    public String notificaStaff(Comanda comanda){
        return comanda.toString();
    }

    //modificare iniviaImporto piu che prezzo totale richiedere la comanda dal quale si vuole calcolare importo
    //sempluce utilizzo di get PrezzoTotale
    public double inviaImportoComanda(Comanda comanda){
        return comanda.getPrezzoTotale();
    }

    public Comanda getLastComanda(){
        return comande.get(comande.size() - 1);
    }
}

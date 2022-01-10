package it.unicam.cs.ids_progetto_casotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ControllerOrdinazione {

    private final List<Comanda> comande;
    private final List<Consumazione> consumazioni;

    public ControllerOrdinazione(){
        this.comande = new ArrayList<>();
        this.consumazioni = new ArrayList<>();
    }

    /**
     * Creazione di una nuova comanda all'interno del controller
     *
     * @param consumazione le consumazioni scelte
     * @return la comanda creata con reltiva notifica della sua creazione
     */
    public Comanda creaComanda(Consumazione ... consumazione){
        if (consumazione == null) { throw new NullPointerException("Ci dispiace, c'è stato un errore nella selezione"); }
        List<Consumazione> consumaziones = new ArrayList<>();
        Collections.addAll(consumaziones, consumazione);
        //possibile calcolo errato se non si tiene conto della quantità
        double prezzoTot = consumaziones.stream()
                .mapToDouble(Consumazione::getPrezzo)
                .sum();
        Comanda nuovaComanda = new Comanda(consumaziones, prezzoTot, StatoComanda.CREATA);
        notificaStaff(nuovaComanda);
        return nuovaComanda;
    }

    /**
     * Ritorna la lista di comande all'interno del controller ordinazione
     *
     * @return le comande presenti nel controller
     */
    public List<Comanda> getComande(){
        return comande;
    }

    /**
     * Ritorna una lista di consumazioni. Utile per la visualizzazione del menù
     *
     * @return le consumazioni disponibili presenti nel menù
     */
    public List<Consumazione> getConsumazioni() { return consumazioni.stream().filter(z -> z.getNome()).collect(Collectors.toList()); }

    /**
     * Notifica ai vari componenti dello staff l'arrivo di una nuova comanda
     *
     * @param comanda la nuova comanda creata
     * @return la comanda creata
     */
    public String notificaStaff(Comanda comanda){
        return comanda.toString();
    }

    /**
     * Invia importo totale riguardante una comanda
     *
     * @param comanda
     * @return il totale della comanda
     */
    public double inviaImportoComanda(Comanda comanda){
        return comanda.getPrezzoTotale();
    }

    /**
     * Ritorna l'ultima comanda inserita all'interno del controller
     *
     * @return ultima comanda
     */
    public Comanda getLastComanda(){
        return comande.get(comande.size() - 1);
    }
}

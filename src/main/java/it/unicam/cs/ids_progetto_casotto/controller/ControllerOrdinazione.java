package it.unicam.cs.ids_progetto_casotto.controller;

import it.unicam.cs.ids_progetto_casotto.model.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Classe che implementa un controller per le ordinazioni. Si possono effettuare varie operazioni tutte ineresnti alla
 * classe comanda e consumazione.
 */
public class ControllerOrdinazione implements IControllerStaffOrdinazione, IControllerClienteOrdinazione {

    private final List<Comanda> comande;
    private final List<Consumazione> consumazioni;
    private  List<Barista> staffBar;

    public ControllerOrdinazione(){
        this.comande = new ArrayList<>();
        this.consumazioni = new ArrayList<>();
        //da controllare
        this.staffBar = new ArrayList<>();
    }


    @Override
    public List<Consumazione> getConsumazioni() {
        return this.consumazioni;
    }

    @Override
    public boolean creaComanda(List<Consumazione> consumazioni) {
        if (consumazioni == null) { throw new NullPointerException("Ci dispiace, c'è stato un errore nella selezione"); }
        double prezzoTot = consumazioni.stream()
                .mapToDouble(Consumazione::getPrezzo)
                .sum();
        Comanda nuovaComanda = new Comanda(consumazioni, prezzoTot, StatoComanda.CREATA);
        this.comande.add(nuovaComanda);
        Barista StaffToNotify = staffBar.stream().filter(x -> x.getStatoOccupazione().equals(StatoOccupazione.LIBERO)).findFirst().orElse(null);
        notificaComanda(StaffToNotify, nuovaComanda);
        return true;
    }

    @Override
    public Comanda notificaComanda(Barista barista, Comanda comanda) {
        barista.aggiungiComandaDaPreparare(comanda);
        return comanda;
    }

    @Override
    public Comanda getComanda(Comanda comanda) {
        return this.comande.stream().filter(x -> x.equals(comanda)).findFirst().orElse(null);
    }

    @Override
    public List<Comanda> getComande() {
        return this.comande;
    }

    @Override
    public StatoComanda getStatoComanda(Comanda comanda) {
        return Objects.requireNonNull(this.comande.stream().filter(x -> x.equals(comanda)).findFirst().orElse(null)).getStatoComanda();
    }

    @Override
    public void setStatoComanda(Comanda comanda, StatoComanda nuovoStato) {
        Objects.requireNonNull(this.comande.stream().filter(x -> x.equals(comanda)).findFirst().orElse(null)).setStatoComanda(nuovoStato);
    }


}

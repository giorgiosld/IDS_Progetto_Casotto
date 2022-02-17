package it.unicam.cs.ids_progetto_casotto.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe che rappresenta un Barista
 */
public class Barista extends StaffRistorazione{

    List<Comanda> comandeDaPreparare;

    public Barista(int id, String nome, String cognome, String dataNascita, char sesso, String email) {
        super(id, nome, cognome, dataNascita, sesso, email);
        this.comandeDaPreparare = new ArrayList<>();
    }

    /**
     * Metodo che permette di visualizzare le comande da preparare
     *
     * @return le comande da preparare
     */
    public List<Comanda> getComandeDaPreparare(){
        return this.comandeDaPreparare;
    }

    /**
     * Metodo che permette l'aggiunta della comanda da preparare in seguito alla creazione della comanda su {@link it.unicam.cs.ids_progetto_casotto.controller.ControllerOrdinazione}
     *
     * @param comanda la comanda che è stata notificata
     */
    public void aggiungiComandaDaPreparare(Comanda comanda){
        this.comandeDaPreparare.add(comanda);
    }

    /**
     * Metodo che quando chiamato pone la comanda in preparazione
     *
     * @param comanda
     */
    public void preparaComanda(Comanda comanda){
        comanda.setStatoComanda(StatoComanda.IN_PREPARAZIONE);
        this.setStatoOccupazione(StatoOccupazione.OCCUPATO);
    }

    /**
     * Metodo che notifica ad un cameriere che la comanda è pronta per essere consegnata
     *
     * @param comanda la comanda alla quale cambiare stato per essere pronta per la consegna
     * @param cameriere il cameriere che si dovrà occupare della consegna
     */
    public void notificaComandaPronta(Comanda comanda, Cameriere cameriere){
        comanda.setStatoComanda(StatoComanda.PRONTA);
        this.setStatoOccupazione(StatoOccupazione.LIBERO);
        cameriere.aggiungiComandaDaConsegnare(comanda);
    }
}


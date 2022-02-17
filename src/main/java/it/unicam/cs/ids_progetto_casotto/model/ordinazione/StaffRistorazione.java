package it.unicam.cs.ids_progetto_casotto.model.ordinazione;

import it.unicam.cs.ids_progetto_casotto.controller.controller_ordinazione.IControllerStaffOrdinazione;
import it.unicam.cs.ids_progetto_casotto.model.Persona;

import java.util.List;

/**
 * Classe astratta che rappresenta un membro dello staff ristorazione
 */
public abstract class StaffRistorazione extends Persona {

    private StatoOccupazione statoOccupazione;


    public StaffRistorazione(int id, String nome, String cognome, String dataNascita, char sesso, String email){
        super(id, nome, cognome, dataNascita, sesso, email);
        this.statoOccupazione = StatoOccupazione.LIBERO;
    }


    /**
     * Ritorna una comanda
     *
     * @param comanda la comanda che si vuole ottenere
     * @param bar controller contenente le varie ordinazioni
     * @return l'ordinazione cercata
     */
    public Comanda getComanda(IControllerStaffOrdinazione bar, Comanda comanda){
        return bar.getComanda(comanda);
    }

    /**
     * Ritorna tutte le ordinazioni presenti nel controller
     *
     * @param bar controller contenente le ordinazioni
     * @return una lista contenente le ordinazioni effettuatate
     */
    public List<Comanda> getComande(IControllerStaffOrdinazione bar){
        List<Comanda> comande = bar.getComande();
        return comande;
    }

    /**
     * Metodo che ritorna lo stato di preparazione di una comanda
     *
     * @param bar dove sono memorizzate le comande
     * @param comanda la comanda alla quale voglio vedere lo stato di preparazione
     * @return stato di preparazione della comanda
     */
    public StatoComanda getStatoComanda(IControllerStaffOrdinazione bar, Comanda comanda){
        return bar.getComanda(comanda).getStatoComanda();
    }

    /**
     * Metodo che imposta lo stato di una comanda
     *
     * @param bar dove le comande sono memorizzate
     * @param comanda la comanda da modificare
     * @param stato lo stato nel quale si vuole mettere la comanda
     */
    public void setStatoComanda(IControllerStaffOrdinazione bar, Comanda comanda, StatoComanda stato){
         bar.getComanda(comanda).setStatoComanda(stato);
    }

    public StatoOccupazione getStatoOccupazione() {
        return statoOccupazione;
    }

    public void setStatoOccupazione(StatoOccupazione statoOccupazione) {
        this.statoOccupazione = statoOccupazione;
    }
}

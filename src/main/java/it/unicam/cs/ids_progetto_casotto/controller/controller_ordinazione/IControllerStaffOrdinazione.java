package it.unicam.cs.ids_progetto_casotto.controller.controller_ordinazione;

import it.unicam.cs.ids_progetto_casotto.model.ordinazione.Comanda;
import it.unicam.cs.ids_progetto_casotto.model.ordinazione.StatoComanda;

import java.util.List;


/**
 * Interfaccia rappresentante le azioni che pu&ograve; eseguire per la comunicazione con
 * il {@link ControllerOrdinazione}
 */
public interface IControllerStaffOrdinazione {

    /**
     * Metodo che permette la visualizzazione di una comanda contenuta all'interno del {@link ControllerOrdinazione}
     *
     * @param id la comanda la quale si vuole visualizzare
     * @return la comanda cercata se presente all'interno del sistema
     */
    Comanda getComanda(Integer id);

    /**
     * Metodo che permette la visualizzazione di tutte le comande presenti all'interno del {@link ControllerOrdinazione}
     *
     * @return una lista contenente le comande presenti
     */
    List<Comanda> getComande();

    /**
     * Metodo che permette la visualizzazione dello {@link StatoComanda} di una determinata comanda presente all'interno del {@link ControllerOrdinazione}
     *
     * @param id la comanda la quale si vuole visualizzare lo stato
     * @return lo {@link StatoComanda} della comanda selezionata
     */
    StatoComanda getStatoComanda(Integer id);

    /**
     * Metodo che permette la modifica dello {@link StatoComanda} di una determinata comanda presente all'interno del {@link ControllerOrdinazione}
     *
     * @param id la comanda alla quale si vuole cambiare lo stato
     * @param nuovoStato lo stato da settare alla nuova comanda
     */
    StatoComanda setStatoComanda(Integer id, StatoComanda nuovoStato);
}

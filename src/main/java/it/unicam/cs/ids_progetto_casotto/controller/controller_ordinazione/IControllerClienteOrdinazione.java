package it.unicam.cs.ids_progetto_casotto.controller.controller_ordinazione;

import it.unicam.cs.ids_progetto_casotto.model.ordinazione.Comanda;
import it.unicam.cs.ids_progetto_casotto.model.ordinazione.Consumazione;

import java.util.List;

/**
 * Interfaccia rappresentante le azioni che pu&ograve; eseguire {@link it.unicam.cs.ids_progetto_casotto.model.Cliente} per la comunicazione con
 * il {@link ControllerOrdinazione}
 */
public interface IControllerClienteOrdinazione {

    /**
     * Metodo che permette la visualizzazione del men&ugrave;
     *
     * @return la lista delle consumazioni disponibili
     */
    List<Consumazione> getConsumazioni();

    /**
     * Metodo che permette la creazione di una {@link Comanda} all'interno del {@link ControllerOrdinazione}
     *
     * @param consumazioni la lista delle consumazioni selezionate
     * @oaram idUtenze l'identificativo dell'utenza alla quale portare la comanda
     * @return true se avviene la creazione e aggiunta della comanda
     */
    //Comanda creaComanda(List<Consumazione> consumazioni, int idUtenza);
    Comanda creaComanda(List<Consumazione> consumazioni);

}

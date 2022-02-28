package it.unicam.cs.ids_progetto_casotto.controller.controller_ordinazione;

import it.unicam.cs.ids_progetto_casotto.model.User;
import it.unicam.cs.ids_progetto_casotto.model.ordinazione.Comanda;
import it.unicam.cs.ids_progetto_casotto.model.ordinazione.Consumazione;

import javax.persistence.SecondaryTable;
import java.util.List;
import java.util.Set;

/**
 * Interfaccia rappresentante le azioni che pu&ograve; eseguire {@link User} per la comunicazione con
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
     * @param idUtenza l'identificativo dell'utenza alla quale portare la comanda
     * @return true se avviene la creazione e aggiunta della comanda
     */
    Comanda creaComanda(Set<Consumazione> consumazioni, Integer idUtenza);
}

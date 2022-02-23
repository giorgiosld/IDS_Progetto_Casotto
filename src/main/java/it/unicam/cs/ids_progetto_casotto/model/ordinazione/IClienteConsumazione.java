package it.unicam.cs.ids_progetto_casotto.model.ordinazione;

import it.unicam.cs.ids_progetto_casotto.controller.controller_ordinazione.IControllerClienteOrdinazione;
import it.unicam.cs.ids_progetto_casotto.model.User;

import java.util.List;

/**
 * Interfaccia che permette l'interazione tra {@link User} e {@link IControllerClienteOrdinazione}
 */
public interface IClienteConsumazione {

    /**
     * Metodo che permette la visualizzazione del menu da parte del cliente
     *
     * @param controllerOrdinazione il controller dalla quale si vuole visualizzare il men&ugrave;
     * @return la lista di consumazioni presenti nel controller
     */
    List<Consumazione> visulizzaMenu(IControllerClienteOrdinazione controllerOrdinazione);

    /**
     * Metodo che permette la selezione delle consumazioni il quale {@link User} vuole ordinare
     *
     * @param controllerOrdinazione il controller dalla quale si vuole ordinare
     * @param consumazioni la lista di consumazioni desiderate dal cliente
     */
    void selezionaConsumazioni(IControllerClienteOrdinazione controllerOrdinazione, List<Consumazione> consumazioni);
}

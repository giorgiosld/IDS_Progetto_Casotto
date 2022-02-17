package it.unicam.cs.ids_progetto_casotto.controller;

import it.unicam.cs.ids_progetto_casotto.model.Barista;
import it.unicam.cs.ids_progetto_casotto.model.Comanda;
import it.unicam.cs.ids_progetto_casotto.model.Consumazione;
import it.unicam.cs.ids_progetto_casotto.model.StaffRistorazione;

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
     * Metodo che permette la creazione di una {@link it.unicam.cs.ids_progetto_casotto.model.Comanda} all'interno del {@link ControllerOrdinazione}
     *
     * @param consumazioni la lista delle consumazioni selezionate
     * @return true se avviene la creazione e aggiunta della comanda
     */
    boolean creaComanda(List<Consumazione> consumazioni);

    /**
     * Metodo che notifica al barista che una nuova comanda &egrave; stata creata e inserita all'interno del {@link ControllerOrdinazione}
     *
     * @param barista il responsabile alla quale verr&agrave; notificata la creazione della comanda
     * @param comanda la comanda che &egrave; appena stata creata
     * @return la comanda creata e che deve essere notificata
     */
    Comanda notificaComanda(Barista barista, Comanda comanda);
}

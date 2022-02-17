package it.unicam.cs.ids_progetto_casotto.model.attivita;

import it.unicam.cs.ids_progetto_casotto.controller.controller_attivita.IControllerClienteAttivita;

import java.util.List;

/**
 * Interfaccia che permette al cliente di gestire le
 * varie attivit&agrave; proposte dal casotto
 */
public interface IClienteAttività {

    /**
     * Metodo che permette al cliente di visualizzare
     * le attivit&agrave;, proposte dal casotto,
     * tramite il {@link IControllerClienteAttivita}
     *
     * @param controllerAttivita controller che permette
     *                           di accedere alle attivit&agrave;
     * @return lista di attivit&agrave; visualizzate
     */
    List<Attivita> visualizzaAttivita(IControllerClienteAttivita controllerAttivita);

    /**
     * Metodo che permette al cliente di selezionare
     * un'attivit&agrave;
     *
     * @param controllerAttivita controller che permette
     *                           di accedere all'attivit&agrave;
     *                           selezionata
     * @param attivita attivit&agrave; da selezionare
     */
    Attivita selezionaAttivita(IControllerClienteAttivita controllerAttivita, Attivita attivita);

    /**
     * Metodo che permette al cliente di prenotare
     * un'attivit&agrave;
     *
     * @param controllerAttivita controller che permette
     *                           di accedere all'attivit&agrave;
     *                           selezionata
     * @param attivita attivit&agrave; da prenotare
     * @return true se l'attivit&agrave; risulta prenotata,
     * false altrimenti
     */
    boolean prenotaAttivita(IControllerClienteAttivita controllerAttivita, Attivita attivita);

    /**
     * Metodo che ritorna tutte le attivit&agrave;
     * prenotate dal cliente
     *
     * @return lista delle attivit&agrave; prenotate
     */
    List<Attivita> getAttivitaPrenotate();

    /**
     * Metodo che permette di selezionare un'attivit&agrave;
     * prenotata dal cliente
     *
     * @param attivita attivit&agrave; selezionata
     *                 dal cliente
     * @return l'attivit&agrave; selezionata
     */
    Attivita selezionaAttivitaPrenotata(Attivita attivita);

    /**
     * Metodo che permette di eliminare un'attivit&agrave;
     * prenotata dal cliente
     *
     * @param controllerAttivita controller che permette
     *                           di eliminare l'attivit&agrave;
     *                           selezionata
     * @param attivita attivit&agrave; prenotata da eliminare
     */
    void eliminaAttivitaPrenotata(IControllerClienteAttivita controllerAttivita, Attivita attivita);
}

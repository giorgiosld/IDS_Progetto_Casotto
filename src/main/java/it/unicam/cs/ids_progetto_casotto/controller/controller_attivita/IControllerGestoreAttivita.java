package it.unicam.cs.ids_progetto_casotto.controller.controller_attivita;

import it.unicam.cs.ids_progetto_casotto.model.attivita.Attivita;
import it.unicam.cs.ids_progetto_casotto.model.newsletter.IHandlerNewsletter;

/**
 * Interfaccia che definisce un generico controller
 * per le attivit&agrave; utilizzabile dal gestore
 * del casotto per gestire le attivit&agrave;
 */
public interface IControllerGestoreAttivita {

    /**
     * Metodo che permette di aggiungere un'
     * attivit&agrave; nel sistema
     *
     * @param attivita attivit&agrave; da
     *                 aggiungere
     * @return true se l'attivti&agrave; risulta
     * aggiunta correttamente, false altrimenti
     */
    boolean aggiungiAttivita(Attivita attivita);

    /**
     * Metodo che permette di eliminare un'
     * attivit&agrave; nel sistema
     *
     * @param attivita da eliminare
     * @return true se l'attivit&agrave; risulta
     * eliminata correttamente, false altrimenti
     */
    boolean eliminaAttivita(Attivita attivita);

    /**
     * Metodo che permette di rimandare le attivit&agrave;
     * ad una nuova data
     *
     * @param receptionist colui che dovr&agrave; avvisare
     *                     eventuali iscritti all'attivit&agrave;
     *                     della modifica della data di svolgimento
     * @param attivita attivit&agrave; da rimandare
     * @param nuovaData nuova data di svolgimento
     * @return true se l'attivit&agrave; risulta spostata correttamente,
     * false altrimenti
     */
    boolean rimandaAttivita(IHandlerNewsletter receptionist, Attivita attivita, String nuovaData);
}

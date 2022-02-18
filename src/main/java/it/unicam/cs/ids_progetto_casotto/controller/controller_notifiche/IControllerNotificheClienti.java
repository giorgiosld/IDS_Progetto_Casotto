package it.unicam.cs.ids_progetto_casotto.controller.controller_notifiche;

import it.unicam.cs.ids_progetto_casotto.model.Cliente;
import it.unicam.cs.ids_progetto_casotto.model.attivita.Attivita;
import it.unicam.cs.ids_progetto_casotto.model.newsletter.IHandlerNewsletter;
import it.unicam.cs.ids_progetto_casotto.model.newsletter.Oggetto;

import java.util.List;

/**
 * Interfaccia che definisce un controller,
 * {@link ControllerNotifiche}, per gestire
 * le notifiche da inviare ai clienti
 */
public interface IControllerNotificheClienti {

    /**
     * Metodo che ritorna i clienti
     * iscritti alla newsletter
     *
     * @return clienti iscritti alla newsletter
     */
    List<Cliente> getClientiIscrittiNewsletter();

    /**
     * Metodo che ritorna i clienti
     * iscritti al sistema
     *
     * @return clienti iscritti al sistema
     */
    List<Cliente> getClientiIscrittiSistema();

    /**
     * Metodo che permette di inviare
     * una notifica ai clienti
     *
     * @param receptionist &egrave; il mittente
     *                     del messaggio
     * @param oggetto del messaggio
     * @param body testo del messaggio
     * @return true se il messaggio risulta inviato
     * correttamente, false altrimenti
     */
    boolean notificaClienti(IHandlerNewsletter receptionist, Oggetto oggetto, String body);

    /**
     * Metodo che permette di inviare
     * un reminder di un'attivit&agrave;
     * giornaliera ai clienti iscritti a tale attivit&agrave;
     *
     * @param receptionist mittente del messaggio
     * @param attivita di cui fare il reminder
     * @return true se il messaggio risulta inviato
     * correttamente, false altrimenti
     */
    boolean notificaAttivita(IHandlerNewsletter receptionist, Attivita attivita);
}

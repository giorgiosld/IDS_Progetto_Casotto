package it.unicam.cs.ids_progetto_casotto.model.newsletter;

import it.unicam.cs.ids_progetto_casotto.controller.controller_notifiche.IControllerNotificheClienti;
import it.unicam.cs.ids_progetto_casotto.controller.controller_notifiche.ControllerNotifiche;
import it.unicam.cs.ids_progetto_casotto.model.Receptionist;

/**
 * Interfaccia che definisce le azioni,
 * eseguibili dal {@link Receptionist} per
 * gestire il {@link ControllerNotifiche}
 */
//TODO da sistemare la gestione dei messaggi
public interface IHandlerNewsletter {

    /**
     * Metodo che permette al
     * {@link Receptionist} di inviare dei messaggi
     * ai clienti iscritti alla newsletter
     *
     * @param newsletter controller che permette di
     *                   accedere ai clienti iscritti alla
     *                   newsletter per inviare i messaggi
     * @param oggetto oggetto del messaggio
     * @param body testo del messaggio
     * @return true se il messaggio risulta consegnato correttamente,
     * false altrimenti
     */
    boolean notificaCliente(IControllerNotificheClienti newsletter, String oggetto, String body);


    boolean notificaAttivita(IControllerNotificheClienti newsletter);
}

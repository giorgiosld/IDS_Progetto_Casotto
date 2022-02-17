package it.unicam.cs.ids_progetto_casotto.model;

import it.unicam.cs.ids_progetto_casotto.controller.controller_attivita.IControllerGestoreAttività;

/**
 * Interfaccia che definisce le azioni,
 * eseguibili dal gestore del casotto,
 * per gestire le attivit&agrave;
 */
public interface IHandlerAttività {

    /**
     * Metodo che permette al gestore
     * del casotto di aggiungere un'
     * attivit&agrave;
     *
     * @param controllerGestoreAttività controller che
     *                                  permette di aggiungere
     *                                  l'attivit&agrave;
     * @param nome dell'attivit&agrave; che si vuole aggiungere
     * @param descrizione dell'attivit&agrave; che si vuole aggiungere
     * @param numeroMassimoPosti indica quanti posti sono occupabili, se
     *                           fosse 0 l'attivit&agrave; non richiede un numero
     *                           massimo
     * @param dataSvolgimento indica la data di svolgimento dell'attivit&agrave;
     * @param prezzo dell'attivit&agrave;
     * @return true se l'attivit&agrave; risulta aggiunta correttamente,
     * false altrimenti
     */
    boolean aggiungiAttivita(IControllerGestoreAttività controllerGestoreAttività, String nome, String descrizione, int numeroMassimoPosti, String dataSvolgimento, double prezzo);

    /**
     * Metodo che permette al gestore
     * del casotto di eliminare un'
     * attivit&agrave;
     *
     * @param controllerGestoreAttività controller che
     *                                  permette di rimuovere
     *                                  l'attivit&agrave;
     * @param attivita da elimianare
     * @return true se l'attivit&agrave; risulta eliminate correttamente,
     * false altrimenti
     */
    boolean eliminaAttivita(IControllerGestoreAttività controllerGestoreAttività, Attivita attivita);

    /**
     * Metodo che permette al gestore
     * del casotto di rimandare un'
     * attivit&agrave; ad una nuova data
     *
     * @param controllerGestoreAttività controller che
     *                                  permette di rimandare
     *                                  l'attivit&agrave;
     * @param attivita da rimandare;
     * @param nuovaData indica la nuova data di svolgimento
     * @return true se l'attivit&agrave; risulta rimandata correttamente,
     * false altrimenti
     */
    boolean rimandaAttivita(IControllerGestoreAttività controllerGestoreAttività, Attivita attivita, String nuovaData);
}

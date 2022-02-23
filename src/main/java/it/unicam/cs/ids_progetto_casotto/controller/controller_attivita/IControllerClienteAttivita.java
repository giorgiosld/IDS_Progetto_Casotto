package it.unicam.cs.ids_progetto_casotto.controller.controller_attivita;

import it.unicam.cs.ids_progetto_casotto.model.attivita.Event;
import it.unicam.cs.ids_progetto_casotto.model.attivita.Prenotazione;

import java.util.List;

/**
 * Interfaccia che definisce un generico
 * controller per gestire le attivit&agrave;
 * che il cliente vuole prenotare
 */
public interface IControllerClienteAttivita {

    /**
     * Metodo che ritorna le attivit&agrave;
     * disponibili
     *
     * @return lista di attivit&agrave;
     */
    List<Event> getAttivita();

    /**
     * Metodo che ritorna una singola attività
     *
     * @param id l'id dell'attività
     * @return l'attività
     */
    Event getSingolaAttivita(Integer id);

    /**
     * Metodo che ritorna il numero di
     * posti disponibili per un'attivit&agrave;
     * in particolare
     *
     * @param attivita di cui si vuole sapere
     *                 il numero di posti
     *                 disponibili
     * @return numero di posti disponibili per
     * tale attivit&agrave;
     */
    Integer getPostiDisponibili(Integer id);

    /**
     * Metodo che permette al cliente
     * di prenotare un'attivit&agrave; e
     * di avvisare il receptionist di tale
     * prenotazione
     *
     *
     * @param prenotazione@return true se la prenotazione avviene con successo, false altrimenti
     */
    Prenotazione creaPrenotazioneAttivitaCliente(Prenotazione prenotazione);


}

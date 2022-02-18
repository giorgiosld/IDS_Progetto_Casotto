package it.unicam.cs.ids_progetto_casotto.model.utenza;

import it.unicam.cs.ids_progetto_casotto.controller.controller_utenza.PrenotazioneUtenzaCliente;

import java.util.List;

/**
 * Interfaccia che gestisce metodi per la gestione delle prenotazioni dei clienti
 */
public interface IHandlerPrenotazioniUtenzeClienti {

    /**
     * metodo che restituisce una lista delle prenotazioni effettuate dai clienti
     *
     * @return una lista delle prenotazioni effettuate dai clienti
     */
    List<PrenotazioneUtenzaCliente> getPrenotazioniUtenzeClienti();

    /**
     * metodo che restituisce una prenotazione effettuata da un cliente
     *
     * @param idCliente id del cliente
     * @return lista delle prenotazioni effettuate dal cliente selezionato
     */
    List<PrenotazioneUtenzaCliente> getPrenotazioneCliente(int idCliente);

    /**
     * metodo che aggiunge una prenotazione effettuata dal cliente
     *
     * @param prenotazione da aggiungere
     * @return la prenotazione aggiunta
     */
    boolean aggiungiPrenotazioneUtenza(PrenotazioneUtenzaCliente prenotazione);

    /**
     * metodo che elimina una prenotazione
     *
     * @param prenotazione da eliminare
     * @return true o false se l'operazione ha avuto successo
     */
    boolean eliminaPrenotazioneUtenza(PrenotazioneUtenzaCliente prenotazione);
}

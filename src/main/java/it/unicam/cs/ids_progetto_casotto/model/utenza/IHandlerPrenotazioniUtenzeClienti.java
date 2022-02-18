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
    List<PrenotazioneUtenzaCliente> getPrenotazioniUtenzeCliente();

    /**
     * metodo che restituisce una prenotazione effettuata da un cliente
     *
     * @param idCliente
     * @return
     */
    List<PrenotazioneUtenzaCliente> getPrenotazioneCliente(int idCliente);

    /**
     * metodo che aggiunge una prenotazione effettuata dal cliente
     *
     * @param idUtenza l'identificativo dell'utenza
     * @param idCliente l'identificativo del cliente
     * @param tariffa la tariffa selezionata
     * @param permanenza il periodo di utilizzo dell'utenza da parte del cliente
     * @return la prenotazione aggiunta
     */
    PrenotazioneUtenzaCliente aggiungiPrenotazioneUtenza(int idUtenza, int idCliente, Tariffa tariffa, Periodo permanenza);

    /**
     * metodo che elimina un'utenza
     *
     * @param prenotazione
     * @return true o false se l'operazione ha avuto successo
     */
    boolean eliminaPrenotazioneUtenza(PrenotazioneUtenzaCliente prenotazione);
}

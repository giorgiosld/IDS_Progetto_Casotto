package it.unicam.cs.ids_progetto_casotto.controller.controller_utenza;

import it.unicam.cs.ids_progetto_casotto.model.utenza.Periodo;
import it.unicam.cs.ids_progetto_casotto.model.utenza.Tariffa;
import it.unicam.cs.ids_progetto_casotto.model.utenza.Utenza;

import java.time.LocalDate;

/**
 * Classe che rappresenta una prenotazione
 * del cliente che viene gestita da
 * {@link ControllerPeriodo} e {@link it.unicam.cs.ids_progetto_casotto.model.Receptionist}
 */
public class PrenotazioneUtenzaCliente {

    private final int idCliente;
    private final Periodo periodoPermanenza;
    private final Utenza utenza;
    private final Tariffa tariffa;
    private final String orarioPrenotazione;

    public PrenotazioneUtenzaCliente(int idCliente, Periodo periodoPermanenza, Utenza utenza, Tariffa tariffa, String orarioPrenotazione) {
        this.idCliente = idCliente;
        this.periodoPermanenza = periodoPermanenza;
        this.utenza = utenza;
        this.tariffa = tariffa;
        this.orarioPrenotazione = orarioPrenotazione;
    }

    /**
     * Metodo che ritorna
     * l'id del cliente prenotato
     *
     * @return id cliente
     */
    public int getIdCliente() {
        return idCliente;
    }

    /**
     * Metodo che ritorna
     * il periodo di permanenza
     * del cliente
     *
     * @return periodo permamenza
     */
    public Periodo getPeriodoPermanenza() {
        return periodoPermanenza;
    }

    /**
     * Metodo che ritorna
     * l'utenza prenotata
     *
     * @return utenza prenotata
     */
    public Utenza getUtenza() {
        return utenza;
    }

    /**
     * Metodo che ritorna
     * la tariffa selezionata
     *
     * @return tariffa selezionata
     */
    public Tariffa getTariffa() {
        return tariffa;
    }

    /**
     * Metodo che ritorna
     * l'orario in cui viene
     * effettuata la prenotazione
     *
     * @return orario prenotazione
     */
    public LocalDate getOrarioPrenotazione() {
        return LocalDate.parse(this.orarioPrenotazione);
    }
}

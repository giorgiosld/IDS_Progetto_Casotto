package it.unicam.cs.ids_progetto_casotto.model;

/**
 * Classe che rappresenta una prenotazione
 * effettuata dall'utente
 */
public class PrenotazioneUtenza {

    private final Periodo periodo;
    private final Utenza utenza;
    private final Tariffa tariffa;
    private final String orarioPrenotazione;

    public PrenotazioneUtenza(Periodo periodo, Utenza utenza, Tariffa tariffa, String orarioPrenotazione) {
        this.periodo = periodo;
        this.utenza = utenza;
        this.tariffa = tariffa;
        this.orarioPrenotazione = orarioPrenotazione;
    }

    /**
     * Metodo che ritorna il
     * periodo di permanenza
     *
     * @return periodo di permanenza
     */
    public Periodo getPeriodoPermamenza() {
        return this.periodo;
    }

    /**
     * Metodo che ritorna l'
     * utenza prenotata
     *
     * @return utenza prenotata
     */
    public Utenza getUtenza() {
        return this.utenza;
    }

    /**
     * Metodo che ritorna la
     * tariffa prenotata
     *
     * @return tariffa
     */
    public Tariffa getTariffa() {
        return this.tariffa;
    }

    /**
     * Metodo che ritorna l'
     * orario in cui viene  effettuata
     * la prenotazione
     *
     * @return orario della prenotazione
     */
    public String getOrarioPrenotazione() {
        return this.orarioPrenotazione;
    }
}

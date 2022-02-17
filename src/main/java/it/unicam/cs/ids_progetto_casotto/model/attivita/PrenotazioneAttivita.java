package it.unicam.cs.ids_progetto_casotto.model.attivita;


import it.unicam.cs.ids_progetto_casotto.controller.controller_attivita.ControllerAttivita;

/**
 * Classe che rappresenta una prenotazione
 * del cliente che viene gestita da
 * {@link ControllerAttivita} e {@link it.unicam.cs.ids_progetto_casotto.model.Receptionist}
 */
public class PrenotazioneAttivita {

    private final Attivita attivita;
    private final String orarioPrenotazione;

    public PrenotazioneAttivita(Attivita attivita, String orarioPrenotazione) {
        this.attivita = attivita;
        this.orarioPrenotazione = orarioPrenotazione;
    }

    /**
     * Metodo che ritorna l'
     * attivit&agrave; prenotata
     *
     * @return attivit&agrave; prenotata
     */
    public Attivita getAttivita() {
        return attivita;
    }

    /**
     * Metodo che ritorna l'
     * orario in cui &egrave; stata
     * prenotata l'attivit&agrave;
     *
     * @return orario prenotazione
     */
    public String getOrarioPrenotazione() {
        return orarioPrenotazione;
    }
}

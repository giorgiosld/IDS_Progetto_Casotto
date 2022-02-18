package it.unicam.cs.ids_progetto_casotto.model.attivita;


import it.unicam.cs.ids_progetto_casotto.controller.controller_attivita.ControllerAttivita;

import java.time.LocalDate;

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
    public LocalDate getOrarioPrenotazione() {
        return LocalDate.parse(this.orarioPrenotazione);
    }

    @Override
    public String toString() {
        return "PrenotazioneAttivita{" +
                "attivita=" + attivita +
                ", orarioPrenotazione='" + orarioPrenotazione + '\'' +
                '}';
    }
}

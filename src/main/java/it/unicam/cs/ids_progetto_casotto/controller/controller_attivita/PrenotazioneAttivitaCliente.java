package it.unicam.cs.ids_progetto_casotto.controller.controller_attivita;

import it.unicam.cs.ids_progetto_casotto.model.attivita.Attivita;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;


public class PrenotazioneAttivitaCliente {


    private final int idCliente;
    private final Attivita attivitaPrenotata;
    private final String orarioPrenotazione;

    public PrenotazioneAttivitaCliente(int idCliente, Attivita attivitaPrenotata, String orarioPrenotazione) {
        this.idCliente = idCliente;
        this.attivitaPrenotata = attivitaPrenotata;
        this.orarioPrenotazione = orarioPrenotazione;
    }

    /**
     * Metodo che ritorna
     * l'id del cliente che ha
     * prenotato
     *
     * @return id del cliente
     */
    public int getIdCliente() {
        return idCliente;
    }

    /**
     * Metodo che ritorna
     * l'attivit&agrave; prenotata
     *
     * @return attivit&agrave; prenotata
     */
    public Attivita getAttivitaPrenotata() {
        return attivitaPrenotata;
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

    @Override
    public String toString() {
        return "PrenotazioneAttivitaCliente{" +
                "idCliente=" + idCliente +
                ", attivitaPrenotata=" + attivitaPrenotata +
                ", orarioPrenotazione=" + orarioPrenotazione +
                '}';
    }
}

package it.unicam.cs.ids_progetto_casotto.model.attivita;


import it.unicam.cs.ids_progetto_casotto.model.attivita.Attivita;

import java.time.LocalDate;

public class PrenotazioneAttivitaCliente {

    //TODO inizializzare la variabile
    private static final int DATA_SCADENZA_CANCELLAZIONE = 0;

    private final int idCliente;
    private Attivita attivitaPrenotata;
    private LocalDate orarioPrenotazione;

    public PrenotazioneAttivitaCliente(int idCliente, Attivita attivitaPrenotata, String orarioPrenotazione) {
        this.idCliente = idCliente;
        this.attivitaPrenotata = attivitaPrenotata;
        this.orarioPrenotazione = LocalDate.parse(orarioPrenotazione);
    }
}

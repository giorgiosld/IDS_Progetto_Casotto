package it.unicam.cs.ids_progetto_casotto.controller.controller_attivita;

import it.unicam.cs.ids_progetto_casotto.model.Attivita;
import it.unicam.cs.ids_progetto_casotto.model.IHandlerPrenotazioniAttivitaClienti;
import it.unicam.cs.ids_progetto_casotto.model.PrenotazioneAttivita;
import it.unicam.cs.ids_progetto_casotto.model.PrenotazioneAttivitaCliente;

import java.util.List;

/**
 * Classe che rappresenta un gestore delle
 * attivit&agrave;
 */
public class ControllerAttivita implements IControllerClienteAttività {

    private final List<Attivita> attivita;

    public ControllerAttivita(List<Attivita> attivita) {
        this.attivita = attivita;
    }

    @Override
    public List<Attivita> getAttivita() {
        return this.attivita;
    }

    @Override
    public int getPostiDisponibili(Attivita attivita) {
        return attivita.getPostiDisponibili();
    }

    @Override
    public boolean inviaPrenotazioneCliente(IHandlerPrenotazioniAttivitaClienti receptionist, int idCliente, Attivita attivita) {
        //TODO implementare
        return false;
    }

    @Override
    public boolean eliminaPrenotazioneCliente(IHandlerPrenotazioniAttivitaClienti receptionist, PrenotazioneAttivitaCliente prenotazione) {
        //TODO implementare
        return false;
    }

    private boolean checkRimborso(PrenotazioneAttivita prenotazioneAttivita) {
        return false;
    }
}

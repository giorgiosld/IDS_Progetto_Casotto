package it.unicam.cs.ids_progetto_casotto.controller.controller_attivita;

import it.unicam.cs.ids_progetto_casotto.model.attivita.Attivita;
import it.unicam.cs.ids_progetto_casotto.model.attivita.IHandlerPrenotazioniAttivitaClienti;
import it.unicam.cs.ids_progetto_casotto.model.attivita.PrenotazioneAttivita;
import it.unicam.cs.ids_progetto_casotto.model.newsletter.IHandlerNewsletter;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Classe che rappresenta un gestore delle
 * attivit&agrave;
 */
public class ControllerAttivita implements IControllerClienteAttivita,IControllerGestoreAttivita {

    private final List<Attivita> attivita;

    public ControllerAttivita() {
        this.attivita = new ArrayList<>();
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
    public boolean creaPrenotazioneCliente(IHandlerPrenotazioniAttivitaClienti receptionist, int idCliente, Attivita attivita) {
        Timestamp t1 = Timestamp.from(Instant.now());
        String str = t1.toString();
        PrenotazioneAttivitaCliente prenotazioneAttivitaCliente = new PrenotazioneAttivitaCliente(idCliente, attivita, str);
        if (!receptionist.aggiungiPrenotazioneAttivita(prenotazioneAttivitaCliente)) {
            System.out.println("Prenotazione non effettuata!");
            return false;
        }
        System.out.println("Prenotazione effettuata!");
        return true;
    }

    @Override
    public boolean eliminaPrenotazioneCliente(IHandlerPrenotazioniAttivitaClienti receptionist, PrenotazioneAttivitaCliente prenotazione) {
        //TODO implementare
        return false;
    }

    private boolean checkRimborso(PrenotazioneAttivita prenotazioneAttivita) {
        return false;
    }

    @Override
    public boolean aggiungiAttivita(Attivita attivita) {
        if (this.getAttivita().contains(attivita)) {
            return false;
        }
        this.getAttivita().add(attivita);
        return true;
    }

    @Override
    public boolean eliminaAttivita(Attivita attivita) {
        if (!this.getAttivita().contains(attivita)) {
            return false;
        }
        this.getAttivita().remove(attivita);
        return true;
    }

    @Override
    public boolean rimandaAttivita(IHandlerNewsletter receptionist, Attivita attivita, String nuovaData) {
        if (!this.getAttivita().contains(attivita)) {
            return false;
        }
        Optional<Attivita> check = this.getAttivita().stream().filter(x -> x==attivita).findFirst();
        check.ifPresent(value -> value.setDataSvolgimento(nuovaData));
        //TODO sistemare notifica clienti con receptionist
        return false;
    }
}

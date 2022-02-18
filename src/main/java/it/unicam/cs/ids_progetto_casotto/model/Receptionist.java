package it.unicam.cs.ids_progetto_casotto.model;

import it.unicam.cs.ids_progetto_casotto.controller.controller_utenza.PrenotazioneUtenzaCliente;
import it.unicam.cs.ids_progetto_casotto.model.attivita.IHandlerPrenotazioniAttivitaClienti;
import it.unicam.cs.ids_progetto_casotto.controller.controller_attivita.PrenotazioneAttivitaCliente;
import it.unicam.cs.ids_progetto_casotto.model.utenza.IHandlerPrenotazioniUtenzeClienti;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Classe che rappresenta un receptionist
 * che deve gestire {@link PrenotazioneUtenzaCliente},
 * {@link PrenotazioneAttivitaCliente} e le
 * notifiche tramite {@link it.unicam.cs.ids_progetto_casotto.model.newsletter.IHandlerNewsletter}
 */
public class Receptionist extends Persona implements IHandlerPrenotazioniAttivitaClienti, IHandlerPrenotazioniUtenzeClienti {

    private final List<PrenotazioneUtenzaCliente> prenotazioniUtenzaClienti;
    private final List<PrenotazioneAttivitaCliente> prenotazioniAttivitaClienti;

    public Receptionist(int id, String nome, String cognome, String annoNascita, char sesso, String email) {
        super(id, nome, cognome, annoNascita, sesso, email);
        this.prenotazioniUtenzaClienti = new ArrayList<>();
        this.prenotazioniAttivitaClienti = new ArrayList<>();
    }

    @Override
    public List<PrenotazioneAttivitaCliente> getPrenotazioniAttivitaClienti() {
        return this.prenotazioniAttivitaClienti;
    }

    @Override
    public List<PrenotazioneAttivitaCliente> getPrenotazioniAttivitaCliente(int idCliente) {
        return this.getPrenotazioniAttivitaClienti().stream()
                .filter(x -> x.getIdCliente() == idCliente).collect(Collectors.toList());
    }

    @Override
    public boolean aggiungiPrenotazioneAttivita(PrenotazioneAttivitaCliente prenotazione) {
        if (this.getPrenotazioniAttivitaClienti().contains(prenotazione)) {
            return false;
        }
        this.getPrenotazioniAttivitaClienti().add(prenotazione);
        return true;
    }

    @Override
    public boolean eliminaPrenotazioneAttivita(PrenotazioneAttivitaCliente prenotazione) {
        if (!this.getPrenotazioniAttivitaClienti().contains(prenotazione)) {
            return false;
        }
        this.getPrenotazioniAttivitaClienti().remove(prenotazione);
        return true;
    }

    @Override
    public List<PrenotazioneUtenzaCliente> getPrenotazioniUtenzeClienti() {
        return this.prenotazioniUtenzaClienti;
    }

    @Override
    public List<PrenotazioneUtenzaCliente> getPrenotazioneCliente(int idCliente) {
        return this.getPrenotazioniUtenzeClienti().stream()
                .filter(x -> x.getIdCliente() == idCliente).collect(Collectors.toList());
    }

    @Override
    public boolean aggiungiPrenotazioneUtenza(PrenotazioneUtenzaCliente prenotazione) {
        if (this.getPrenotazioniUtenzeClienti().contains(prenotazione)) {
            return false;
        }
        this.getPrenotazioniUtenzeClienti().add(prenotazione);
        return true;
    }

    @Override
    public boolean eliminaPrenotazioneUtenza(PrenotazioneUtenzaCliente prenotazione) {
        if (!this.getPrenotazioniUtenzeClienti().contains(prenotazione)) {
            return false;
        }
        this.getPrenotazioniUtenzeClienti().remove(prenotazione);
        return false;
    }

    //TODO sistemare i metodi di IHandlerNewsletter
}

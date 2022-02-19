package it.unicam.cs.ids_progetto_casotto.model;

import it.unicam.cs.ids_progetto_casotto.controller.controller_attivita.IControllerClienteAttivita;
import it.unicam.cs.ids_progetto_casotto.controller.controller_utenza.IControllerClienteSpiaggia;
import it.unicam.cs.ids_progetto_casotto.model.attivita.Attivita;
import it.unicam.cs.ids_progetto_casotto.model.attivita.IClienteAttività;
import it.unicam.cs.ids_progetto_casotto.model.attivita.PrenotazioneAttivita;
import it.unicam.cs.ids_progetto_casotto.model.newsletter.Messaggio;
import it.unicam.cs.ids_progetto_casotto.model.utenza.*;

import javax.persistence.Entity;
import java.util.*;

/**
 * Classe che rappresenta un
 * generico cliente che utilizzer&agrave;
 * il sistema
 */
public class Cliente extends Persona implements IClienteUtenza, IClienteAttività {

    private final List<PrenotazioneUtenza> utenzePrenotate;
    private final List<PrenotazioneAttivita> attivitaPrenotate;
    private final List<Messaggio> listaMessaggi;

    public Cliente(int id, String nome, String cognome, String annoNascita, char sesso, String email) {
        super(id, nome, cognome, annoNascita, sesso, email);
        this.utenzePrenotate = new ArrayList<>();
        this.attivitaPrenotate = new ArrayList<>();
        this.listaMessaggi = new ArrayList<>();
    }

    /**
     * Metodo che ritorna la lista
     * dei messaggi che il cliente
     * riceve dal sistema
     *
     * @return lista messaggi ricevuti
     */
    public List<Messaggio> getListaMessaggi() {
        return this.listaMessaggi;
    }

    @Override
    public List<Utenza> visualizzaUtenze(IControllerClienteSpiaggia controllerSpiaggia, Periodo periodi) {
        return null;
    }

    @Override
    public List<Utenza> visualizzaUtenze(IControllerClienteSpiaggia controllerSpiaggia, Periodo periodo, FasciaOraria fasciaOraria) {
        return null;
    }

    @Override
    public boolean selezionaUtenzadaPrenotare(IControllerClienteSpiaggia controllerSpiaggia, Utenza utenza) {
        return false;
    }

    @Override
    public Tariffa selezionaTariffa(IControllerClienteSpiaggia controllerSpiaggia, Tariffa tariffa) {
        return null;
    }

    @Override
    public List<PrenotazioneUtenza> getPrenotazioniUtenze() {
        return null;
    }

    @Override
    public PrenotazioneUtenza selezionaPrenotazioneUtenza(PrenotazioneUtenza prenotazione) {
        return null;
    }

    @Override
    public void eliminaPrenotazioneUtenza(IControllerClienteSpiaggia controllerSpiaggia, PrenotazioneUtenza utenza) {

    }

    @Override
    public List<Attivita> visualizzaAttivita(IControllerClienteAttivita controllerAttivita) {
        return null;
    }

    @Override
    public Attivita selezionaAttivita(IControllerClienteAttivita controllerAttivita, Attivita attivita) {
        return null;
    }

    @Override
    public boolean prenotaAttivita(IControllerClienteAttivita controllerAttivita, Attivita attivita) {
        return false;
    }

    @Override
    public List<Attivita> getAttivitaPrenotate() {
        return null;
    }

    @Override
    public Attivita selezionaAttivitaPrenotata(Attivita attivita) {
        return null;
    }

    @Override
    public void eliminaAttivitaPrenotata(IControllerClienteAttivita controllerAttivita, Attivita attivita) {

    }
}

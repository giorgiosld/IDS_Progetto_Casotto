package it.unicam.cs.ids_progetto_casotto.model;

import it.unicam.cs.ids_progetto_casotto.controller.controller_utenza.ControllerSpiaggia;
import it.unicam.cs.ids_progetto_casotto.controller.controller_utenza.IControllerClienteSpiaggia;
import it.unicam.cs.ids_progetto_casotto.model.attivita.PrenotazioneAttivita;
import it.unicam.cs.ids_progetto_casotto.model.utenza.*;

import java.util.*;

/**
 * Classe che rappresenta un
 * generico cliente che utilizzer&agrave;
 * il sistema
 */
public class Cliente extends Persona implements IClienteUtenza {

    private final List<PrenotazioneUtenza> utenzePrenotate;
    private final List<PrenotazioneAttivita> attivitaPrenotata;

    public Cliente(int id, String nome, String cognome, String annoNascita, char sesso, String email) {
        super(id, nome, cognome, annoNascita, sesso, email);
        this.utenzePrenotate = new ArrayList<>();
        this.attivitaPrenotata = new ArrayList<>();
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
    public Tariffa selezionaTariffa(ControllerSpiaggia controllerSpiaggia, Tariffa tariffa) {
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
}

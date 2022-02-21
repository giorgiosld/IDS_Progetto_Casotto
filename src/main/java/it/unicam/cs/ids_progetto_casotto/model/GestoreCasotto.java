package it.unicam.cs.ids_progetto_casotto.model;

import it.unicam.cs.ids_progetto_casotto.controller.controller_attivita.IControllerGestoreAttivita;
import it.unicam.cs.ids_progetto_casotto.controller.controller_utenza.IControllerGestoreSpiaggia;
import it.unicam.cs.ids_progetto_casotto.model.attivita.Attivita;
import it.unicam.cs.ids_progetto_casotto.model.attivita.IHandlerAttivita;
import it.unicam.cs.ids_progetto_casotto.model.newsletter.IHandlerNewsletter;
import it.unicam.cs.ids_progetto_casotto.model.utenza.IHandlerUtenze;
import it.unicam.cs.ids_progetto_casotto.model.utenza.Utenza;

import java.util.List;

/**
 * Clsse che rappresenta un generico gestore
 * che permette di gestire le attivit&agrave;,
 * tramite {@link it.unicam.cs.ids_progetto_casotto.controller.controller_attivita.ControllerAttivita},
 * e le utenze, tramite {@link it.unicam.cs.ids_progetto_casotto.controller.controller_utenza.ControllerSpiaggia}
 */
public class GestoreCasotto extends Persona implements IHandlerAttivita, IHandlerUtenze {

    public GestoreCasotto(int id, String nome, String cognome, String annoNascita, char sesso, String email) {
        super(id, nome, cognome, annoNascita, sesso, email);
    }

    @Override
    public boolean aggiungiAttivita(IControllerGestoreAttivita controllerGestoreAttivita, String nome, String descrizione, int numeroMassimoPosti, String dataSvolgimento, double prezzo) {
        return controllerGestoreAttivita.aggiungiAttivita(new Attivita(nome,descrizione,numeroMassimoPosti,dataSvolgimento,prezzo));
    }

    @Override
    public boolean eliminaAttivita(IControllerGestoreAttivita controllerGestoreAttivita, Attivita attivita) {
        return controllerGestoreAttivita.eliminaAttivita(attivita);
    }

    @Override
    public Attivita rimandaAttivita(IControllerGestoreAttivita controllerGestoreAttivita, IHandlerNewsletter receptionist, Integer id, String nuovaData) {
        return controllerGestoreAttivita.rimandaAttivita(receptionist,id,nuovaData);
    }

    @Override
    public boolean aggiungiUtenza(IControllerGestoreSpiaggia controllerSpiaggia, int id, int numeroPostiOccupabili) {
        return false;
    }

    @Override
    public boolean eliminaUtenza(IControllerGestoreSpiaggia controllerSpiaggia, Utenza utenza) {
        return controllerSpiaggia.eliminaUtenza(utenza);
    }

    @Override
    public List<Utenza> getUtenze(IControllerGestoreSpiaggia controllerSpiaggia) {
        return controllerSpiaggia.getUtenze();
    }
}

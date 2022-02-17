package it.unicam.cs.ids_progetto_casotto.model;

import it.unicam.cs.ids_progetto_casotto.controller.controller_attivita.ControllerAttivita;
import it.unicam.cs.ids_progetto_casotto.controller.controller_ordinazione.ControllerOrdinazione;
import it.unicam.cs.ids_progetto_casotto.controller.controller_attivita.IControllerClienteAttività;
import it.unicam.cs.ids_progetto_casotto.controller.controller_utenza.ControllerSpiaggia;
import it.unicam.cs.ids_progetto_casotto.controller.controller_utenza.IControllerClienteSpiaggia;
import it.unicam.cs.ids_progetto_casotto.model.attivita.Attivita;
import it.unicam.cs.ids_progetto_casotto.model.attivita.PrenotazioneAttivita;
import it.unicam.cs.ids_progetto_casotto.model.ordinazione.Consumazione;
import it.unicam.cs.ids_progetto_casotto.model.utenza.*;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Optional;

public class Cliente extends Persona implements IClienteUtenza {

    private final List<PrenotazioneUtenza> utenzePrenotate;
    private final List<PrenotazioneAttivita> attivitaPrenotata;

    public Cliente(int id, String nome, String cognome, String annoNascita, char sesso, String email) {
        super(id, nome, cognome, annoNascita, sesso, email);
        this.utenzePrenotate = new ArrayList<>();
        this.attivitaPrenotata = new ArrayList<>();
    }

    /**
     * Metodo che permette di visualizzare le attivit&agrave;
     *
     * @param controller controller dal quale si possono visualizzare
     *                   le attivit&agrave;
     *
     * @return lista di attivit&agrave; visualizzate
     */
    public List<Attivita> visualizzaAttivita(IControllerClienteAttività controller) {
        return controller.getAttivita();
    }

    /**
     * Metodo che permette di prenotare un'attivit&agrave;
     *
     * @param controller controller dal quale si prenota
     *                   l'attivit&agrave;
     * @param nomeAttivita nome dell'attivit&agrave; da
     *                     prenotare
     *
     * @return un Optional di tipo attivit&agrave;
     * per indicare se &egrave; stata prenotata con successo
     * oppure no
     */
    public Optional<Attivita> prenotaAttivita(ControllerAttivita controller, String nomeAttivita) {
        Optional<Attivita> attivitaSelezionata = controller.prenotazioneAttivita(this.codiceFiscale, nomeAttivita);
        return attivitaSelezionata;
    }

    /**
     * Metodo per visualizzare i periodi di prenotazione delle
     * utenze
     *
     * @param controllerUtenze controller dal quale si pu&ograve;
     *                         visualizzare i periodi
     * @return lista di date disponibili
     */
    public List<GregorianCalendar> visualizzaPeriodo(ControllerUtenze controllerUtenze) {
        return controllerUtenze.getPeriodi();
    }

    /**
     * Metodo che permette di prenotare un'utenza da spiaggia
     *
     * @param controllerUtenze controller dal quale si pu&ograve; prenotare
     * @param idUtenza id dell'utenza che si vuole prenotare
     * @param idTariffa id della tariffa da scegliere per il pagamento
     *
     * @return un Optional di tipo UtenzaSpiaggia per indicare se la
     * prenotazione &egrave; avvenuta con successo
     */
    public Optional<Utenza> prenotaUntenza(ControllerUtenze controllerUtenze, int idUtenza, int idTariffa) {
        return controllerUtenze.prenotaUtenza(idUtenza, idTariffa);
    }

    /**
     * Metodo per visualizzare il men&ugrave;
     *
     * @param controllerOrdinazione controller dal quale si visualizza il men&ugrave;
     *
     * @return lista di consumazioni
     */
    public List<Consumazione> visualizzaMenu(ControllerOrdinazione controllerOrdinazione) {
        return controllerOrdinazione.getConsumazioni();
    }

    /**
     * Metodo che permette di ordinare le consumazioni
     *
     * @param controllerOrdinazione controller dal quale si pu&ograve;
     *                              ordinare
     * @param consumazioni consumazioni ordinate
     *
     * @return lista di consumazioni ordinate
     */
    public List<Consumazione> ordinazioneConsumazione(ControllerOrdinazione controllerOrdinazione, List<Consumazione> consumazioni) {
        boolean c = controllerOrdinazione.creaComanda(consumazioni);
        return consumazioni;
    }
    //TODO
    @Override
    public List<Utenza> visualizzaUtenze(IControllerClienteSpiaggia controller_spiaggia, Periodo periodi) {
        return null;
    }
    //TODO
    @Override
    public List<Utenza> visualizzaUtenze(IControllerClienteSpiaggia controller_spiaggia, Periodo periodi, FasciaOraria fascia_oraria) {
        return null;
    }

    @Override
    public boolean selezionaUtenzadaPrenotare(IControllerClienteSpiaggia controller_spiaggia, Utenza utenza) {

        return true;
    }

    @Override
    public int selezionaTariffa(ControllerSpiaggia controller_spiaggia, Tariffa tariffa) {
    controller_spiaggia.ge
    }

    @Override
    public List<PrenotazioneUtenza> getPrenotazioniUtenze() {
        return this.utenzePrenotate;
    }

    @Override
    public PrenotazioneUtenza selezionaUtenzaPrenotata(PrenotazioneUtenza prenotazione) {
        PrenotazioneUtenza utenzaSelezionata;
        utenzaSelezionata = this.utenzePrenotate.stream().filter(x->x.equals(prenotazione)).findFirst().get();
        return utenzaSelezionata;
    }

    @Override
    public void eliminaUtenzaPrenotata(IControllerClienteSpiaggia controller_spiaggia, Utenza utenza) {
        controller_spiaggia.


    }



}

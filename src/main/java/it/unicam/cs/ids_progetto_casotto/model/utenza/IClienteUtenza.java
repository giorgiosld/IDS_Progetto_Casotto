package it.unicam.cs.ids_progetto_casotto.model.utenza;

import it.unicam.cs.ids_progetto_casotto.controller.controller_utenza.ControllerSpiaggia;
import it.unicam.cs.ids_progetto_casotto.controller.controller_utenza.IControllerClienteSpiaggia;

import java.util.List;

/**
 *Interfaccia che definisce azioni che un utente puo&grave; effettuare per quanto riguarda le utenze.
 */
public interface IClienteUtenza {
    /**
     * metodo che permette di visualizzare le utenze disponibili del Casotto in un determinato periodo
     * @param controllerSpiaggia restituisce tutte le utenze del casotto
     * @param periodi il periodo selezionato dall'utente
     * @return la lista delle utenze disponibili
     */
    List<Utenza>visualizzaUtenze(IControllerClienteSpiaggia controllerSpiaggia, Periodo periodi);

    /**
     * Metodo che permette di visualizzare le
     * utenze in base al periodo e alla fascia oraria
     *
     * @param controllerSpiaggia controller che permette di accedere
     *                           alle utenze
     * @param periodo selezionato
     * @param fasciaOraria orari di interesse
     * @return lsita di utenze corrispondenti al periodo e alla
     * fascia oraria selezionati
     */
    List<Utenza> visualizzaUtenze(IControllerClienteSpiaggia controllerSpiaggia, Periodo periodo, FasciaOraria fasciaOraria);

    /**
     * metodo che permette di far selezionare un'utenza da prenotare al cliente
     *
     * @param controllerSpiaggia restituisce tutte le utenze del casotto
     * @param utenza l'utenza da selezionare
     * @return true o false se l'utenza è stata scelta o meno
     */
    boolean selezionaUtenzadaPrenotare(IControllerClienteSpiaggia controllerSpiaggia, Utenza utenza);

    /**
     * Metodo che permette di selezionare
     * la tariffa
     *
     * @param controllerSpiaggia controller che permette di accedere
     *                           alla tariffa
     * @param tariffa tariffa da selezionare
     * @return tariffa selezionata
     */
    Tariffa selezionaTariffa(ControllerSpiaggia controllerSpiaggia, Tariffa tariffa);

    /**
     * metodo che restituisce le utenze prenotate dal cliente
     * @return le utenze prenotate dall'utente
     */
    List<PrenotazioneUtenza> getPrenotazioniUtenze();

    /**
     * restituisce un'utenza selezionata dal cliente
     * @param utenza
     * @return un'utenza selezionata da un'utente
     */
    PrenotazioneUtenza selezionaPrenotazioneUtenza(PrenotazioneUtenza prenotazione);

    /**
     * metodo che permette al cliente di cancellare una prenotazione effettuata
     * @param controllerSpiaggia restituisce  le utenze prenotate del cliente
     * @param utenza l'utenza selezionata da cancellare
     */
    void eliminaPrenotazioneUtenza(IControllerClienteSpiaggia controllerSpiaggia, PrenotazioneUtenza utenza);


}


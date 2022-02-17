package it.unicam.cs.ids_progetto_casotto.model.utenza;

import it.unicam.cs.ids_progetto_casotto.controller.controller_utenza.IControllerClienteSpiaggia;

import java.util.List;

/**
 *Interfaccia che definisce azioni che un utente puo&grave; effettuare per quanto riguarda le utenze.
 */
public interface IClienteUtenza {
    /**
     * metodo che permette di visualizzare le utenze disponibili del Casotto in un determinato periodo
     * @param controller_spiaggia restituisce tutte le utenze del casotto
     * @param periodi il periodo selezionato dall'utente
     * @return la lista delle utenze disponibili
     */
    List<Utenza>visualizzaUtenze(IControllerClienteSpiaggia controller_spiaggia, Periodo periodi);

    /**
     *
     * @param controller_spiaggia
     * @param periodi
     * @param fascia_oraria
     * @return
     */
    List<Utenza> visualizzaUtenze(IControllerClienteSpiaggia controller_spiaggia, Periodo periodi, FasciaOraria fascia_oraria);

    /**
     * metodo che permette di far selezionare un'utenza da prenotare al cliente
     *
     * @param controller_spiaggia restituisce tutte le utenze del casotto
     * @param utenza l'utenza da selezionare
     * @return true o false se l'utenza è stata scelta o meno
     */
    boolean selezionaUtenzadaPrenotare(IControllerClienteSpiaggia controller_spiaggia, Utenza utenza);

    int selezionaTariffa(IControllerClienteSpiaggia controller_spiaggia, Tariffa tariffa);

    /**
     * metodo che restituisce le utenze prenotate dal cliente
     * @return le utenze prenotate dall'utente
     */
    List<Utenza> getPrenotazioniUtenze();

    /**
     * restituisce un'utenza selezionata dal cliente
     * @param utenza
     * @return un'utenza selezionata da un'utente
     */
    Utenza selezionaUtenzaPrenotata(Utenza utenza);

    /**
     * metodo che permette al cliente di cancellare una prenotazione effettuata
     * @param controller_spiaggia restituisce  le utenze prenotate del cliente
     * @param utenza l'utenza selezionata da cancellare
     */
    void eliminaUtenzaPrenotata(IControllerClienteSpiaggia controller_spiaggia, Utenza utenza);
}


package it.unicam.cs.ids_progetto_casotto.controller.controller_utenza;

import it.unicam.cs.ids_progetto_casotto.model.utenza.Utenza;

import java.util.List;

/**
 * Interfaccia che definisce dei metodi generici di un gestore Spiaggia
 */
public interface IControllerGestoreSpiaggia {

    /**
     * restituisce la lista delle utenze del Casotto
     *
     * @return la lisat delle utenze del Casotto
     */
    List<Utenza> getUtenze();

    /**
     * metodo che aggiunge un'utenza
     * @param utenza l'utenza da aggiungere
     * @return true o false se l'operazione ha avuto successo
     */
    boolean aggiungiUtenza(Utenza utenza);

    /**
     * metodo che elimina un'utenza
     * @param utenza l'utenza da eliminare
     * @return true o false se l'operazione ha avuto successo
     */
    boolean eliminaUtenza(Utenza utenza);
}

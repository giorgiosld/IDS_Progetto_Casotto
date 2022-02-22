package it.unicam.cs.ids_progetto_casotto.controller.controller_utente;

import it.unicam.cs.ids_progetto_casotto.model.Cliente;

import java.util.List;

public interface IControllerUtente {

    /**
     * Metodo che permette la visualizzazione dei clienti iscritti
     *
     * @return lista dei clienti iscritti
     */
    public List<Cliente> getClienti();

    /**
     * Metodo che permette la visualizzazione di un cliente iscritto
     *
     * @param id il cliente cercato
     * @return il cliente cercato
     */
    public Cliente getCliente(Integer id);

    /**
     * Metodo che permette l'aggiunta di un cliente nel sistema
     *
     * @param cliente il cliente che vuole registraziorsi
     * @return il cliente registrato
     */
    public Cliente addCliente(Cliente cliente);

    /**
     * Metodo che permette di rimuovere un cliente dal sistema
     *
     * @param id il cliente cercato
     * @return il cliente rimosso
     */
    public Cliente removeCliente(Integer id);

    /**
     * Metodo che permette la modifica di un cliente dal sistema
     *
     * @param id il cliente cercato
     * @return il cliente modificato
     */
    public Cliente updateCliente(Integer id, Cliente cliente);
}

package it.unicam.cs.ids_progetto_casotto.model;

/**
 * Interfaccia che definisce un generico
 * utente del sistema
 */
public interface IUtente {

    /**
     * Metodo che ritorna
     * l'identificativo dell'utente
     *
     * @return identificativo
     */
    int getId();

    /**
     * Metodo che ritorna il nome
     * dell'utente
     *
     * @return nome utente
     */
    String getNomeUtente();

    /**
     * Metodo che ritora il cognome
     * dell'utente
     *
     * @return cognome utente
     */
    String getCognomeUtente();

    /**
     * Metodo che ritorna l'anno
     * di nascita dell'utente
     *
     * @return anno di nascita
     */
    String getAnnoNascita();

    /**
     * Metodo che ritorna il sesso
     * dell'utente
     *
     * @return sesso utente
     */
    char getSesso();

    /**
     * Metodo che ritorna l'e-mail
     * dell'utente
     *
     * @return e-mail utente
     */
    String getEmail();
}

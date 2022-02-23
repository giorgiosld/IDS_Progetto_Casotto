package it.unicam.cs.ids_progetto_casotto.model.newsletter;

import it.unicam.cs.ids_progetto_casotto.model.User;

import java.util.List;

/**
 * Classe che definisce un messaggio della NewsLetter
 */
public class Messaggio {

     private final IHandlerNewsletter mittente;
     private final List<User> destinatario;
     private final Oggetto oggetto;
     private final String body;

    public Messaggio(IHandlerNewsletter mittente, List<User> destinatario, Oggetto oggetto, String body) {
        this.mittente = mittente;
        this.destinatario = destinatario;
        this.oggetto = oggetto;
        this.body = body;
    }

    public IHandlerNewsletter getMittente() {
        return mittente;
    }

    public List<User> getDestinatario() {
        return destinatario;
    }

    public Oggetto getOggetto() {
        return oggetto;
    }

    public String getBody() {
        return body;
    }
}

package it.unicam.cs.ids_progetto_casotto.model.newsletter;

import it.unicam.cs.ids_progetto_casotto.model.Cliente;

import java.util.List;

/**
 * Classe che definisce un messaggio della NewsLetter
 */
public class Messaggio {
    IHandlerNewsletter mittente;
     List<Cliente> destinatario;
     String oggetto;
     String body;

    public Messaggio(IHandlerNewsletter mittente, List<Cliente> destinatario, String oggetto, String body) {
        this.mittente = mittente;
        this.destinatario = destinatario;
        this.oggetto = oggetto;
        this.body = body;
    }

    public IHandlerNewsletter getMittente() {
        return mittente;
    }

    public List<Cliente> getDestinatario() {
        return destinatario;
    }

    public String getOggetto() {
        return oggetto;
    }

    public String getBody() {
        return body;
    }
}

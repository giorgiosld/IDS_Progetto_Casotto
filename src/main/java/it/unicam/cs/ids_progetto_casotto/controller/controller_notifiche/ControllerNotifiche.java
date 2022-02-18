package it.unicam.cs.ids_progetto_casotto.controller.controller_notifiche;

import it.unicam.cs.ids_progetto_casotto.model.Cliente;
import it.unicam.cs.ids_progetto_casotto.model.attivita.Attivita;
import it.unicam.cs.ids_progetto_casotto.model.newsletter.IHandlerNewsletter;
import it.unicam.cs.ids_progetto_casotto.model.newsletter.Messaggio;
import it.unicam.cs.ids_progetto_casotto.model.newsletter.Oggetto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Classe che rappresenta un controller
 * che permette al {@link it.unicam.cs.ids_progetto_casotto.model.Receptionist}
 * di notificare i clienti
 */
public class ControllerNotifiche implements IControllerNotificheClienti{

    private final List<Cliente> clientiIscrittiNewsletter;
    private final List<Cliente> clientiIscrittiSistema;

    public ControllerNotifiche() {
        this.clientiIscrittiNewsletter = new ArrayList<>();
        this.clientiIscrittiSistema = new ArrayList<>();
    }

    @Override
    public List<Cliente> getClientiIscrittiNewsletter() {
        return this.clientiIscrittiNewsletter;
    }

    @Override
    public List<Cliente> getClientiIscrittiSistema() {
        return this.clientiIscrittiSistema;
    }

    @Override
    public boolean notificaClienti(IHandlerNewsletter receptionist, Oggetto oggetto, String body) {
        if (oggetto == Oggetto.PROMO) {
            this.getClientiIscrittiNewsletter().forEach(x -> x.getListaMessaggi().add(new Messaggio(receptionist,this.getClientiIscrittiNewsletter(),oggetto,body)));
        }
        this.getClientiIscrittiSistema().forEach(x -> x.getListaMessaggi().add(new Messaggio(receptionist,this.getClientiIscrittiSistema(),oggetto,body)));
        return true;
    }

    @Override
    public boolean notificaAttivita(IHandlerNewsletter receptionist, Attivita attivita) {
        String body = "Ti ricordiamo che oggi si volgerà " + attivita.toString();
        List<Cliente> clientiDaNotificare = this.getClientiIscrittiSistema()
                .stream()
                .filter(x -> x.getAttivitaPrenotate().contains(attivita))
                .collect(Collectors.toList());
        clientiDaNotificare.forEach(x -> x.getListaMessaggi().add(new Messaggio(receptionist,clientiDaNotificare,Oggetto.ATTIVITA,body)));
        return true;
    }
}

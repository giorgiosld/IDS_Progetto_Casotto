package it.unicam.cs.ids_progetto_casotto.model;

import it.unicam.cs.ids_progetto_casotto.controller.controller_attivita.IControllerClienteAttivita;
import it.unicam.cs.ids_progetto_casotto.model.attivita.Attivita;
import it.unicam.cs.ids_progetto_casotto.model.attivita.IClienteAttività;
import it.unicam.cs.ids_progetto_casotto.model.attivita.PrenotazioneAttivita;
import it.unicam.cs.ids_progetto_casotto.model.newsletter.Messaggio;
import it.unicam.cs.ids_progetto_casotto.model.utenza.*;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Classe che rappresenta un
 * generico cliente che utilizzer&agrave;
 * il sistema
 */
@Entity
@Table(name = "Utente")
public class Cliente extends Persona {

    public Cliente(){
        super();
    }

    /**
     * Metodo che ritorna la lista
     * dei messaggi che il cliente
     * riceve dal sistema
     *
     * @return lista messaggi ricevuti
     */
//    public List<Messaggio> getListaMessaggi() {
//        return this.listaMessaggi;
//    }


}

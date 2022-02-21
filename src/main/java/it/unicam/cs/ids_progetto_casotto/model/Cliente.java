package it.unicam.cs.ids_progetto_casotto.model;

import it.unicam.cs.ids_progetto_casotto.controller.controller_attivita.IControllerClienteAttivita;
import it.unicam.cs.ids_progetto_casotto.controller.controller_utenza.IControllerClienteSpiaggia;
import it.unicam.cs.ids_progetto_casotto.model.attivita.Attivita;
import it.unicam.cs.ids_progetto_casotto.model.attivita.IClienteAttività;
import it.unicam.cs.ids_progetto_casotto.model.attivita.PrenotazioneAttivita;
import it.unicam.cs.ids_progetto_casotto.model.newsletter.Messaggio;
import it.unicam.cs.ids_progetto_casotto.model.utenza.*;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.*;

/**
 * Classe che rappresenta un
 * generico cliente che utilizzer&agrave;
 * il sistema
 */
@Entity
@Table(name = "Utente")
public class Cliente extends Persona {

//    private final List<PrenotazioneUtenza> utenzePrenotate;
//    private final List<PrenotazioneAttivita> attivitaPrenotate;
//    private final List<Messaggio> listaMessaggi;

//    public Cliente(int id, String nome, String cognome, String annoNascita, char sesso, String email) {
//        super(id, nome, cognome, annoNascita, sesso, email);
//        this.utenzePrenotate = new ArrayList<>();
//        this.attivitaPrenotate = new ArrayList<>();
//        this.listaMessaggi = new ArrayList<>();
//    }
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

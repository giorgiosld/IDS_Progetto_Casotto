package it.unicam.cs.ids_progetto_casotto.controller.controller_attivita;

import it.unicam.cs.ids_progetto_casotto.model.attivita.Attivita;
import it.unicam.cs.ids_progetto_casotto.model.attivita.IHandlerPrenotazioniAttivitaClienti;
import it.unicam.cs.ids_progetto_casotto.model.newsletter.IHandlerNewsletter;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Classe che permette di gestire
 * le attivit&agrave;
 */
@RestController
@RequestMapping("/bacheca")
public class ControllerAttivita implements IControllerClienteAttivita,IControllerGestoreAttivita {

   // private final List<Attivita> attivita;

   /* public ControllerAttivita() {
        this.attivita = new ArrayList<>();
    }

    */
    private ServiceAttivita serviceAttivita;

    @Override
    @GetMapping("/Offerte")
    public List<Attivita> getAttivita() {
       // return this.attivita;
        return this.serviceAttivita.getAll();
    }

    @Override
    @PostMapping
    public int getPostiDisponibili(@RequestBody Attivita attivita) {
       // return attivita.getPostiDisponibili();
        int postiDisponibili;
     postiDisponibili=this.serviceAttivita.getAll()
    }

    @Override
    public boolean creaPrenotazioneAttivitaCliente(IHandlerPrenotazioniAttivitaClienti receptionist, int idCliente, Attivita attivita) {
        LocalDate t1 = LocalDate.now();
        String str = t1.toString();
        PrenotazioneAttivitaCliente prenotazioneAttivitaCliente = new PrenotazioneAttivitaCliente(idCliente, attivita, str);
        if (!receptionist.aggiungiPrenotazioneAttivita(prenotazioneAttivitaCliente)) {
            System.out.println("Prenotazione di: " + prenotazioneAttivitaCliente + " non effettuata");
            return false;
        }
        receptionist.aggiungiPrenotazioneAttivita(prenotazioneAttivitaCliente);
        System.out.println("Prenotazione di: " + prenotazioneAttivitaCliente +" effettuata");
        return true;
    }

    @Override
    public boolean eliminaPrenotazioneAttivitaCliente(IHandlerPrenotazioniAttivitaClienti receptionist, PrenotazioneAttivitaCliente prenotazione) {
        receptionist.eliminaPrenotazioneAttivita(prenotazione);
        if (checkRimborso(prenotazione)) {
            System.out.println("Rimborso consentito!");
            return true;
        }
        System.out.println("Rimborso negato!");
        return false;
    }

    private boolean checkRimborso(PrenotazioneAttivitaCliente prenotazioneAttivita) {
        LocalDate dataSvolgimento = prenotazioneAttivita.getAttivitaPrenotata().getDataSvolgimento();
        LocalDate now = LocalDate.now();
        Period difference = Period.between(now,dataSvolgimento);
        if (difference.getYears() >= 0 || difference.getMonths() >= 0 || difference.getDays() >= 2) {
            return true;
        }
        return false;
    }

    @Override
    public boolean aggiungiAttivita(Attivita attivita) {
        if (this.getAttivita().contains(attivita)) {
            System.out.println("L'attività che si vuole aggiungere è già presente");
            return false;
        }
        System.out.println("Attività aggiunta correttamente");
        this.getAttivita().add(attivita);
        return true;
    }

    @Override
    public boolean eliminaAttivita(Attivita attivita) {
        if (!this.getAttivita().contains(attivita)) {
            System.out.println("L'attività che si vuole aggiungere non è presente");
            return false;
        }
        System.out.println("Attività rimossa correttamente");
        this.getAttivita().remove(attivita);
        return true;
    }

    @Override
    public boolean rimandaAttivita(IHandlerNewsletter receptionist, Attivita attivita, String nuovaData) {
        if (!this.getAttivita().contains(attivita)) {
            System.out.println("L'attività che si vuole rimandare non esiste");
            return false;
        }
        Optional<Attivita> check = this.getAttivita().stream().filter(x -> x==attivita).findFirst();
        check.ifPresent(value -> value.setDataSvolgimento(nuovaData));
        //TODO sistemare notifica clienti con receptionist
        return false;
    }
}

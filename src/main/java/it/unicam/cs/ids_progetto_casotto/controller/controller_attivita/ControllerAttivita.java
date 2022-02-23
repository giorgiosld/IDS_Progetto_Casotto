package it.unicam.cs.ids_progetto_casotto.controller.controller_attivita;

import it.unicam.cs.ids_progetto_casotto.model.attivita.Event;
import it.unicam.cs.ids_progetto_casotto.model.attivita.IHandlerPrenotazioniAttivitaClienti;
import it.unicam.cs.ids_progetto_casotto.model.attivita.Prenotazione;
import it.unicam.cs.ids_progetto_casotto.model.newsletter.IHandlerNewsletter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;

/**
 * Classe che permette di gestire
 * le attivit&agrave;
 */
@RestController
@RequestMapping("/bacheca")
public class ControllerAttivita implements IControllerClienteAttivita,IControllerGestoreAttivita {

    @Autowired
    private ServiceAttivita serviceAttivita;

    @Autowired
    private ServicePrenotazioneAttivita servicePrenotazioneAttivita;

    @Override
    @GetMapping("/offerte")
    public List<Event> getAttivita() {
        return this.serviceAttivita.getAll();
    }

    @Override
    @PostMapping("/addAttivita")
    public Event aggiungiAttivita(@RequestBody Event attivita) {
        Optional <Event> added = this.serviceAttivita.addAttivita(attivita);
        return this.getAttivitaOrThrownException(added, HttpStatus.BAD_REQUEST);
    }

    @Override
    @GetMapping("/attivita/{id}")
    public Event getSingolaAttivita(@PathVariable ("id")Integer id){
        Optional<Event> attivita = this.serviceAttivita.getAttivita(id);
        return this.getAttivitaOrThrownException(attivita, HttpStatus.NOT_FOUND);
    }

    @Override
    @GetMapping("/attivita/{id}/posti")
    public Integer getPostiDisponibili(@PathVariable("id") Integer id) {
        int postiDisponibili;
        postiDisponibili=this.serviceAttivita.getNPosti(id);
        return postiDisponibili;
    }

    @Override
    @DeleteMapping("attivita/{id}/cancellazione")
    public Event eliminaAttivita(@PathVariable Integer id) {
        Optional<Event> removed = this.serviceAttivita.eliminaAttivita(id);
        return this.getAttivitaOrThrownException(removed, HttpStatus.NOT_FOUND);
    }

    @Override
    @PutMapping("/attivita/{id}/rimanda")//mapping //modififa interfaccia e controller
    public Event rimandaAttivita(IHandlerNewsletter receptionist, @PathVariable("id")Integer id , @RequestBody Event attivita) {
        Optional<Event> check = this.serviceAttivita.getAttivita(id);
        if(check.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        Optional<Event>toUpdate = this.serviceAttivita.rimandaAttivita(id, attivita);
        //TODO sistemare notifica clienti con receptionist
        return this.getAttivitaOrThrownException(toUpdate,HttpStatus.BAD_REQUEST);
    }

    @Override
    @PostMapping("/prenota")
    public Prenotazione creaPrenotazioneAttivitaCliente(@RequestBody Prenotazione prenotazione) {
        Optional<Prenotazione> booked = this.servicePrenotazioneAttivita.creaPrenotazioneAttivita(prenotazione);
        return this.getPrenotazioneOrThrownException(booked, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/booked")
    public List<Prenotazione> getAllPrenotazioni(){
        return this.servicePrenotazioneAttivita.getAll();
    }

    @Override
    @DeleteMapping("/elimina/{id}")
    public PrenotazioneAttivitaCliente eliminaPrenotazioneAttivitaCliente(IHandlerPrenotazioniAttivitaClienti receptionist, @PathVariable("id") Integer idPrenotazione) {

        PrenotazioneAttivitaCliente attivitaEliminata = this.servicePrenotazioneAttivita.eliminaPrenotazioneAttivitaCliente(idPrenotazione).get();
        return attivitaEliminata;
    }


    private Event getAttivitaOrThrownException(Optional<Event> attivita, HttpStatus status) {
        if (attivita.isEmpty())
            throw new ResponseStatusException(status);
        return attivita.get();
    }

    private Prenotazione getPrenotazioneOrThrownException(Optional<Prenotazione> prenotazione, HttpStatus status) {
        if (prenotazione.isEmpty())
            throw new ResponseStatusException(status);
        return prenotazione.get();
    }
}

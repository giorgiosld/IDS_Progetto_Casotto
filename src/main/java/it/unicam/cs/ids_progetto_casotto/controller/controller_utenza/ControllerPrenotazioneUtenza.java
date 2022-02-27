package it.unicam.cs.ids_progetto_casotto.controller.controller_utenza;


import it.unicam.cs.ids_progetto_casotto.model.utenza.PrenotazioneUtenza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/prenotazione_utenza")
public class ControllerPrenotazioneUtenza {

    @Autowired
    private ServicePrenotazioneUtenze servicePrenotazioneUtenze;

    @GetMapping
    public List<PrenotazioneUtenza> getAllPrenotazioni() {
        return this.servicePrenotazioneUtenze.getAllPrenotazioni();
    }

    @GetMapping("/utenza/{id}")
    public List<PrenotazioneUtenza> getPrenotazioniByUtenzaId(@PathVariable("id") Integer id) {
        return this.getPrenotazioniOrThrownException(this.servicePrenotazioneUtenze.getPrenotazioniByUtenzaId(id), HttpStatus.NOT_FOUND);
    }

    @GetMapping("/user/{id}")
    public List<PrenotazioneUtenza> getPrenotazioniByClienteId(@PathVariable("id") Integer id) {
        return this.getPrenotazioniOrThrownException(this.servicePrenotazioneUtenze.getAllPrenotazioniByUserId(id), HttpStatus.NOT_FOUND);
    }

    @PostMapping("/prenotazione_utente/{idUtente}/tariffa/{idTariffa}/utenza/{idUtenza}")
    public PrenotazioneUtenza createPrenotazione(@PathVariable("idUtente")Integer idUtente, @PathVariable("idTariffa")Integer idTariffa,
                                                 @PathVariable("idUtenza")Integer idUtenza, @RequestBody PrenotazioneUtenza prenotazioneUtenza) {
        return this.getPrenotazioneOrThrownException(this.servicePrenotazioneUtenze.addPrenotazioneUtenza(idUtente,idTariffa,idUtenza,prenotazioneUtenza), HttpStatus.BAD_REQUEST);
    }

    private PrenotazioneUtenza getPrenotazioneOrThrownException(Optional<PrenotazioneUtenza> prenotazioneUtenza, HttpStatus status) {
        if (prenotazioneUtenza.isEmpty())
            throw new ResponseStatusException(status);
        return prenotazioneUtenza.get();
    }

    private List<PrenotazioneUtenza> getPrenotazioniOrThrownException(Optional<List<PrenotazioneUtenza>> prenotazioni, HttpStatus status) {
        if (prenotazioni.isEmpty())
            throw new ResponseStatusException(status);
        return prenotazioni.get();
    }

}

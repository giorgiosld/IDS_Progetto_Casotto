package it.unicam.cs.ids_progetto_casotto.controller.controller_ordinazione;

import it.unicam.cs.ids_progetto_casotto.model.ordinazione.*;
import it.unicam.cs.ids_progetto_casotto.model.ordinazione.Comanda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

/**
 * Classe che implementa un controller per le ordinazioni. Si possono effettuare varie operazioni tutte ineresnti alla
 * classe comanda e consumazione.
 */
@RestController
@RequestMapping("/bar")
public class ControllerOrdinazione implements IControllerStaffOrdinazione, IControllerClienteOrdinazione {

    @Autowired
    private ServiceConsumazioni serviceConsumazioni;

    @Autowired
    private ServiceOrdinazioni serviceOrdinazioni;


    @Override
    @GetMapping("/menu")
    public List<Consumazione> getConsumazioni() {
        return this.serviceConsumazioni.getAll();
    }

    @GetMapping("/consumazione/{id}")
    public Consumazione getConsumazione(@PathVariable("id") Integer id){
        Optional<Consumazione> got = this.serviceConsumazioni.getOne(id);
        return this.getConsumazioneOrThrownException(got, HttpStatus.NOT_FOUND);
    }

    @PostMapping("/addmenu")
    public Consumazione addConsumazione(@RequestBody Consumazione consumazione){
        Optional<Consumazione> added = this.serviceConsumazioni.addConsumazione(consumazione);
        return this.getConsumazioneOrThrownException(added, HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/removemenu/{id}")
    public Consumazione removeConsumazione(@PathVariable("id")Integer id){
        Optional<Consumazione>removed = this.serviceConsumazioni.removeConsumazione(id);
        return this.getConsumazioneOrThrownException(removed, HttpStatus.NOT_FOUND);
    }

    @PutMapping("/updatemenu/{id}")
    public Consumazione updateConsumazione(@PathVariable("id")Integer id, @RequestBody Consumazione consumazione){
        Optional<Consumazione> got = this.serviceConsumazioni.getOne(id);
        if (got.isEmpty())
                throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        Optional<Consumazione> updated = this.serviceConsumazioni.updateConsumazione(id, consumazione);
        return this.getConsumazioneOrThrownException(updated, HttpStatus.BAD_REQUEST);
    }

    @Override
    @PostMapping("/ordina")
    //public Comanda creaComanda(@RequestBody List<Consumazione> consumazioni, int idUtenza) {
    public Comanda creaComanda(@RequestBody List<Consumazione> consumazioni){
        //return this.serviceOrdinazioni.ordinaConsumazioni(consumazioni, idUtenza).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST))
        return this.serviceOrdinazioni.ordinaConsumazioni(consumazioni).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST));
    }


    @Override
    @GetMapping("/ordinazione/{id}")
    public Comanda getComanda(@PathVariable("id") Integer id) {
        Optional<Comanda> got = this.serviceOrdinazioni.getComanda(id);
        return this.getComandaOrThrownException(got, HttpStatus.NOT_FOUND);
    }

    @Override
    @GetMapping("/ordinazioni")
    public List<Comanda> getComande() {
        return this.serviceOrdinazioni.getAll();
    }

    @Override
    @GetMapping("/ordinazione{id}/stato")
    public StatoComanda getStatoComanda(@PathVariable Integer id) {
        Optional<Comanda> got = this.serviceOrdinazioni.getComanda(id);
        if(got.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return this.serviceOrdinazioni.getStatus(id);
    }

    //TODO sistemare problema del non modifica stato
    @Override
    @PutMapping("/ordinazione{id}/setstato")
    public StatoComanda setStatoComanda(@PathVariable Integer id,@RequestBody StatoComanda nuovoStato) {
        Optional<Comanda> got = this.serviceOrdinazioni.getComanda(id);
        if(got.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return this.serviceOrdinazioni.setStatus(id, nuovoStato);
        //return this.getStatoConsumazioneOrThrownExcpetion(updated, HttpStatus.BAD_REQUEST);
    }

    private Consumazione getConsumazioneOrThrownException(Optional<Consumazione> consumazione, HttpStatus status) {
        if (consumazione.isEmpty())
            throw new ResponseStatusException(status);
        return consumazione.get();
    }

    private Comanda getComandaOrThrownException(Optional<Comanda> comanda, HttpStatus status) {
        if (comanda.isEmpty())
            throw new ResponseStatusException(status);
        return comanda.get();
    }

    private StatoComanda getStatoConsumazioneOrThrownExcpetion(StatoComanda statoComanda, HttpStatus status){
        if (statoComanda == null)
            throw new ResponseStatusException(status);
        return statoComanda;
    }
}

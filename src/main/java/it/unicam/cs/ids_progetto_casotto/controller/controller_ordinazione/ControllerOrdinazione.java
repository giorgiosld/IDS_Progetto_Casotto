package it.unicam.cs.ids_progetto_casotto.controller.controller_ordinazione;

import it.unicam.cs.ids_progetto_casotto.model.ordinazione.*;
import it.unicam.cs.ids_progetto_casotto.model.ordinazione.Comanda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Classe che implementa un controller per le ordinazioni. Si possono effettuare varie operazioni tutte ineresnti alla
 * classe comanda e consumazione.
 */
@RestController
@RequestMapping("/bar")
public class ControllerOrdinazione implements IControllerStaffOrdinazione, IControllerClienteOrdinazione {

    /*private final List<Comanda> comande;
    private final List<Consumazione> consumazioni;
    private  List<Barista> staffBar;

    public ControllerOrdinazione(){
        this.comande = new ArrayList<>();
        this.consumazioni = new ArrayList<>();
        //da controllare
        this.staffBar = new ArrayList<>();
    }*/
    @Autowired
    private ServiceConsumazioni serviceConsumazioni;

    @Autowired
    private ServiceOrdinazioni serviceOrdinazioni;


    @Override
    @GetMapping("/menu")
    public List<Consumazione> getConsumazioni() {
        return this.serviceConsumazioni.getAll();
    }

    @PostMapping("/addmenu")
    public Consumazione addConsumazione(@RequestBody Consumazione consumazione){
        Optional<Consumazione> added = this.serviceConsumazioni.addConsumazione(consumazione);
        return this.getConsumazioneOrThrownException(added, HttpStatus.BAD_REQUEST);
    }

    @Override
    @PostMapping("/ordina")
    //public Comanda creaComanda(@RequestBody List<Consumazione> consumazioni, int idUtenza) {
    public Comanda creaComanda(@RequestBody List<Consumazione> consumazioni){
        //return this.serviceOrdinazioni.ordinaConsumazioni(consumazioni, idUtenza).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST))
        return this.serviceOrdinazioni.ordinaConsumazioni(consumazioni).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST));
    }

    @Override
    public Comanda notificaComanda(Barista barista, Comanda comanda) {
        barista.aggiungiComandaDaPreparare(comanda);
        return comanda;
    }

    @Override
    @GetMapping("ordinazione{id}")
    public Comanda getComanda(@PathVariable Integer id) {
        return this.serviceOrdinazioni.getComanda(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    @GetMapping("/ordinazioni")
    public List<Comanda> getComande() {
        return this.serviceOrdinazioni.getAll();
    }

    @Override
    @GetMapping("ordinazione{id}/stato")
    public StatoComanda getStatoComanda(@PathVariable Integer id) {
        //return Objects.requireNonNull(this.comande.stream().filter(x -> x.equals(comanda)).findFirst().orElse(null)).getStatoComanda();
        return this.serviceOrdinazioni.getStatus(id);
    }

    @Override
    @PostMapping("ordinazione{id}/stato")
    public void setStatoComanda(@PathVariable Integer id, StatoComanda nuovoStato) {
        //Objects.requireNonNull(this.comande.stream().filter(x -> x.equals(comanda)).findFirst().orElse(null)).setStatoComanda(nuovoStato);
        this.serviceOrdinazioni.setStatus(id, nuovoStato);
    }

    private Consumazione getConsumazioneOrThrownException(Optional<Consumazione> consumazione, HttpStatus status) {
        if (consumazione.isEmpty())
            throw new ResponseStatusException(status);
        return consumazione.get();
    }

}

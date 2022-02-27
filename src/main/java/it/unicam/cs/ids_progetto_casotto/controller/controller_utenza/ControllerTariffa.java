package it.unicam.cs.ids_progetto_casotto.controller.controller_utenza;


import it.unicam.cs.ids_progetto_casotto.model.utenza.Tariffa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tariffa")
public class ControllerTariffa {

    @Autowired
    private ServiceTariffa serviceTariffa;

    @GetMapping
    public List<Tariffa> getAllTariffe() { return this.serviceTariffa.getAllTariffe(); }

    @GetMapping("/{id}")
    public Tariffa getTariffaById(@PathVariable("id") Integer id) {
        return this.getTariffaOrThrownException(this.serviceTariffa.getTariffaById(id), HttpStatus.NOT_FOUND);
    }

    @PostMapping("/add_tariffa")
    public Tariffa addTariffa(@RequestBody Tariffa tariffa) {
        return this.getTariffaOrThrownException(this.serviceTariffa.addTariffa(tariffa), HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/update_tariffa/{id}")
    public Tariffa updateTariffa(@PathVariable("id") Integer id, @RequestBody Tariffa tariffa) {
        return this.getTariffaOrThrownException(this.serviceTariffa.updateTariffa(id,tariffa), HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/remove_tariffa/{id}")
    public Tariffa deleteTariffaById(@PathVariable("id")Integer id) {
        return this.getTariffaOrThrownException(this.serviceTariffa.deleteTariffa(id), HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/remove_all_tariffe")
    public List<Tariffa> deleteAllTariffe() {
        return this.getTariffeOrThrownException(this.serviceTariffa.deleteAllTariffe(), HttpStatus.NOT_FOUND);
    }

    private Tariffa getTariffaOrThrownException(Optional<Tariffa> tariffa, HttpStatus status) {
        if (tariffa.isEmpty())
            throw new ResponseStatusException(status);
        return tariffa.get();
    }

    private List<Tariffa> getTariffeOrThrownException(Optional<List<Tariffa>> tariffe, HttpStatus status) {
        if (tariffe.isEmpty())
            throw new ResponseStatusException(status);
        return tariffe.get();
    }

}

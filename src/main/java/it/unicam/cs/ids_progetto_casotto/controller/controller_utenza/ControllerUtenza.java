package it.unicam.cs.ids_progetto_casotto.controller.controller_utenza;

import it.unicam.cs.ids_progetto_casotto.model.utenza.Tipo;
import it.unicam.cs.ids_progetto_casotto.model.utenza.Utenza;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/utenza")
public class ControllerUtenza {

    @Autowired
    private ServiceUtenza serviceUtenza;

    @Autowired
    private ServicePeriodoUtenze servicePeriodoUtenze;

    @GetMapping
    public List<Utenza> getAllUtenze() { return this.serviceUtenza.getAllUtenze(); }

    @GetMapping("/{id}")
    public Utenza getUtenzaById(@PathVariable(value = "id") Integer id) {
        Optional<Utenza> get = this.serviceUtenza.getUtenzaById(id);
        return this.getUtenzaOrTrhownExecption(get, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{tipo}")
    public List<Utenza> getUtenzaByTipo(@PathVariable(value = "tipo")Tipo tipo) {
        Optional<List<Utenza>> get = this.serviceUtenza.getUtenzaByTipo(tipo);
        return this.getUtenzeOrThrownExecption(get, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{idPeriodo}")
    public List<Utenza> getUtenzeByPeriodo(@PathVariable(value = "idPeriodo")Integer idPeriodo) {
        Optional<List<Utenza>> get = this.serviceUtenza.getUtenzeByPeriodo(idPeriodo);
        return this.getUtenzeOrThrownExecption(get, HttpStatus.NOT_FOUND);
    }

    @PostMapping("/{tipo}")
    public Utenza createUtenza(@PathVariable(value = "tipo")@RequestBody Tipo tipo) {
        Optional<Utenza> added = this.serviceUtenza.createUtenza(tipo);
        return this.getUtenzaOrTrhownExecption(added, HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/{idPeriodo}/utenza")
    public Utenza addUtenzaInPeriodo(@PathVariable(value = "idPeriodo") Integer idPeriodo, @RequestBody Utenza utenza) {
        Optional<Utenza> added = this.serviceUtenza.addUtenzaInPeriodo(idPeriodo, utenza);
        return this.getUtenzaOrTrhownExecption(added, HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/periodo/{idPeriodo}/utenza/{idUtenza}")
    public Utenza deleteUtenzaFromPeriodo(@PathVariable(value = "idPeriodo")Integer idPeriodo, @RequestBody Integer idUtenza) {
        return null;
    }

    private Utenza getUtenzaOrTrhownExecption(Optional<Utenza> utenza, HttpStatus status) {
        if (utenza.isEmpty()) {
            throw new ResponseStatusException(status);
        }
        return utenza.get();
    }

    private List<Utenza> getUtenzeOrThrownExecption(Optional<List<Utenza>> utenze, HttpStatus status) {
        if (utenze.isEmpty()) {
            throw new ResponseStatusException(status);
        }
        return utenze.get();
    }
}

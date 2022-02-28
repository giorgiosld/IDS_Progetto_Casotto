package it.unicam.cs.ids_progetto_casotto.controller.controller_utenza;

import it.unicam.cs.ids_progetto_casotto.model.utenza.Utenza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/utenza")
public class ControllerUtenza {

    @Autowired
    private ServiceUtenza serviceUtenza;

    @GetMapping
    public List<Utenza> getAll() {
        return this.serviceUtenza.getAllUtenze();
    }

    @GetMapping("/id_periodo/{idPeriodo}")
    public List<Utenza> getUtenzaByIdPeriodo(@PathVariable("idPeriodo")Integer idPeriodo) {
        return this.getUtenzeOrThrownException(this.serviceUtenza.getUtenzeByIdPeriodo(idPeriodo),HttpStatus.NOT_FOUND);
    }

    @GetMapping("/giorno/{giorno}")
    public List<Utenza> getUtenzaByGiorno(@PathVariable("giorno")
                                           @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                           LocalDate giorno) {
        return this.getUtenzeOrThrownException(this.serviceUtenza.getUtenzeByGiorno(giorno), HttpStatus.NOT_FOUND);
    }

    @GetMapping("/giorno/{giorno}/orario/{orario}")
    public List<Utenza> getUtenzeByGiornoByOrario(@PathVariable("giorno")
                                                              @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                                              LocalDate giorno,
                                                  @PathVariable("orario") String orario) {
        return this.getUtenzeOrThrownException(this.serviceUtenza.getUtenzeByGiornoByOrario(giorno,orario), HttpStatus.NOT_FOUND);
    }

    @PostMapping()
    public Utenza addUtenzaInRepo(@RequestBody Utenza utenza) {
        return this.getUtenzaOrThrownException(this.serviceUtenza.addUtenzaInRepo(utenza), HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/add_utenza/{giorno}/fascia_oraria/{orario}/utenza/{id}")
    public Utenza addUtenzaInPeriodo(@PathVariable("giorno")
                                     @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)LocalDate giorno,
                                     @PathVariable("orario") String orario,
                                     @PathVariable Integer id) {
        return this.getUtenzaOrThrownException(this.serviceUtenza.addUtenzaInPeriodo(giorno,orario,id), HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/periodo/{idPeriodo}/utenza/{id}")
    public Utenza deleteUtenzaFromPeriodo(@PathVariable("idPeriodo")Integer idPeriodo, @PathVariable Integer id) {
        return this.getUtenzaOrThrownException(this.serviceUtenza.removeUtenzaFromPeriodo(idPeriodo,id), HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/remove_utenza/{id}")
    public Utenza deleteUtenza(@PathVariable("id") Integer id) {
        return this.getUtenzaOrThrownException(this.serviceUtenza.removeUtenza(id), HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/remove_all_utenze/from_all_periodi")
    public void deleteAllUtenzeFromAllPeriodi() {
        this.serviceUtenza.removeAllUtenzeFromPeriodi();
    }

    @DeleteMapping("/remove_all_utenze")
    public List<Utenza> deleteAllUtenze() {
        return this.getUtenzeOrThrownException(this.serviceUtenza.removeAllUtenze(), HttpStatus.NOT_FOUND);
    }



    private Utenza getUtenzaOrThrownException(Optional<Utenza> utenza, HttpStatus status) {
        if (utenza.isEmpty())
            throw new ResponseStatusException(status);
        return utenza.get();
    }

    private List<Utenza> getUtenzeOrThrownException(Optional<List<Utenza>> utenza, HttpStatus status) {
        if (utenza.isEmpty())
            throw new ResponseStatusException(status);
        return utenza.get();
    }
}

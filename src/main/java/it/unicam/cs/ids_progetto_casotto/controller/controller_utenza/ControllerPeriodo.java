package it.unicam.cs.ids_progetto_casotto.controller.controller_utenza;

import it.unicam.cs.ids_progetto_casotto.model.utenza.PeriodoDisponibilita;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/periodo")
public class ControllerPeriodo {

    @Autowired
    private ServicePeriodo servicePeriodo;

    @GetMapping
    public List<PeriodoDisponibilita> getAllPeriodi() {
        return this.servicePeriodo.getAllPeriodi();
    }

    @GetMapping("/{giorno}")
    public List<PeriodoDisponibilita> getPeriodoByGiorno(@PathVariable("giorno")
                                                       @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                                               LocalDate giorno) {
        return this.getPeriodiOrThrownException(this.servicePeriodo.getPeriodoByDay(giorno), HttpStatus.NOT_FOUND);
    }

    @GetMapping("/giorno/{giorno}/orario/{orario}")
    public PeriodoDisponibilita getPeriodoByDayByOrario(@PathVariable("giorno")
                                                        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                                        LocalDate giorno, @PathVariable("orario")String orario) {
        return this.getPeriodoOrThrownException(this.servicePeriodo.getPeriodoByDayByOrario(giorno,orario),HttpStatus.NOT_FOUND);
    }

    @PostMapping("/add_periodo")
    public PeriodoDisponibilita addPeriodo(@RequestBody PeriodoDisponibilita periodoDisponibilita) {
        return this.getPeriodoOrThrownException(this.servicePeriodo.addPeriodo(periodoDisponibilita), HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/delete_periodo/{id}")
    public PeriodoDisponibilita deletePeriodo(@PathVariable("id") Integer id) {
        return this.getPeriodoOrThrownException(this.servicePeriodo.deletePeriodo(id), HttpStatus.NOT_FOUND);
    }

    private PeriodoDisponibilita getPeriodoOrThrownException(Optional<PeriodoDisponibilita> periodo, HttpStatus status) {
        if (periodo.isEmpty())
            throw new ResponseStatusException(status);
        return periodo.get();
    }

    private List<PeriodoDisponibilita> getPeriodiOrThrownException(Optional<List<PeriodoDisponibilita>> periodo, HttpStatus status) {
        if (periodo.isEmpty())
            throw new ResponseStatusException(status);
        return periodo.get();
    }

}

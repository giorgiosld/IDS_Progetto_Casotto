package it.unicam.cs.ids_progetto_casotto.controller.controller_utenza;

import it.unicam.cs.ids_progetto_casotto.model.utenza.PeriodoDisponibilita;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ServicePeriodo {

    private final RepositoryPeriodo repositoryPeriodo;

    public ServicePeriodo(RepositoryPeriodo repositoryPeriodo) {
        this.repositoryPeriodo = repositoryPeriodo;
    }

    public List<PeriodoDisponibilita> getAllPeriodi() { return this.repositoryPeriodo.findAll(); }

    public Optional<List<PeriodoDisponibilita>> getPeriodoByDay(LocalDate giorno) {
        if (giorno == null) {
            return Optional.empty();
        }
        return Optional.of(this.repositoryPeriodo.findByGiorno(giorno));
    }

    public Optional<PeriodoDisponibilita> getPeriodoByDayByOrario(LocalDate date, String orario) {
        return Optional.of(this.repositoryPeriodo.findByGiornoAndFasciaOraria(date,orario));
    }

    public Optional<PeriodoDisponibilita> addPeriodo(PeriodoDisponibilita periodoDisponibilita) {
        if (periodoDisponibilita == null) {
            return Optional.empty();
        }
        if (!periodoDisponibilita.getFasciaOraria().equals("mattino") && !periodoDisponibilita.getFasciaOraria().equals("pomeriggio")
        && !periodoDisponibilita.getFasciaOraria().equals("giornata")) {
            return Optional.empty();
        }
        return Optional.of(this.repositoryPeriodo.save(periodoDisponibilita));
    }

    public Optional<PeriodoDisponibilita> deletePeriodo(Integer id) {
        Optional<PeriodoDisponibilita> deleted = this.repositoryPeriodo.findById(id);
        if (deleted.isEmpty()) {
            return Optional.empty();
        }
        this.repositoryPeriodo.deleteById(id);
        return deleted;
    }



}

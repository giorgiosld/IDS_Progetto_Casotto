package it.unicam.cs.ids_progetto_casotto.controller.controller_utenza;

import it.unicam.cs.ids_progetto_casotto.model.utenza.PeriodoDisponibilita;
import it.unicam.cs.ids_progetto_casotto.model.utenza.Utenza;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

@Service
public class ServiceUtenza {

    private RepositoryUtenza repositoryUtenza;
    private RepositoryPeriodo repositoryPeriodo;

    public ServiceUtenza(RepositoryUtenza repositoryUtenza, RepositoryPeriodo repositoryPeriodo) {
        this.repositoryUtenza = repositoryUtenza;
        this.repositoryPeriodo = repositoryPeriodo;
    }

    public List<Utenza> getAllUtenze() {
        return this.repositoryUtenza.findAll();
    }

    public Optional<List<Utenza>> getUtenzeByIdPeriodo(Integer idPeriodo) {
        Optional<PeriodoDisponibilita> periodoDisponibilita = this.repositoryPeriodo.findById(idPeriodo);
        if (periodoDisponibilita.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(this.repositoryUtenza.findUtenzasByPeriodiId(idPeriodo));
    }

    public Optional<List<Utenza>> getUtenzeByGiorno(LocalDate giorno) {
        List<PeriodoDisponibilita> periodo = this.repositoryPeriodo.findByGiorno(giorno);
        if (periodo.isEmpty()) {
            return Optional.empty();
        }
        List<Utenza> utenze = new ArrayList<>();
        periodo.forEach(x -> utenze.addAll(x.getUtenze()));
        return Optional.of(utenze);
    }

    public Optional<List<Utenza>> getUtenzeByGiornoByOrario(LocalDate giorno, String orario) {
        PeriodoDisponibilita periodoDisponibilita = this.repositoryPeriodo.findByGiornoAndFasciaOraria(giorno, orario);
        return Optional.of(this.repositoryUtenza.findUtenzasByPeriodiId(periodoDisponibilita.getId()));
    }

    public Optional<Utenza> addUtenzaInRepo(Utenza utenza) {
        if (utenza.getTipo().isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(this.repositoryUtenza.save(utenza));
    }

    public Optional<Utenza> addUtenzaInPeriodo(LocalDate giorno, String fasciaOraria, Integer id) {
        if (!fasciaOraria.equals("mattino") && !fasciaOraria.equals("pomeriggio") && !fasciaOraria.equals("giornata")) {
            return Optional.empty();
        }
        Optional<PeriodoDisponibilita> periodo = Optional.of(this.repositoryPeriodo.findByGiornoAndFasciaOraria(giorno,fasciaOraria));
        if (periodo.isEmpty()) {
            return Optional.empty();
        }
        Optional<Utenza> added = this.repositoryUtenza.findById(id);
        if (added.isEmpty()) {
            return Optional.empty();
        }
        periodo.get().addUtenza(added.get());
        this.repositoryPeriodo.save(periodo.get());
        return added;
    }

    public Optional<Utenza> removeUtenzaFromPeriodo(Integer idPeriodo, Integer id) {
        Optional<PeriodoDisponibilita> periodoDisponibilita = this.repositoryPeriodo.findById(idPeriodo);
        if (periodoDisponibilita.isEmpty()) {
            return Optional.empty();
        }
        Optional<Utenza> removed = Optional.of(periodoDisponibilita.get().removeUtenza(id));
        if (removed.isEmpty()) {
            return Optional.empty();
        }
        this.repositoryPeriodo.save(periodoDisponibilita.get());
        return removed;
    }

    public Optional<Utenza> removeUtenza(Integer id) {
        Optional<Utenza> removed = this.repositoryUtenza.findById(id);
        if (removed.isEmpty()) {
            return Optional.empty();
        }
        this.repositoryUtenza.deleteById(id);
        return removed;
    }

    public void removeAllUtenzeFromPeriodi() {
        Optional<List<PeriodoDisponibilita>> periodi = Optional.of(this.repositoryPeriodo.findAll());
        IntStream.range(0,periodi.get().size()).forEach(x -> {
            periodi.get().get(x).removeAllUtenze();
            this.repositoryPeriodo.save(periodi.get().get(x));
        });
    }

    public Optional<List<Utenza>> removeAllUtenze() {
        if (this.repositoryUtenza.findAll().isEmpty()) {
            return Optional.empty();
        }
        List<Utenza> removed = this.repositoryUtenza.findAll();
        this.repositoryUtenza.deleteAll();
        return Optional.of(removed);
    }

}

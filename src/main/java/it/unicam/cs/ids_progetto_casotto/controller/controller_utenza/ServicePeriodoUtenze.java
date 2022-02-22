package it.unicam.cs.ids_progetto_casotto.controller.controller_utenza;

import it.unicam.cs.ids_progetto_casotto.model.utenza.Periodo;
import it.unicam.cs.ids_progetto_casotto.model.utenza.Tipo;
import it.unicam.cs.ids_progetto_casotto.model.utenza.Utenza;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ServicePeriodoUtenze {

    private RepositoryPeriodoUtenze repositoryPeriodoUtenze;

    private RepositoryUtenze repositoryUtenze;

    public ServicePeriodoUtenze(RepositoryPeriodoUtenze repositoryPeriodoUtenze, RepositoryUtenze repositoryUtenze) {
        this.repositoryPeriodoUtenze = repositoryPeriodoUtenze;
        this.repositoryUtenze = repositoryUtenze;
    }

    public List<PeriodoUtenze> getAllPeriodi() { this.repositoryPeriodoUtenze.findAll(); }

    public Optional<PeriodoUtenze> getPeriodoById(Integer id) {
        return this.repositoryPeriodoUtenze.findById(id);
    }

    public Optional<PeriodoUtenze> getPeriodoByDay(LocalDate day) {
        return this.repositoryPeriodoUtenze
                .findAll().stream().filter(x -> x.getDay().equals(day)).findFirst();
    }

    public Optional<List<PeriodoUtenze>> getPeriodiByFasciaOraria(FasciaOrariaUtenze fasciaOrariaUtenze) {
        return Optional.of(this.repositoryPeriodoUtenze.findAll()
                .stream().filter(x -> x.getFasciaOrariaUtenze().equals(fasciaOrariaUtenze))
                .collect(Collectors.toList()));
    }

    public Optional<List<PeriodoUtenze>> getPeriodiByUtenza(Integer idUtenza) {
        if (!this.repositoryUtenze.existsById(idUtenza)) {
            return Optional.empty();
        }
        return Optional.of(this.repositoryPeriodoUtenze.findPeriodoByUtenzaId(idUtenza));
    }

    public Optional<PeriodoUtenze> createPeriodo(PeriodoUtenze periodoUtenze) {
        if (periodoUtenze == null) { return Optional.empty(); }
        return Optional.of(this.repositoryPeriodoUtenze.save(periodoUtenze));
    }

    public Optional<PeriodoUtenze> deletePeriodo(Integer id) {
        Optional<PeriodoUtenze> periodoUtenze = this.repositoryPeriodoUtenze.findById(id);
        if (periodoUtenze.isEmpty()) {
            return Optional.empty();
        }
        this.repositoryPeriodoUtenze.deleteById(id);
        return periodoUtenze;
    }

    public Optional<List<PeriodoUtenze>> deleteAllPeriodi() {
        Optional<List<PeriodoUtenze>> deleted = Optional.of(this.repositoryPeriodoUtenze.findAll());
        if (this.repositoryPeriodoUtenze.findAll().isEmpty()) {
            return Optional.empty();
        }
        this.repositoryPeriodoUtenze.deleteAll();
        return deleted;
    }

    public List<Utenza> getAllUtenze() {
        List<Utenza> utenze = new ArrayList<>();
        this.repositoryPeriodoUtenze.findAll().forEach(x -> utenze.addAll(x.getUtenze()));
        return utenze;
    }

    public List<Utenza> getUtenzeByPeriod(LocalDate day, FasciaOrariaUtenze fasciaOrariaUtenze) {
        List<Utenza> utenze = new ArrayList<>();
        this.repositoryPeriodoUtenze.findAll().stream()
                .filter(x -> x.getDay().equals(day) && x.getFasciaOrariaUtenze().equals(fasciaOrariaUtenze))
                .forEach(x -> utenze.addAll(x.getUtenze()));
        return utenze;
    }

    public Optional<Utenza> add(PeriodoUtenze periodoUtenze, Tipo utenza) {
        Utenza utenza1 = new Utenza();
        utenza1.setTipo(utenza);
        if (utenza == Tipo.LETTINO) {
            utenza1.setNumeroPostiOccupabili(1);
            this.repositoryPeriodoUtenze.save(utenza1);
        } else if (utenza == Tipo.OMBRELLONE) {
            utenza1.setNumeroPostiOccupabili(4);
            this.repositoryPeriodoUtenze.save(utenza1);
        } else if (utenza == Tipo.SDRAIO) {
            utenza1.setNumeroPostiOccupabili(1);
            this.repositoryPeriodoUtenze.save(utenza1);
        }
        return Optional.of(utenza1);
    }

    public Optional<Utenza> removeUtenza(Integer id) {
        Optional<Utenza> toRemove = this.repositoryPeriodoUtenze.findById(id);
        if (toRemove.isEmpty()) {
            return Optional.empty();
        }
        this.repositoryPeriodoUtenze.deleteById(id);
        return toRemove;
    }
}

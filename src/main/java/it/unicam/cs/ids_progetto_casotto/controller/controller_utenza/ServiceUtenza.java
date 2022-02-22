package it.unicam.cs.ids_progetto_casotto.controller.controller_utenza;

import it.unicam.cs.ids_progetto_casotto.model.utenza.Tipo;
import it.unicam.cs.ids_progetto_casotto.model.utenza.Utenza;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ServiceUtenza {

    private RepositoryUtenze repositoryUtenze;

    private RepositoryPeriodoUtenze repositoryPeriodoUtenze;

    public ServiceUtenza(RepositoryUtenze repositoryUtenze, RepositoryPeriodoUtenze repositoryPeriodoUtenze) {
        this.repositoryUtenze = repositoryUtenze;
        this.repositoryPeriodoUtenze = repositoryPeriodoUtenze;
    }

    public List<Utenza> getAllUtenze() { return this.repositoryUtenze.findAll(); }

    public Optional<Utenza> getUtenzaById(Integer id) { return this.repositoryUtenze.findById(id); }

    public Optional<List<Utenza>> getUtenzaByTipo(Tipo tipo) {
        return Optional.of(this.repositoryUtenze.findAll().stream()
                .filter(x -> x.getTipo().equals(tipo))
                .collect(Collectors.toList()));
    }

    public Optional<List<Utenza>> getUtenzeByPeriodo(Integer idPeriodo) {
        if (!this.repositoryPeriodoUtenze.existsById(idPeriodo)) {
            return Optional.empty();
        }
        return Optional.of(this.repositoryUtenze.findUtenzaByPeriodoId(idPeriodo));
    }

    public Optional<Utenza> createUtenza(Tipo utenza) {
        Utenza utenza1 = new Utenza();
        utenza1.setTipo(utenza);
        if (utenza == Tipo.LETTINO) {
            utenza1.setNumeroPostiOccupabili(1);
            this.repositoryUtenze.save(utenza1);
        } else if (utenza == Tipo.OMBRELLONE) {
            utenza1.setNumeroPostiOccupabili(4);
            this.repositoryUtenze.save(utenza1);
        } else if (utenza == Tipo.SDRAIO) {
            utenza1.setNumeroPostiOccupabili(1);
            this.repositoryUtenze.save(utenza1);
        }
        return Optional.of(utenza1);
    }

    public Optional<Utenza> addUtenzaInPeriodo(Integer idPeriodo, Utenza utenza) {
        Optional<PeriodoUtenze> periodo = this.repositoryPeriodoUtenze.findById(idPeriodo);
        if (periodo.isEmpty()) {
            return Optional.empty();
        }
        Integer idUtenza = utenza.getId();
        if (idUtenza != 0) {
            Optional<Utenza> _utenza = this.repositoryUtenze.findById(idUtenza);
            if (_utenza.isEmpty()) {
                return Optional.empty();
            }
            periodo.get().addUtenza(_utenza.get());
            this.repositoryPeriodoUtenze.save(periodo.get());
            return _utenza;
        }
        periodo.get().addUtenza(utenza);
        return Optional.of(this.repositoryUtenze.save(utenza));
    }

}

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

    public Optional<Utenza> addUtenza(Integer idPeriodo, Utenza utenza) {
       Utenza utenza1 = this.repositoryPeriodoUtenze.findById(idPeriodo).map(periodo -> {
           Integer idUtenza = utenza.getId();
           if (idUtenza != 0) {
               Optional<Utenza> _utenza = this.repositoryUtenze.findById(idUtenza);
               if (_utenza.isEmpty()) {
                   return null;
               }
               periodo.addUtenza(_utenza.get());
               this.repositoryPeriodoUtenze.save(periodo);
               return _utenza.get();
           }
           periodo.addUtenza(utenza);
           return this.repositoryUtenze.save(utenza);
       }).orElse(null);
        return Optional.empty();
    }

}

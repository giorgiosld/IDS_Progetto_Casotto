package it.unicam.cs.ids_progetto_casotto.controller.controller_utenza;

import it.unicam.cs.ids_progetto_casotto.model.utenza.Tariffa;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceTariffa {

    private RepositoryTariffa repositoryTariffa;

    public ServiceTariffa(RepositoryTariffa repositoryTariffa) {
        this.repositoryTariffa = repositoryTariffa;
    }

    public List<Tariffa> getAllTariffe() { return this.repositoryTariffa.findAll(); }

    public Optional<Tariffa> getTariffaById(Integer id) { return this.repositoryTariffa.findById(id); }

    public Optional<Tariffa> addTariffa(Tariffa tariffa) {
        String orario = tariffa.getFasciaOraria();
        if (!orario.equals("mattino") && !orario.equals("pomeriggio") && !orario.equals("giornata")) {
            return Optional.empty();
        }
        return Optional.of(this.repositoryTariffa.save(tariffa));
    }

    public Optional<Tariffa> updateTariffa(Integer idTariffa, Tariffa tariffa) {
        Optional<Tariffa> tariffa1 = this.repositoryTariffa.findById(idTariffa);
        if (tariffa1.isEmpty()) {
            return Optional.empty();
        }
        tariffa1.get().setFasciaOraria(tariffa.getFasciaOraria());
        tariffa1.get().setPrezzo(tariffa.getPrezzo());
        tariffa1.get().setNumeroAttivita(tariffa.getNumeroAttivita());
        this.repositoryTariffa.save(tariffa1.get());
        return tariffa1;
    }

    public Optional<Tariffa> deleteTariffa(Integer id) {
        Optional<Tariffa> deleted = this.repositoryTariffa.findById(id);
        if (deleted.isEmpty()) {
            return Optional.empty();
        }
        this.repositoryTariffa.deleteById(id);
        return deleted;
    }

    public Optional<List<Tariffa>> deleteAllTariffe() {
        List<Tariffa> tariffe = this.getAllTariffe();
        if (tariffe.isEmpty()) {
            return Optional.empty();
        }
        this.repositoryTariffa.deleteAll();
        return Optional.of(tariffe);
    }

}

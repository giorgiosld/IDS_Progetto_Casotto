package it.unicam.cs.ids_progetto_casotto.controller.controller_attivita;

import it.unicam.cs.ids_progetto_casotto.controller.controller_utente.RepositoryUtente;
import it.unicam.cs.ids_progetto_casotto.model.attivita.Event;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceAttivita {


    private RepositoryAttivita repositoryAttivita;

    private RepositoryUtente repositoryUtente;

    public ServiceAttivita(RepositoryAttivita repositoryAttivita, RepositoryUtente repositoryUtente) {
        this.repositoryAttivita = repositoryAttivita;
        //this.repositoryPrenotazioneAttivita = repositoryPrenotazioneAttivita;
        this.repositoryUtente=repositoryUtente;
    }

    public List<Event> getAll() {
        return this.repositoryAttivita.findAll();
    }

    public int getNPosti(Integer id) {
        return this.repositoryAttivita.getById(id).getPostiDisponibili();

    }

    public Optional<Event> getAttivita(Integer id) {
        Optional<Event> attivita = this.repositoryAttivita.findById(id);
        if (attivita.isEmpty()) {
            return Optional.empty();
        }
        return attivita;
    }

    public Optional<Event> addAttivita(Event attivita) {
        if ((attivita.getNome().isEmpty()) || (attivita.getDataSvolgimento().toString().isEmpty())) {
            return Optional.empty();
        }
        return Optional.of(repositoryAttivita.save(attivita));
    }

    public Optional<Event> eliminaAttivita(Integer id) {
        Optional<Event> toRemove = this.repositoryAttivita.findById(id);
        if (toRemove.isEmpty()) {
            return Optional.empty();
        }
        this.repositoryAttivita.deleteById(id);
        return toRemove;

    }

    public Optional<Event> rimandaAttivita(Integer id, Event nuovaData) {
        Event check = this.repositoryAttivita.getById(id);
        check.setDataSvolgimento(nuovaData.getDataSvolgimento());
        return Optional.of(this.repositoryAttivita.save(check));
    }
}


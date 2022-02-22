package it.unicam.cs.ids_progetto_casotto.controller.controller_attivita;

import it.unicam.cs.ids_progetto_casotto.controller.controller_utente.RepositoryUtente;
import it.unicam.cs.ids_progetto_casotto.model.Cliente;
import it.unicam.cs.ids_progetto_casotto.model.attivita.Attivita;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.LocalDateTime;
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

    public List<Attivita> getAll() {
        return this.repositoryAttivita.findAll();
    }

    public int getNPosti(Integer id) {
        return this.repositoryAttivita.getById(id).getPostiDisponibili();

    }

    public Optional<Attivita> getAttivita(Integer id) {
        Optional<Attivita> attivita = this.repositoryAttivita.findById(id);
        if (attivita.isEmpty()) {
            return Optional.empty();
        }
        return attivita;
    }

    public Optional<Attivita> addAttivita(Attivita attivita) {
        if ((attivita.getNome().isEmpty()) || (attivita.getDataSvolgimento().toString().isEmpty())) {
            return Optional.empty();
        }
        return Optional.of(repositoryAttivita.save(attivita));
    }

    public Optional<Attivita> eliminaAttivita(Integer id) {
        Optional<Attivita> toRemove = this.repositoryAttivita.findById(id);
        if (toRemove.isEmpty()) {
            return Optional.empty();
        }
        this.repositoryAttivita.deleteById(id);
        return toRemove;

    }

    public Optional<Attivita> rimandaAttivita(Integer id, Attivita nuovaData) {
        Attivita check = this.repositoryAttivita.getById(id);
        check.setDataSvolgimento(nuovaData.getDataSvolgimento());
        return Optional.of(this.repositoryAttivita.save(check));
    }
}


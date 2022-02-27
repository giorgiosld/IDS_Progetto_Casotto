package it.unicam.cs.ids_progetto_casotto.controller.controller_attivita;

import it.unicam.cs.ids_progetto_casotto.controller.controller_utenza.RepositoryPrenotazioneUtenza;
import it.unicam.cs.ids_progetto_casotto.model.attivita.Prenotazione;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicePrenotazioneAttivita {

    private RepositoryPrenotazione repositoryPrenotazione;
    private RepositoryPrenotazioneUtenza repositoryPrenotazioneUtenza;

    public ServicePrenotazioneAttivita(RepositoryPrenotazione repositoryPrenotazione, RepositoryPrenotazioneUtenza repositoryPrenotazioneUtenza){
        this.repositoryPrenotazione = repositoryPrenotazione;
        this.repositoryPrenotazioneUtenza = repositoryPrenotazioneUtenza;
    }

    public Optional<Prenotazione> creaPrenotazioneAttivita(Prenotazione prenotazione) {

        return Optional.of(this.repositoryPrenotazione.save(prenotazione));

    }

    public List<Prenotazione> getAll(){
        return this.repositoryPrenotazione.findAll();
    }


}

package it.unicam.cs.ids_progetto_casotto.controller.controller_attivita;

import it.unicam.cs.ids_progetto_casotto.controller.controller_utenza.PrenotazioneUtenzaCliente;
import it.unicam.cs.ids_progetto_casotto.controller.controller_utenza.RepositoryPrenotazioneUtenza;
import it.unicam.cs.ids_progetto_casotto.model.attivita.Prenotazione;
import it.unicam.cs.ids_progetto_casotto.model.utenza.Utenza;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ServicePrenotazioneAttivita {

    private RepositoryPrenotazione repositoryPrenotazione;
    private RepositoryPrenotazioneUtenza repositoryPrenotazioneUtenza;

    public ServicePrenotazioneAttivita(RepositoryPrenotazione repositoryPrenotazione, RepositoryPrenotazioneUtenza repositoryPrenotazioneUtenza){
        this.repositoryPrenotazione = repositoryPrenotazione;
        this.repositoryPrenotazioneUtenza = repositoryPrenotazioneUtenza;
    }

    public Optional<Prenotazione> creaPrenotazioneAttivita(Prenotazione prenotazione) {

        Set<PrenotazioneUtenzaCliente> toAdd = prenotazione.getUtenzaPrenotazioneList();
        for (PrenotazioneUtenzaCliente prenotazionesingol: toAdd){
            this.repositoryPrenotazioneUtenza.save(prenotazionesingol);
        }
        return Optional.of(this.repositoryPrenotazione.save(prenotazione));

    }

    public List<Prenotazione> getAll(){
        return this.repositoryPrenotazione.findAll();
    }


}

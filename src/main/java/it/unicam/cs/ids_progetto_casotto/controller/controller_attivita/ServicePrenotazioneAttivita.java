package it.unicam.cs.ids_progetto_casotto.controller.controller_attivita;

import it.unicam.cs.ids_progetto_casotto.model.attivita.Prenotazione;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicePrenotazioneAttivita {

    private RepositoryPrenotazione repositoryPrenotazione;

    public ServicePrenotazioneAttivita(RepositoryPrenotazione repositoryPrenotazione){
        this.repositoryPrenotazione = repositoryPrenotazione;
    }

    public Optional<Prenotazione> creaPrenotazioneAttivita(Prenotazione prenotazione) {

        return Optional.of(this.repositoryPrenotazione.save(prenotazione));
    }

    public List<Prenotazione> getAll(){
        return this.repositoryPrenotazione.findAll();
    }

    public Optional<PrenotazioneAttivitaCliente> eliminaPrenotazioneAttivitaCliente(Integer idPrenotazione) {
        //<PrenotazioneAttivitaCliente> toDelete = this.repositoryPrenotazioneAttivita.findById(idPrenotazione);
        //if(toDelete.isEmpty()){
        //    return Optional.empty();
        //}
        //this.repositoryPrenotazioneAttivita.deleteById(idPrenotazione);
        return Optional.empty();

    }
}

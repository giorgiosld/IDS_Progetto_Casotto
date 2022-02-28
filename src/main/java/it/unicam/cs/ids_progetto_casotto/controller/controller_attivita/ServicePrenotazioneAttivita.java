package it.unicam.cs.ids_progetto_casotto.controller.controller_attivita;

import it.unicam.cs.ids_progetto_casotto.controller.controller_utente.RepositoryUtente;
import it.unicam.cs.ids_progetto_casotto.controller.controller_utenza.RepositoryPrenotazioneUtenza;
import it.unicam.cs.ids_progetto_casotto.model.User;
import it.unicam.cs.ids_progetto_casotto.model.attivita.Event;
import it.unicam.cs.ids_progetto_casotto.model.attivita.Prenotazione;
import it.unicam.cs.ids_progetto_casotto.model.utenza.PrenotazioneUtenza;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ServicePrenotazioneAttivita {

    private final RepositoryPrenotazione repositoryPrenotazione;
    private final RepositoryAttivita repositoryEvent;
    private final RepositoryUtente repositoryUser;

    public ServicePrenotazioneAttivita(RepositoryPrenotazione repositoryPrenotazione, RepositoryAttivita repositoryAttivita, RepositoryUtente repositoryUser){
        this.repositoryPrenotazione = repositoryPrenotazione;
        this.repositoryEvent = repositoryAttivita;
        this.repositoryUser = repositoryUser;
    }

    public List<Prenotazione> getAll(){
        return this.repositoryPrenotazione.findAll();
    }

    public Optional<Prenotazione> creaPrenotazioneAttivita(Integer idUser, Integer idAttivita) {
        Optional<User> user = this.repositoryUser.findById(idUser);
        if (user.isEmpty()) { return Optional.empty(); }
        Optional<Event> event = this.repositoryEvent.findById(idAttivita);
        if(event.isEmpty()){
            return Optional.empty();
        }
        //Set<PrenotazioneUtenza> prenotazioniUtenze = user.get().getPrenotazioneUtenzaSet();
        Prenotazione prenotazione = new Prenotazione();
        prenotazione.setId(1);
        prenotazione.setAttivita(event.get());
        prenotazione.setUser(user.get());
        //user.get().getPrenotazioneAttivita().add(prenotazione);
        //this.repositoryUser.save(user.get());
        //event.get().getPrenotazioni().add(prenotazione);
        //this.repositoryEvent.save(event.get());
        return Optional.of(this.repositoryPrenotazione.save(prenotazione));
    }

    public Optional<Prenotazione> deletePrenotazione(Integer id) {
        Optional<Prenotazione> deleted = this.repositoryPrenotazione.findById(id);
        if (deleted.isEmpty()) { return Optional.empty(); }
        Event evento = deleted.get().getAttivita();
        if (evento.getNumeroMassimoPosti() != null) {
            evento.aumentaNumeroPostiDisponibili();
        }
        evento.getPrenotazioni().remove(deleted.get());
        User user = deleted.get().getUser();
        user.getPrenotazioneAttivita().remove(deleted.get());
        deleted.get().setUser(null);
        deleted.get().setAttivita(null);
        this.repositoryPrenotazione.deleteById(id);
        return deleted;
    }
}

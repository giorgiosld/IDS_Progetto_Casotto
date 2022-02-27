package it.unicam.cs.ids_progetto_casotto.controller.controller_utenza;

import it.unicam.cs.ids_progetto_casotto.controller.controller_utente.RepositoryUtente;
import it.unicam.cs.ids_progetto_casotto.model.User;
import it.unicam.cs.ids_progetto_casotto.model.utenza.PeriodoDisponibilita;
import it.unicam.cs.ids_progetto_casotto.model.utenza.PrenotazioneUtenza;
import it.unicam.cs.ids_progetto_casotto.model.utenza.Tariffa;
import it.unicam.cs.ids_progetto_casotto.model.utenza.Utenza;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ServicePrenotazioneUtenze {

    private RepositoryPrenotazioneUtenza repositoryPrenotazioneUtenza;
    private RepositoryUtenza repositoryUtenza;
    private RepositoryTariffa repositoryTariffa;
    private RepositoryUtente repositoryUser;
    private RepositoryPeriodo repositoryPeriodo;

    public ServicePrenotazioneUtenze(RepositoryPrenotazioneUtenza repositoryPrenotazioneUtenza,
                                     RepositoryUtenza repositoryUtenza, RepositoryTariffa repositoryTariffa,
                                     RepositoryUtente repositoryUser, RepositoryPeriodo repositoryPeriodo) {
        this.repositoryPrenotazioneUtenza = repositoryPrenotazioneUtenza;
        this.repositoryUtenza = repositoryUtenza;
        this.repositoryTariffa = repositoryTariffa;
        this.repositoryUser = repositoryUser;
        this.repositoryPeriodo = repositoryPeriodo;
    }

    public List<PrenotazioneUtenza> getAllPrenotazioni() { return this.repositoryPrenotazioneUtenza.findAll(); }

    public Optional<List<PrenotazioneUtenza>> getPrenotazioniByUtenzaId(Integer id) {
        Optional<Utenza> utenza = this.repositoryUtenza.findById(id);
        if (utenza.isEmpty()) { return Optional.empty(); }
        return Optional.of(this.repositoryPrenotazioneUtenza.findPrenotazioneUtenzaByUtenzaId(id));
    }

    public Optional<List<PrenotazioneUtenza>> getAllPrenotazioniByUserId(Integer id) {
        Optional<User> user = this.repositoryUser.findById(id);
        if (user.isEmpty()) { return Optional.empty(); }
        return Optional.of(this.repositoryPrenotazioneUtenza.findPrenotazioneUtenzaByUserId(id));
    }

    public Optional<PrenotazioneUtenza> addPrenotazioneUtenza(Integer idUser, Integer idTariffa, Integer idUtenza, PrenotazioneUtenza prenotazioneUtenza) {
        Optional<User> utente = this.repositoryUser.findById(idUser);
        if (utente.isEmpty()) { return Optional.empty(); }
        Optional<Tariffa> tariffa = this.checkTariffa(idTariffa, prenotazioneUtenza);
        if (tariffa.isEmpty()) { return Optional.empty(); }
        Optional<Utenza> utenza = this.repositoryUtenza.findById(idUtenza);
        if (utenza.isEmpty()) { return Optional.empty(); }
        if (prenotazioneUtenza.getCheckIn().equals(prenotazioneUtenza.getCheckOut())) {
            if (!this.addPrenotazioneStessoGiorno(tariffa.get(), utenza.get(), prenotazioneUtenza)) { return Optional.empty(); }
        } else {
            if(!this.addPrenotazionePiuGiorni(utenza.get(),prenotazioneUtenza)) { return Optional.empty(); }
        }
        return Optional.of(this.repositoryPrenotazioneUtenza.save(this.setPrenotazione(utente.get(), tariffa.get(), utenza.get(), prenotazioneUtenza)));
    }

    private PrenotazioneUtenza setPrenotazione(User user, Tariffa tariffa, Utenza utenza, PrenotazioneUtenza prenotazioneUtenza) {
        prenotazioneUtenza.assegnaUtente(user);
        user.getPrenotazioneUtenzaSet().add(prenotazioneUtenza);
        this.repositoryUser.save(user);
        prenotazioneUtenza.assegnaTariffa(tariffa);
        tariffa.getPrenotazioneUtenzaSet().add(prenotazioneUtenza);
        this.repositoryTariffa.save(tariffa);
        prenotazioneUtenza.assegnaUtenza(utenza);
        utenza.getPrenotazioneUtenzaSet().add(prenotazioneUtenza);
        this.repositoryUtenza.save(utenza);
        return prenotazioneUtenza;
    }

    private boolean addPrenotazioneStessoGiorno(Tariffa tariffa, Utenza utenza, PrenotazioneUtenza prenotazioneUtenza) {
        PeriodoDisponibilita periodoDisponibilita = this.repositoryPeriodo.findByGiornoAndFasciaOraria(prenotazioneUtenza.getCheckIn(), "giornata");
        List<Utenza> utenze = this.repositoryUtenza.findUtenzasByPeriodiId(periodoDisponibilita.getId());
        if (!utenze.contains(utenza)) { return false; }
        if (!tariffa.getFasciaOraria().equals("giornata")) {
            PeriodoDisponibilita giornaliero = this.repositoryPeriodo.findByGiornoAndFasciaOraria(prenotazioneUtenza.getCheckIn(),"giornata");
            giornaliero.removeUtenza(utenza.getId());
            this.repositoryPeriodo.save(giornaliero);
        }
        if (tariffa.getFasciaOraria().equals("giornata")) {
            this.removeUtenzeFromMattinoPomeriggio(prenotazioneUtenza.getCheckIn(),utenza);
        }
        periodoDisponibilita.removeUtenza(utenza.getId());
        this.repositoryPeriodo.save(periodoDisponibilita);
        return true;
    }

    private void removeUtenzeFromMattinoPomeriggio(LocalDate giorno, Utenza utenza) {
        PeriodoDisponibilita mattino = this.repositoryPeriodo.findByGiornoAndFasciaOraria(giorno,"mattino");
        mattino.removeUtenza(utenza.getId());
        PeriodoDisponibilita pomeriggio = this.repositoryPeriodo.findByGiornoAndFasciaOraria(giorno,"pomeriggio");
        pomeriggio.removeUtenza(utenza.getId());
        this.repositoryPeriodo.save(mattino);
        this.repositoryPeriodo.save(pomeriggio);
    }

    private boolean addPrenotazionePiuGiorni(Utenza utenza, PrenotazioneUtenza prenotazioneUtenza) {
        for (LocalDate date = prenotazioneUtenza.getCheckIn(); date.isBefore(prenotazioneUtenza.getCheckOut().plusDays(1)); date = date.plusDays(1)) {
            PeriodoDisponibilita periodoDisponibilita = this.repositoryPeriodo.findByGiornoAndFasciaOraria(date,"giornata");
            List<Utenza> utenze = this.repositoryUtenza.findUtenzasByPeriodiId(periodoDisponibilita.getId());
            if (!utenze.contains(utenza)) { return false; }
            this.removeUtenzeFromMattinoPomeriggio(date,utenza);
            periodoDisponibilita.removeUtenza(utenza.getId());
            this.repositoryPeriodo.save(periodoDisponibilita);
        }
        return true;
    }

    private Optional<Tariffa> checkTariffa(Integer idTariffa, PrenotazioneUtenza prenotazioneUtenza) {
        Optional<Tariffa> tariffa = this.repositoryTariffa.findById(idTariffa);
        if (tariffa.isEmpty()) { return Optional.empty(); }
        if (!prenotazioneUtenza.getCheckIn().equals(prenotazioneUtenza.getCheckOut()) && !tariffa.get().getFasciaOraria().equals("giornata")) {
            return Optional.empty();
        }
        return tariffa;
    }

}

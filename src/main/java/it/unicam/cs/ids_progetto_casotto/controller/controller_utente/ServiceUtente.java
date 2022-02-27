package it.unicam.cs.ids_progetto_casotto.controller.controller_utente;

import it.unicam.cs.ids_progetto_casotto.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceUtente {

    private RepositoryUtente repositoryUtente;

    public ServiceUtente(RepositoryUtente repositoryUtente){
        this.repositoryUtente = repositoryUtente;
    }

    public Optional<List<User>> getAllUser() {
        List<User> utenti = this.repositoryUtente.findAll();
        if (utenti.isEmpty()) { return Optional.empty(); }
        return Optional.of(utenti);
    }

    public Optional<User> getUserById(Integer id) {
        return this.repositoryUtente.findById(id);
    }

    public Optional<User> getUserByIdPrenotazione(Integer idPrenotazione) {
        Optional<User> user = Optional.of(this.repositoryUtente.findUserByPrenotazioneUtenzaSetId(idPrenotazione));
        return user;
    }

    public Optional<User> addUserInRepo(User user) {
        if (user == null || user.getNome() == null || user.getCognome() == null ||
                user.getEmail() == null) { return Optional.empty(); }
        return Optional.of(this.repositoryUtente.save(user));
    }

    public Optional<User> removeUserInRepo(Integer id) {
        Optional<User> deleted = this.repositoryUtente.findById(id);
        if (deleted.isEmpty()) { return Optional.empty(); }
        this.repositoryUtente.deleteById(id);
        return deleted;
    }
}

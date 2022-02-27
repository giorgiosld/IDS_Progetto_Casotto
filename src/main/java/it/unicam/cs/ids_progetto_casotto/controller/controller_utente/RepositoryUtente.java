package it.unicam.cs.ids_progetto_casotto.controller.controller_utente;

import it.unicam.cs.ids_progetto_casotto.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryUtente extends JpaRepository<User, Integer> {
    User findUserByPrenotazioneUtenzaSetId(Integer idPrenotazione);
}

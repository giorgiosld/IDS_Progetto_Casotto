package it.unicam.cs.ids_progetto_casotto.controller.controller_attivita;

import it.unicam.cs.ids_progetto_casotto.model.attivita.Prenotazione;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryPrenotazione extends JpaRepository<Prenotazione, Integer> {
}

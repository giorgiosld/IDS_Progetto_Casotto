package it.unicam.cs.ids_progetto_casotto.controller.controller_attivita;

import it.unicam.cs.ids_progetto_casotto.model.attivita.Attivita;
import it.unicam.cs.ids_progetto_casotto.model.ordinazione.Consumazione;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RepositoryAttivita extends JpaRepository<Attivita, Integer> {
}

package it.unicam.cs.ids_progetto_casotto.controller.controller_ordinazione;

import it.unicam.cs.ids_progetto_casotto.model.ordinazione.Consumazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RepositoryConsumazioni extends JpaRepository<Consumazione, Integer> {
}

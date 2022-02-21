package it.unicam.cs.ids_progetto_casotto.controller.controller_ordinazione;

import it.unicam.cs.ids_progetto_casotto.model.ordinazione.Comanda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryOrdinazioni extends JpaRepository<Comanda, Integer> {
}

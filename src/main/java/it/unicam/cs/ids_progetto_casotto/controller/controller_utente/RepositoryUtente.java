package it.unicam.cs.ids_progetto_casotto.controller.controller_utente;

import it.unicam.cs.ids_progetto_casotto.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryUtente extends JpaRepository<Cliente, Integer> {
}

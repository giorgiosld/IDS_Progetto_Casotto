package it.unicam.cs.ids_progetto_casotto.controller.controller_utenza;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryPrenotazioneUtenza extends JpaRepository<PrenotazioneUtenzaCliente, Integer> {
}

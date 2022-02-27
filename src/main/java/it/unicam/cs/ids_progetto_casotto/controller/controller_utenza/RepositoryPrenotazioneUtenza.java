package it.unicam.cs.ids_progetto_casotto.controller.controller_utenza;

import it.unicam.cs.ids_progetto_casotto.model.utenza.PrenotazioneUtenza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositoryPrenotazioneUtenza extends JpaRepository<PrenotazioneUtenza,Integer> {

    List<PrenotazioneUtenza> findPrenotazioneUtenzaByUtenzaId(Integer id);

    List<PrenotazioneUtenza> findPrenotazioneUtenzaByUserId(Integer id);
}

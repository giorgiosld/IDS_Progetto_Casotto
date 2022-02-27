package it.unicam.cs.ids_progetto_casotto.controller.controller_utenza;

import it.unicam.cs.ids_progetto_casotto.model.utenza.PeriodoDisponibilita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface RepositoryPeriodo extends JpaRepository<PeriodoDisponibilita, Integer> {

    List<PeriodoDisponibilita> findByUtenze(Integer id);

    List<PeriodoDisponibilita> findByGiorno(LocalDate giorno);

    PeriodoDisponibilita findByGiornoAndFasciaOraria(LocalDate giorno, String fasciaOraria);
}

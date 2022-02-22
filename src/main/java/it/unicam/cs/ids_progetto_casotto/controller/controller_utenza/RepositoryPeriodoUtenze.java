package it.unicam.cs.ids_progetto_casotto.controller.controller_utenza;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositoryPeriodoUtenze extends JpaRepository<PeriodoUtenze,Integer> {

    List<PeriodoUtenze> findPeriodoByUtenzaId(Integer id);
}

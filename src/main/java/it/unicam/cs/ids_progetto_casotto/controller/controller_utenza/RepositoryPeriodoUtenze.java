package it.unicam.cs.ids_progetto_casotto.controller.controller_utenza;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositoryPeriodoUtenze extends JpaRepository<PeriodoUtenze,Integer> {

    @Query("SELECT p FROM PeriodoUtenze p WHERE p.id = ?1")
    List<PeriodoUtenze> findPeriodoByUtenzaId(Integer id);
}

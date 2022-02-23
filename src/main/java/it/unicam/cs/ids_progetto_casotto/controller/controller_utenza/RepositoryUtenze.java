package it.unicam.cs.ids_progetto_casotto.controller.controller_utenza;

import it.unicam.cs.ids_progetto_casotto.model.utenza.Utenza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositoryUtenze extends JpaRepository<Utenza,Integer> {

//    @Query("SELECT u FROM Utenza u WHERE u.id = ?1")
//    List<Utenza> findUtenzaByPeriodoId(Integer id);
}

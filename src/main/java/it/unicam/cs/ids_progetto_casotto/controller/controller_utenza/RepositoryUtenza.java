package it.unicam.cs.ids_progetto_casotto.controller.controller_utenza;

import it.unicam.cs.ids_progetto_casotto.model.utenza.Utenza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositoryUtenza extends JpaRepository<Utenza, Integer> {

    List<Utenza> findUtenzasByPeriodiId(Integer id);


}

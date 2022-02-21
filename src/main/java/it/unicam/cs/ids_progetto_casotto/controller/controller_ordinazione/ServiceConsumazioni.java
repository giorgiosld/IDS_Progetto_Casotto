package it.unicam.cs.ids_progetto_casotto.controller.controller_ordinazione;

import it.unicam.cs.ids_progetto_casotto.model.ordinazione.Consumazione;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceConsumazioni {

        private RepositoryConsumazioni repositoryConsumazioni;

        @Autowired
        public ServiceConsumazioni(RepositoryConsumazioni repositoryOrdinazione){
            this.repositoryConsumazioni = repositoryOrdinazione;
        }

        public List<Consumazione> getAll(){
            return repositoryConsumazioni.findAll();
        }

        public Optional<Consumazione> addConsumazione(Consumazione consumazione){
            if((consumazione.getNome().isEmpty()) || (consumazione.getPrezzo() == 0))
                return Optional.empty();
            return Optional.of(repositoryConsumazioni.save(consumazione));
        }
}

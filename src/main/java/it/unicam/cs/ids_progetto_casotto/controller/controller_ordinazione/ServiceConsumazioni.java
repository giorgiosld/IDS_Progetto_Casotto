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

        public Optional<Consumazione> getOne(Integer id){
            Optional<Consumazione> toGet = this.repositoryConsumazioni.findById(id);
            if(toGet.isEmpty())
                return Optional.empty();
            return toGet;
        }

        public Optional<Consumazione> addConsumazione(Consumazione consumazione){
            if((consumazione.getNome().isEmpty()) || (consumazione.getPrezzo() == 0))
                return Optional.empty();
            return Optional.of(repositoryConsumazioni.save(consumazione));
        }

        public Optional<Consumazione> removeConsumazione(Integer id){
            Optional<Consumazione> toRemove = this.repositoryConsumazioni.findById(id);
            if(toRemove.isEmpty())
                return Optional.empty();
            this.repositoryConsumazioni.deleteById(id);
            return toRemove;
        }

        public Optional<Consumazione> updateConsumazione(Integer id, Consumazione consumazione){
            if((consumazione.getNome().isEmpty()) || (consumazione.getPrezzo() == 0))
                return Optional.empty();
            Consumazione toUpdate = this.repositoryConsumazioni.getById(id);
            toUpdate.setNome(consumazione.getNome());
            toUpdate.setPrezzo(consumazione.getPrezzo());
            return Optional.of(this.repositoryConsumazioni.save(toUpdate));
        }
}


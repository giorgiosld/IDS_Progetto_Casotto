package it.unicam.cs.ids_progetto_casotto.controller.controller_utenza;

import it.unicam.cs.ids_progetto_casotto.model.utenza.Tipo;
import it.unicam.cs.ids_progetto_casotto.model.utenza.Utenza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ServiceUtenza {

    private RepositoryUtenze repositoryUtenze;


    public ServiceUtenza(RepositoryUtenze repositoryUtenze) {
        this.repositoryUtenze = repositoryUtenze;
    }

    public List<Utenza> getAllUtenze() { return this.repositoryUtenze.findAll(); }

    public Optional<Utenza> getUtenzaById(Integer id) { return this.repositoryUtenze.findById(id); }

    public Optional<Utenza> createUtenza(Utenza utenza) {
        return Optional.of(this.repositoryUtenze.save(utenza));
    }

    public Optional<Utenza> removeUtenza(Integer id){
        Optional<Utenza> toRemove = this.repositoryUtenze.findById(id);
        if(toRemove.isEmpty())
            return Optional.empty();
        this.repositoryUtenze.deleteById(id);
        return toRemove;
    }


}

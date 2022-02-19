package it.unicam.cs.ids_progetto_casotto.controller.controller_ordinazione;

import it.unicam.cs.ids_progetto_casotto.model.ordinazione.Comanda;
import it.unicam.cs.ids_progetto_casotto.model.ordinazione.Consumazione;
import it.unicam.cs.ids_progetto_casotto.model.ordinazione.StatoComanda;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ServiceOrdinazioni {

    private RepositoryOrdinazioni repositoryOrdinazioni;

    public ServiceOrdinazioni(RepositoryOrdinazioni repositoryOrdinazioni){
        this.repositoryOrdinazioni = repositoryOrdinazioni;
    }

    Optional<Comanda> ordinaConsumazioni(List<Consumazione> consumazioni, int idUtenza){

        return null;
    }

    Optional<Comanda> getComanda(UUID id){
        return null;
    }

    List<Comanda> getAll(){
        return this.repositoryOrdinazioni.findAll();
    }

    StatoComanda getStatus(UUID id){
        return null;
    }

    void setStatus(UUID id, StatoComanda nuovoStato){

    }

}
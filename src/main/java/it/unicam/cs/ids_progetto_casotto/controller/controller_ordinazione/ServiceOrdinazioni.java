package it.unicam.cs.ids_progetto_casotto.controller.controller_ordinazione;

import it.unicam.cs.ids_progetto_casotto.model.ordinazione.Comanda;
import it.unicam.cs.ids_progetto_casotto.model.ordinazione.Consumazione;
import it.unicam.cs.ids_progetto_casotto.model.ordinazione.StatoComanda;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.persistence.criteria.CriteriaBuilder;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ServiceOrdinazioni {

    private RepositoryOrdinazioni repositoryOrdinazioni;

    public ServiceOrdinazioni(RepositoryOrdinazioni repositoryOrdinazioni){
        this.repositoryOrdinazioni = repositoryOrdinazioni;
    }

    //Optional<Comanda> ordinaConsumazioni(List<Consumazione> consumazioni, int idUtenza){
    Optional<Comanda> ordinaConsumazioni(List<Consumazione> consumazioni){
        if (consumazioni == null) { Optional.empty(); }
        //add controllo utenza
        double prezzoTot = consumazioni.stream()
                .mapToDouble(Consumazione::getPrezzo)
                .sum();
        Comanda nuovaComanda = new Comanda();
        nuovaComanda.setConsumazioni(consumazioni);
        nuovaComanda.setPrezzoTotale(prezzoTot);
        return Optional.of(repositoryOrdinazioni.save(nuovaComanda));

    }

    Optional<Comanda> getComanda(Integer id){
        return null;
    }

    List<Comanda> getAll(){
        return this.repositoryOrdinazioni.findAll();
    }

    StatoComanda getStatus(Integer id){
        return null;
    }

    void setStatus(Integer id, StatoComanda nuovoStato){

    }

}

package it.unicam.cs.ids_progetto_casotto.controller.controller_ordinazione;

import it.unicam.cs.ids_progetto_casotto.controller.controller_utenza.RepositoryUtenza;
import it.unicam.cs.ids_progetto_casotto.model.ordinazione.Comanda;
import it.unicam.cs.ids_progetto_casotto.model.ordinazione.Consumazione;
import it.unicam.cs.ids_progetto_casotto.model.ordinazione.StatoComanda;
import it.unicam.cs.ids_progetto_casotto.model.utenza.Utenza;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ServiceOrdinazioni {

    private Integer idComanda = 1;
    private RepositoryOrdinazioni repositoryOrdinazioni;
    private RepositoryUtenza repositoryUtenza;

    public ServiceOrdinazioni(RepositoryOrdinazioni repositoryOrdinazioni, RepositoryUtenza repositoryUtenza){
        this.repositoryOrdinazioni = repositoryOrdinazioni;
        this.repositoryUtenza = repositoryUtenza;
    }

    Optional<Comanda> ordinaConsumazioni(Set<Consumazione> consumazioni, Integer idUtenza){
    //public Optional<Comanda> ordinaConsumazioni(Set<Consumazione> consumazioni){
        if (consumazioni == null) { Optional.empty(); }
        if(this.repositoryUtenza.existsById(idUtenza))
            Optional.empty();
        double prezzoTot = consumazioni.stream()
                .mapToDouble(Consumazione::getPrezzo)
                .sum();
        Comanda nuovaComanda = new Comanda();
        nuovaComanda.setIdComanda(idComanda++);
        nuovaComanda.setConsumazioni(consumazioni);
        nuovaComanda.setPrezzoTotale(prezzoTot);
        this.repositoryOrdinazioni.save(nuovaComanda);
        return Optional.of(nuovaComanda);
    }

    public Optional<Comanda> getComanda(Integer id){
        Optional<Comanda> toGet = this.repositoryOrdinazioni.findById(id);
        if(toGet.isEmpty())
            return Optional.empty();
        return toGet;
    }

    public List<Comanda> getAll(){
        return this.repositoryOrdinazioni.findAll();
    }

    public StatoComanda getStatus(Integer id){
        Comanda comanda = this.repositoryOrdinazioni.getById(id);
        return comanda.getStatoComanda();
    }

    public StatoComanda setStatus(Integer id, StatoComanda nuovoStato){
        Comanda comanda = this.repositoryOrdinazioni.getById(id);
        comanda.setStatoComanda(nuovoStato);
        System.out.println(comanda.getStatoComanda());
        this.repositoryOrdinazioni.save(comanda);
        Comanda toGet = this.repositoryOrdinazioni.getById(id);
        return toGet.getStatoComanda();
    }

}

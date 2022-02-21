package it.unicam.cs.ids_progetto_casotto.controller.controller_ordinazione;

import it.unicam.cs.ids_progetto_casotto.model.ordinazione.Comanda;
import it.unicam.cs.ids_progetto_casotto.model.ordinazione.Consumazione;
import it.unicam.cs.ids_progetto_casotto.model.ordinazione.StatoComanda;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceOrdinazioni {

    private RepositoryOrdinazioni repositoryOrdinazioni;

    public ServiceOrdinazioni(RepositoryOrdinazioni repositoryOrdinazioni){
        this.repositoryOrdinazioni = repositoryOrdinazioni;
    }

    //Optional<Comanda> ordinaConsumazioni(List<Consumazione> consumazioni, int idUtenza){
    public Optional<Comanda> ordinaConsumazioni(List<Consumazione> consumazioni){
        //TODO finire una volta creato serviceUtenza
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

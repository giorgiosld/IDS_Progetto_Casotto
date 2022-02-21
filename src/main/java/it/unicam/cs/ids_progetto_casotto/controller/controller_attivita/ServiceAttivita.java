package it.unicam.cs.ids_progetto_casotto.controller.controller_attivita;

import it.unicam.cs.ids_progetto_casotto.model.attivita.Attivita;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceAttivita {


    private RepositoryAttivita repositoryAttivita;

    public ServiceAttivita(RepositoryAttivita repositoryAttivita){
        this.repositoryAttivita=repositoryAttivita;
    }

    public List<Attivita> getAll(){
        return this.repositoryAttivita.findAll();
    }

    public int getNPosti(Attivita attivita){
        return this.repositoryAttivita.

    }


}

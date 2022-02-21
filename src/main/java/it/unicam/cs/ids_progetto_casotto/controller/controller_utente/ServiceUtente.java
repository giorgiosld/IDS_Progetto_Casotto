package it.unicam.cs.ids_progetto_casotto.controller.controller_utente;

import it.unicam.cs.ids_progetto_casotto.model.Cliente;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceUtente {

    private RepositoryUtente repositoryUtente;

    public List<Cliente> getAll(){
        return this.repositoryUtente.findAll();
    }
}

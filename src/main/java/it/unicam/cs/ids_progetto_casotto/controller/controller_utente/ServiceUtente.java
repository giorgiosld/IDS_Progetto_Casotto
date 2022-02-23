package it.unicam.cs.ids_progetto_casotto.controller.controller_utente;

import it.unicam.cs.ids_progetto_casotto.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceUtente {

    private RepositoryUtente repositoryUtente;

    public ServiceUtente(RepositoryUtente repositoryUtente){
        this.repositoryUtente = repositoryUtente;
    }

    public List<User> getAll(){
        return this.repositoryUtente.findAll();
    }

    public Optional<User> getOne(Integer id){
        Optional<User> toGet = this.repositoryUtente.findById(id);
        if(toGet.isEmpty()){
            return Optional.empty();
        }
        return toGet;
    }
    public Optional<User> addCliente(User cliente){
        if((cliente.getNomeUtente().isEmpty())||(cliente.getCognomeUtente().isEmpty())||(cliente.getEmail().isEmpty())){
            return Optional.empty();
        }
        return Optional.of(this.repositoryUtente.save(cliente));
    }

    public Optional<User> removeCliente(Integer id){
        Optional<User> toRemove = this.repositoryUtente.findById(id);
        if(toRemove.isEmpty()){
            return Optional.empty();
        }
        this.repositoryUtente.deleteById(id);
        return toRemove;
    }
    public Optional<User> updateCliente(Integer id, User cliente){
        if((cliente.getNomeUtente().isEmpty()) || (cliente.getCognomeUtente().isEmpty()) || (cliente.getEmail().isEmpty())){
            return Optional.empty();
        }
        User toUpdate = this.repositoryUtente.getById(id);
        toUpdate.setNome(cliente.getNomeUtente());
        toUpdate.setCognome(cliente.getCognomeUtente());
        toUpdate.setEmail(cliente.getEmail());
        return Optional.of(this.repositoryUtente.save(toUpdate));
    }
}

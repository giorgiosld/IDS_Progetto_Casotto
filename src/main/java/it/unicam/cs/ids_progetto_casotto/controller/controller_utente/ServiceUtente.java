package it.unicam.cs.ids_progetto_casotto.controller.controller_utente;

import it.unicam.cs.ids_progetto_casotto.model.Cliente;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceUtente {

    private RepositoryUtente repositoryUtente;

    public ServiceUtente(RepositoryUtente repositoryUtente){
        this.repositoryUtente = repositoryUtente;
    }

    public List<Cliente> getAll(){
        return this.repositoryUtente.findAll();
    }

    public Optional<Cliente> getOne(Integer id){
        Optional<Cliente> toGet = this.repositoryUtente.findById(id);
        if(toGet.isEmpty()){
            return Optional.empty();
        }
        return toGet;
    }
    public Optional<Cliente> addCliente(Cliente cliente){
        if((cliente.getNomeUtente().isEmpty())||(cliente.getCognomeUtente().isEmpty())||(cliente.getEmail().isEmpty())){
            return Optional.empty();
        }
        return Optional.of(this.repositoryUtente.save(cliente));
    }

    public Optional<Cliente> removeCliente(Integer id){
        Optional<Cliente> toRemove = this.repositoryUtente.findById(id);
        if(toRemove.isEmpty()){
            return Optional.empty();
        }
        this.repositoryUtente.deleteById(id);
        return toRemove;
    }
    public Optional<Cliente> updateCliente(Integer id, Cliente cliente){
        if((cliente.getNomeUtente().isEmpty()) || (cliente.getCognomeUtente().isEmpty()) || (cliente.getEmail().isEmpty())){
            return Optional.empty();
        }
        Cliente toUpdate = this.repositoryUtente.getById(id);
        toUpdate.setNome(cliente.getNomeUtente());
        toUpdate.setCognome(cliente.getCognomeUtente());
        toUpdate.setEmail(cliente.getEmail());
        return Optional.of(this.repositoryUtente.save(toUpdate));
    }
}

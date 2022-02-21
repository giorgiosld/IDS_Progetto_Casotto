package it.unicam.cs.ids_progetto_casotto.controller.controller_utente;

import it.unicam.cs.ids_progetto_casotto.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

/**
 * Classe che implementa un controller per l'aggiunta di un qualsiasi utente
 */
@RestController
@RequestMapping("/user")
public class ControllerUtente implements IControllerUtente {

    @Autowired
    private ServiceUtente serviceUtente;


    @Override
    @GetMapping("/list")
    public List<Cliente> getClienti() {
        return this.serviceUtente.getAll();
    }

    @Override
    @GetMapping("/{id}")
    public Cliente getCliente(@PathVariable("id") Integer id) {
        Optional<Cliente> got = this.serviceUtente.getOne(id);
        return this.getClienteOrThrownException(got,HttpStatus.NOT_FOUND);
    }

    @Override
    @PostMapping("/register")
    public Cliente addCliente(@RequestBody Cliente cliente) {
        Optional<Cliente>added = this.serviceUtente.addCliente(cliente);
        return this.getClienteOrThrownException(added,HttpStatus.BAD_REQUEST);
    }

    @Override
    @DeleteMapping("/delete")
    public Cliente removeCliente(@RequestBody Integer id) {
        Optional<Cliente>removed = this.serviceUtente.removeCliente(id);
        return this.getClienteOrThrownException(removed,HttpStatus.BAD_REQUEST);
    }

    @Override
    @PutMapping("/update/{id}")
    public Cliente updateCliente(Integer id, Cliente cliente ) {
        Optional<Cliente> got = this.serviceUtente.getOne(id);
        if(got.isEmpty()){
            throw  new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        Optional<Cliente> updated =this.serviceUtente.updateCliente(id,cliente);
        return this.getClienteOrThrownException(updated,HttpStatus.BAD_REQUEST);
    }

    private Cliente getClienteOrThrownException(Optional<Cliente> cliente, HttpStatus status){
        if(cliente.isEmpty()){
            throw new ResponseStatusException(status);
        }
        return cliente.get();
    }
}


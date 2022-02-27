package it.unicam.cs.ids_progetto_casotto.controller.controller_utente;

import it.unicam.cs.ids_progetto_casotto.model.User;
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
    @GetMapping
    public List<User> getClienti() {
        return this.getClientiOrThrownException(this.serviceUtente.getAllUser(), HttpStatus.NOT_FOUND);
    }

    @Override
    @GetMapping("/{id}")
    public User getCliente(@PathVariable("id") Integer id) {
        return this.getClienteOrThrownException(this.serviceUtente.getUserById(id), HttpStatus.NOT_FOUND);
    }

    @GetMapping("/booking/{id}")
    public User getUserByPrenotazioneId(@PathVariable("id") Integer id) {
        return this.getClienteOrThrownException(this.serviceUtente.getUserByIdPrenotazione(id), HttpStatus.NOT_FOUND);
    }

    @Override
    @PostMapping("/register")
    public User addCliente(@RequestBody User cliente) {
        return this.getClienteOrThrownException(this.serviceUtente.addUserInRepo(cliente), HttpStatus.BAD_REQUEST);
    }

    @Override
    @DeleteMapping("/delete/{id}")
    public User removeCliente(@PathVariable("id") Integer id) {
        return this.getClienteOrThrownException(this.serviceUtente.removeUserInRepo(id), HttpStatus.NOT_FOUND);
    }

    private User getClienteOrThrownException(Optional<User> cliente, HttpStatus status){
        if(cliente.isEmpty()){
            throw new ResponseStatusException(status);
        }
        return cliente.get();
    }

    private List<User> getClientiOrThrownException(Optional<List<User>> user, HttpStatus status) {
        if (user.isEmpty())
            throw new ResponseStatusException(status);
        return user.get();
    }
}


package it.unicam.cs.ids_progetto_casotto.controller.controller_utente;

import it.unicam.cs.ids_progetto_casotto.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public Cliente getCliente(Integer id) {
        return null;
    }

    @Override
    @PostMapping("/register")
    public Cliente addCliente(Cliente cliente) {
        return null;
    }

    @Override
    @DeleteMapping("/delete")
    public Cliente removeCliente(Integer id) {
        return null;
    }

    @Override
    @PutMapping("/update")
    public Cliente updateCliente(Integer id) {
        return null;
    }
}

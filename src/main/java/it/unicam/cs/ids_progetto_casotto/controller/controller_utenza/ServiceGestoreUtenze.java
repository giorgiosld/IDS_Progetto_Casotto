package it.unicam.cs.ids_progetto_casotto.controller.controller_utenza;

import it.unicam.cs.ids_progetto_casotto.model.utenza.Tipo;
import it.unicam.cs.ids_progetto_casotto.model.utenza.Utenza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceGestoreUtenze {

    private RepositoryUtenze repositoryUtenze;

    @Autowired
    public ServiceGestoreUtenze(RepositoryUtenze repositoryUtenze) {
        this.repositoryUtenze = repositoryUtenze;
    }

    public List<Utenza> getAll() { return this.repositoryUtenze.findAll(); }

    public Optional<Utenza> addUtenza(Tipo utenza) {
        Utenza utenza1 = new Utenza();
        utenza1.setTipo(utenza);
        if (utenza == Tipo.LETTINO) {
            utenza1.setNumeroPostiOccupabili(1);
            this.repositoryUtenze.save(utenza1);
        } else if (utenza == Tipo.OMBRELLONE) {
            utenza1.setNumeroPostiOccupabili(4);
            this.repositoryUtenze.save(utenza1);
        } else if (utenza == Tipo.SDRAIO) {
            utenza1.setNumeroPostiOccupabili(1);
            this.repositoryUtenze.save(utenza1);
        }
        return Optional.of(utenza1);
    }

    public Optional<Utenza> removeUtenza(Integer id) {
        Optional<Utenza> toRemove = this.repositoryUtenze.findById(id);
        if (toRemove.isEmpty()) {
            return Optional.empty();
        }
        this.repositoryUtenze.deleteById(id);
        return toRemove;
    }
}

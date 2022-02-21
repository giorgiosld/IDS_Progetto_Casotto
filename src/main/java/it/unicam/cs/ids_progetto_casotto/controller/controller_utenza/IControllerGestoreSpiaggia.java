package it.unicam.cs.ids_progetto_casotto.controller.controller_utenza;

import it.unicam.cs.ids_progetto_casotto.model.utenza.Tipo;
import it.unicam.cs.ids_progetto_casotto.model.utenza.Utenza;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * Interfaccia che definisce dei metodi generici di un gestore Spiaggia
 */
public interface IControllerGestoreSpiaggia {

    /**
     * restituisce la lista delle utenze del Casotto
     *
     * @return la lisat delle utenze del Casotto
     */
    List<Utenza> getUtenze();

    @PostMapping("/addutenza")
    Utenza addUtenza(@RequestBody Tipo utenza);

    /**
     * metodo che elimina un'utenza
     * @param id l'utenza da eliminare
     * @return true o false se l'operazione ha avuto successo
     */
    @DeleteMapping("/removeutenza{id}")
    Utenza removeUtenza(@PathVariable("id") Integer id);
}

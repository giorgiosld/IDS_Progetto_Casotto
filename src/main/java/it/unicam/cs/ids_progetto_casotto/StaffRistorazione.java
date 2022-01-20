package it.unicam.cs.ids_progetto_casotto;

import java.util.List;
import java.util.Optional;

/**
 * Classe astratta che rappresenta un membro dello staff ristorazione
 */
public abstract class StaffRistorazione extends Staff {




    public StaffRistorazione(String nome, String cognome){
        super(nome, cognome);
    }


    /**
     * Ritorna un ordinazione usando l'id della comanda cercata
     *
     * @param comanda necessaria per estrapolare l'id da cui cercare
     * @param controller controller contenente le varie ordinazioni
     * @return l'ordinazione cercata
     */
    public Comanda getComanda(Comanda comanda, ControllerOrdinazione controller){
        int idToSearch = comanda.getIdComanda();
        List<Comanda> comande;
        comande = controller.getComande();
        Optional<Comanda> toFind = comande.stream()
                .filter(z -> z.getIdComanda() == idToSearch)
                .findFirst();
        Comanda comandaFinded = toFind.get();
        return comandaFinded;
    }

    /**
     * Ritorna tutte le ordinazioni presenti nel controller
     *
     * @param controller controller contenente le ordinazioni
     * @return una lista contenente le ordinazioni effettuatate
     */
    public List<Comanda> getComande(ControllerOrdinazione controller){
        List<Comanda> comande = controller.getComande();
        return comande;
    }

}

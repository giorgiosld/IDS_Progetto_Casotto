package it.unicam.cs.ids_progetto_casotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class StaffRistorazione {

    protected String nome;
    protected int idStaff;
    //arraylist di membri

    public StaffRistorazione(String nome, int idStaff){
        this.nome = nome;
        this.idStaff = idStaff;
    }

    public String getNome() {
        return nome;
    }

    public int getIdStaff() {
        return idStaff;
    }

    /**
     * Ritorna un ordinazione usando l'id della comanda cercata
     *
     * @param comanda necessaria per estrapolare l'id da cui cercare
     * @param controller controller contenente le varie ordinazioni
     * @return l'ordinazione cercata
     */
    public Comanda getOrdinazione(Comanda comanda, ControllerOrdinazione controller){
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
    public List<Comanda> getOrdinazioni(ControllerOrdinazione controller){
        List<Comanda> comande = controller.getComande();
        return comande;
    }

    //forse inutile
    public String getNotify(ControllerOrdinazione controllerOrdinazione){
        Comanda comanda = controllerOrdinazione.getLastComanda();
        return controllerOrdinazione.notificaStaff(comanda);
    }
}

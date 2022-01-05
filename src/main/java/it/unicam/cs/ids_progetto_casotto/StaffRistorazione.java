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

    //inteso come tutte le ordinazioni?
    public Comanda getOrdinazione(Comanda comanda, ControllerOrdinazione controller){
        int idToSearch = comanda.getIdComanda();
        List<Comanda> comande = new ArrayList<>();
        comande = controller.getComande();
        Optional<Comanda> toFind = comande.stream()
                .filter(z -> z.getIdComanda() == idToSearch)
                .findFirst();
        Comanda comandaFinded = toFind.get();
        return comandaFinded;
    }

    //se inteso come tutte le ordinazioni canc Comanda comanda
    public List<Comanda> getOrdinazioni(ControllerOrdinazione controller){
        List<Comanda> comande = controller.getComande();
        return comande;
    }

    public String getNotify(ControllerOrdinazione controllerOrdinazione){
        Comanda comanda = controllerOrdinazione.getLastComanda();
        return controllerOrdinazione.notificaStaff(comanda);
    }
}

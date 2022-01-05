package it.unicam.cs.ids_progetto_casotto;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public abstract class StaffRistorazione {

    protected String nome;
    protected int idStaff;

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

    //se inteso come tutte le ordinazioni
    public List<Comanda> getOrdinazioni(Comanda comanda, ControllerOrdinazione controller){
        List<Comanda> comande = controller.getComande();
        return comande;
    }

}

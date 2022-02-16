package it.unicam.cs.ids_progetto_casotto.model;

import it.unicam.cs.ids_progetto_casotto.controller.ControllerUtenze;

import java.util.List;
import java.util.stream.Collectors;

public class Receptionist extends Staff{
    private String cognome;
    private int idReceptionist;

    public Receptionist(String nome,String cognome,int idReceptionist){
        super(nome);
        this.cognome=cognome;
        this.idReceptionist=idReceptionist;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public int getId() {
        return idReceptionist;
    }

    public List<Utenza> visualizzaPrenotazioni(ControllerUtenze controller){ //lista fai tornare stringa
      return controller.getUtenze()
               .stream()
               .filter(x -> x.getDisponibilita() == false)
               .collect(Collectors.toList());
    }
}

package it.unicam.cs.ids_progetto_casotto;

import java.util.List;
import java.util.stream.Collectors;

public class Receptionist {
    private String nome;
    private String cognome;
    private int id;

    public Receptionist(String nome,String cognome,int id){
        this.nome=nome;
        this.cognome=cognome;
        this.id=id;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public int getId() {
        return id;
    }

    public List<UtenzaSpiaggia> visualizzaPrenotazioni(ControllerUtenze controller){ //lista fai tornare stringa
      return controller.getUtenze()
               .stream()
               .filter(x -> x.getDisponibilita() == false)
              .collect(Collectors.toList());
    }
}

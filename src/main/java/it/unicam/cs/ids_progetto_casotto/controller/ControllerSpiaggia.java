package it.unicam.cs.ids_progetto_casotto.controller;

import it.unicam.cs.ids_progetto_casotto.model.Cliente;
import it.unicam.cs.ids_progetto_casotto.model.Tariffa;
import it.unicam.cs.ids_progetto_casotto.model.Utenza;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Optional;

public class ControllerSpiaggia  implements HandlerDatiUtente{

    //lista utenze
    List<Utenza>utenze;
    List<GregorianCalendar> periodi;

    public ControllerSpiaggia(List<Utenza> utenze) {
        this.utenze = utenze;
        this.periodi = new ArrayList<>();
    }


    public List<GregorianCalendar> getPeriodi() {
        return periodi;
    }

  public String getNomeUtente(Cliente cliente){
      return cliente.getNome();
  }
    public String getCognomeUtente(Cliente cliente){
        return cliente.getCognome();
    }
    public int getEta(Cliente cliente){
      return cliente.getEta();
    }
    public char getSesso(Cliente cliente){
        return cliente.getSesso();
    }
    public Tariffa getTariffa(){
      return null;
    }

    public List<Utenza> getUtenze(){

      return utenze;

    }

    public Optional<Utenza> prenotaUtenza(int idUtenza, int idTariffa){
        return null;
    }

    public void setdisponibilitàUtenza(Utenza utenza, boolean disponibilita){

        utenza.setDisponibilita(disponibilita);

    }

    public void notificaReceptionist(){

    }//produttore consumatore o flags?
    //quando prenota manda notifica

    //getçPeriodi

    //prenotaUtenza

    //
}

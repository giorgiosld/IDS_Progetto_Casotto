package it.unicam.cs.ids_progetto_casotto;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Optional;

public class ControllerUtenze  implements HandlerDatiUtente{

    //lista utenze
    List<UtenzaSpiaggia>utenze;
    List<GregorianCalendar> periodi;

    public ControllerUtenze(List<UtenzaSpiaggia> utenze) {
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

    public List<UtenzaSpiaggia> getUtenze(){

      return utenze;

    }

    public Optional<UtenzaSpiaggia> prenotaUtenza(int idUtenza, int idTariffa){
        return null;
    }

    public void setdisponibilitàUtenza(UtenzaSpiaggia utenza, boolean disponibilita){

        utenza.setDisponibilita(disponibilita);

    }

    public void notificaReceptionist(){

    }//produttore consumatore o flags?
    //quando prenota manda notifica
}

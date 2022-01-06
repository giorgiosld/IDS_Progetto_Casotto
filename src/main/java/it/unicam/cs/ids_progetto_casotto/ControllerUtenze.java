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

  public String getNomeUtente(//oggettocliente){
      return prova;
  }
    public String getCognomeUtente(){
        return prova;
    }
    public int getEta(){
      return 0;
    }
    public String getSesso(){
        return prova;
    }
    public double getTariffa(){
      return 0;
    }

    public List<UtenzaSpiaggia> getUtenze(){ //solo  o tutte

      return utenze;

    }

    public Optional<UtenzaSpiaggia> prenotaUtenza(int idUtenza, int idTariffa){
        return null;
    }

    public void setdisponibilitàUtenza(UtenzaSpiaggia utenza, boolean disponibilita){

        utenza.setDisponibilita(disponibilita);

    }

    public notificaReceptionist(){}//produttore consumatore o flags?
    //quando prenota manda notifica
}

package it.unicam.cs.ids_progetto_casotto;


import java.util.List;

public class ControllerUtenze  implements HandlerDatiUtente{

    //lista utenze
    List<UtenzaSpiaggia>utenze;

    public ControllerUtenze(List<UtenzaSpiaggia> utenze) {
        this.utenze = utenze;
    }

    //
 String prova ;


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

    public prenotaUtenza(UtenzaSpiaggia utenza){

    }

    public void setdisponibilitàUtenza(UtenzaSpiaggia utenza, boolean disponibilita){

        utenza.setDisponibilita(disponibilita);

    }

    public notificaReceptionist(){}//produttore consumatore o flags?
    //quando prenota manda notifica
}

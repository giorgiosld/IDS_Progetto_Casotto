package it.unicam.cs.ids_progetto_casotto;

import javax.websocket.ClientEndpoint;
import java.util.List;

public class ControllerUtenze extends Cliente implements HandlerDatiUtente{
//probabilmente Utenze dovrà estendere la classe cliente
 String prova ;


  public String getNomeUtente(){
      return prova ;
  }
    public String getCognomeUtente(){
        return prova
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

    public List<UtenzaSpiaggia> getUtenze(){ //solo quelle libere o tutte

      List<UtenzaSpiaggia>utenze=

    }

    public prenotaUtenza(UtenzaSpiaggia utenza){

    }

    public setdisponibilitàUtenza(){

    }

    public notificaReceptionist(){}//produttore consumatore o flags?

}

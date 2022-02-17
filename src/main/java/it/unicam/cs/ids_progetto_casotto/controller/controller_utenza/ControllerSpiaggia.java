package it.unicam.cs.ids_progetto_casotto.controller.controller_utenza;

import it.unicam.cs.ids_progetto_casotto.model.*;
import it.unicam.cs.ids_progetto_casotto.model.utenza.*;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public class ControllerSpiaggia  implements IControllerClienteSpiaggia {

    //lista utenze
    List<Utenza>utenze;
    List<Tariffa> tariffe;

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



    @Override
    public List<Utenza> getUtenze(Periodo periodi) {

    }

    @Override
    public List<Utenza> getUtenze(Periodo periodi, FasciaOraria fasciaOraria) {
        return null;
    }

    @Override
    public List<Tariffa> getTariffe() {
        return null;
    }

    @Override
    public boolean inviaPrenotazioneCliente(IControllerPrenotazioniUtenzeClienti receptionist, int idUtenza, int idCliente, Tariffa tariffa, Periodo permanenza) {
        return false;
    }

    @Override
    public boolean eliminaPrenotazione(IControllerPrenotazioniUtenzeClienti receptionist, PrenotazioneUtenza prenotazione) {
        return false;
    }

   /* public Optional<Utenza> prenotaUtenza(int idUtenza, int idTariffa){
        return null;
    }

    public void setdisponibilitàUtenza(Utenza utenza, boolean disponibilita){

        utenza.setDisponibilita(disponibilita);

    }
*/
   /*public List<Utenza> getUtenze(){

       return utenze;

   }

    */

}

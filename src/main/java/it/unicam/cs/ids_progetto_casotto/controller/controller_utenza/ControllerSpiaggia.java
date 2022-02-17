package it.unicam.cs.ids_progetto_casotto.controller.controller_utenza;

import it.unicam.cs.ids_progetto_casotto.model.*;
import it.unicam.cs.ids_progetto_casotto.model.utenza.*;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public class ControllerSpiaggia  implements IControllerGestoreSpiaggia,IControllerClienteSpiaggia {

    //lista utenze
    List<Utenza>utenze;
    List<Tariffa> tariffe;

    public ControllerSpiaggia(List<Utenza> utenze) {
        this.utenze = new ArrayList<>();
        this.tariffe = new ArrayList<>();
    }

    @Override
    public List<Utenza> getUtenze() {
        return this.utenze;
    }

    @Override
    public boolean aggiungiUtenza(Utenza utenza) {
        this.utenze.add(utenza);
        return true;
    }

    @Override
    public boolean eliminaUtenza(Utenza utenza) {

        this.utenze.remove(utenza);
        return true;
    }

    @Override
    public List<Utenza> getUtenze(Periodo periodi) {
        return null;
    }

    @Override
    public List<Utenza> getUtenze(Periodo periodi, FasciaOraria fasciaOraria) {
        return null;
    }

    @Override
    public List<Tariffa> getTariffe() {
        return this.tariffe;
    }

    @Override
    public boolean creaPrenotazioneCliente(IHandlerPrenotazioniUtenzeClienti receptionist, int idUtenza, int idCliente, Tariffa tariffa, Periodo permanenza) {

        return false;
    }

    @Override
    public boolean eliminaPrenotazione(IHandlerPrenotazioniUtenzeClienti receptionist, PrenotazioneUtenza prenotazione) {
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

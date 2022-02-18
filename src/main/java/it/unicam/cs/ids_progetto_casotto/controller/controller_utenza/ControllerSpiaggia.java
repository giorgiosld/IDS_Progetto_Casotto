package it.unicam.cs.ids_progetto_casotto.controller.controller_utenza;

import it.unicam.cs.ids_progetto_casotto.model.Receptionist;
import it.unicam.cs.ids_progetto_casotto.model.utenza.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe che permette di gestire
 * le utenze
 */
public class ControllerSpiaggia  implements IControllerGestoreSpiaggia,IControllerClienteSpiaggia {

    private final List<Utenza>utenze;
    private final List<Tariffa> tariffe;

    public ControllerSpiaggia() {
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
    public boolean creaPrenotazioneCliente(IHandlerPrenotazioniUtenzeClienti receptionist, int idCliente, Periodo permanenzaUtenza, Utenza utenza, Tariffa tariffa) {
        LocalDate t1 = LocalDate.now();
        String str = t1.toString();
        PrenotazioneUtenzaCliente prenotazioneUtenzaCliente = new PrenotazioneUtenzaCliente(idCliente, permanenzaUtenza, utenza, tariffa, str);
        if (!receptionist.aggiungiPrenotazioneUtenza(prenotazioneUtenzaCliente)) {
            System.out.println("Prenotazione di: " + prenotazioneUtenzaCliente + " non effettuata!");
            return false;
        }
        receptionist.aggiungiPrenotazioneUtenza(prenotazioneUtenzaCliente);
        System.out.println("Prenotazione di: " + prenotazioneUtenzaCliente + " effettuata");
        return false;
    }

    @Override
    public boolean eliminaPrenotazione(IHandlerPrenotazioniUtenzeClienti receptionist, PrenotazioneUtenzaCliente prenotazione) {
        receptionist.eliminaPrenotazioneUtenza(prenotazione);
        return false;
    }

    private boolean checkRimborso(PrenotazioneUtenzaCliente prenotazioneUtenzaCliente) {

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

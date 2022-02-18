package it.unicam.cs.ids_progetto_casotto.controller.controller_utenza;

import it.unicam.cs.ids_progetto_casotto.model.utenza.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Classe che permette di gestire
 * le utenze
 */
public class ControllerSpiaggia  implements IControllerGestoreSpiaggia,IControllerClienteSpiaggia {

    private final List<Utenza>utenze;
    private final List<Tariffa> tariffe;
    private final HashMap<Periodo,List<Utenza>> listaUtenzeByPeriodo;

    public ControllerSpiaggia() {
        this.utenze = new ArrayList<>();
        this.tariffe = new ArrayList<>();
        this.listaUtenzeByPeriodo = new HashMap<>();
    }

    @Override
    public List<Utenza> getUtenze() {
        return this.utenze;
    }

    @Override
    public boolean aggiungiUtenza(Utenza utenza) {
        if (this.getUtenze().contains(utenza)) {
            System.out.println("L'utenza che si vuole aggiungere è già presente");
            return false;
        }
        System.out.println("Utenza aggiunta correttamente");
        this.utenze.add(utenza);
        return true;
    }

    @Override
    public boolean eliminaUtenza(Utenza utenza) {
        if (!this.getUtenze().contains(utenza)) {
            System.out.println("L'utenza che si vuole rimuovere non è presente");
        }
        System.out.println("Utenza rimossa correttamente");
        this.utenze.remove(utenza);
        return true;
    }

    @Override
    public List<Utenza> getUtenze(Periodo periodo) {
        if (periodo.checkGiorni()) {
        }
        return this.listaUtenzeByPeriodo.get(periodo);
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
        if (checkRimborso(prenotazione)) {
            System.out.println("Rimborso consentito!");
            return true;
        }
        System.out.println("Rimborso negato!");
        return false;
    }

    private boolean checkRimborso(PrenotazioneUtenzaCliente prenotazioneUtenzaCliente) {
        LocalDate dataCheckIn = prenotazioneUtenzaCliente.getPeriodoPermanenza().getCheckIn();
        LocalDate now = LocalDate.now();
        Period difference = Period.between(now,dataCheckIn);
        if (difference.getYears() == 0 || difference.getMonths() == 0 || difference.getDays() >= 2) {
            return true;
        }
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

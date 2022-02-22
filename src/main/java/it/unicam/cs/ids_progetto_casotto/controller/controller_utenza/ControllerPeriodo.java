package it.unicam.cs.ids_progetto_casotto.controller.controller_utenza;

import it.unicam.cs.ids_progetto_casotto.model.utenza.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;

/**
 * Classe che permette di gestire
 * le utenze
 */
@RestController
@RequestMapping("/spiaggia")
public class ControllerPeriodo implements IControllerGestoreSpiaggia,IControllerClienteSpiaggia {

    @Autowired
    private ServiceGestoreUtenze serviceGestoreUtenze;

    @Override
    public List<Utenza> getUtenze() {
        return this.serviceGestoreUtenze.getAll();
    }

    @PostMapping("/addutenza")
    @Override
    public Utenza addUtenza(@RequestBody Tipo utenza) {
        Optional<Utenza> added = this.serviceGestoreUtenze.addUtenza(utenza);
        return this.getUtenzaOrTrhownExecption(added, HttpStatus.BAD_REQUEST);
    }

    @Override
    @DeleteMapping("/removeutenza{id}")
    public Utenza removeUtenza(@PathVariable("id") Integer id) {
        Optional<Utenza> removed = this.serviceGestoreUtenze.removeUtenza(id);
        return this.getUtenzaOrTrhownExecption(removed,HttpStatus.NOT_FOUND);
    }

    private Utenza getUtenzaOrTrhownExecption(Optional<Utenza> utenza, HttpStatus status) {
        if (utenza.isEmpty()) {
            throw new ResponseStatusException(status);
        }
        return  utenza.get();
    }

    @Override
    public List<Utenza> getUtenze(Periodo periodo) {
        if (periodo.checkGiorni()) {
        }
        return null;
        //return this.listaUtenzeByPeriodo.get(periodo);
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

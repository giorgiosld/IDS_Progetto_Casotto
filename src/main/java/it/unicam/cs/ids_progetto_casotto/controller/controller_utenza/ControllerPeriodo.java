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
@RequestMapping("/periodo")
public class ControllerPeriodo {

    @Autowired
    private ServicePeriodoUtenze servicePeriodoUtenze;

    @GetMapping
    public List<PeriodoUtenze> getAllPeriodi() {
        return this.servicePeriodoUtenze.getAllPeriodi();
    }

    @GetMapping("/{id}")
    public PeriodoUtenze getPeriodoById(@PathVariable(value = "id") Integer id) {
        Optional<PeriodoUtenze> get = this.servicePeriodoUtenze.getPeriodoById(id);
        return this.getPeriodoOrTrhownExecption(get, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{day}")
    public PeriodoUtenze getPeriodoByDay(@PathVariable(value = "day") LocalDate day) {
        Optional<PeriodoUtenze> get = this.servicePeriodoUtenze.getPeriodoByDay(day);
        return this.getPeriodoOrTrhownExecption(get, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{fasciaOraria}")
    public List<PeriodoUtenze> getPeriodiByFasciaOraria(@PathVariable(value = "fasciaOraria") FasciaOrariaUtenze fasciaOrariaUtenze) {
        Optional<List<PeriodoUtenze>> periodi = this.servicePeriodoUtenze.getPeriodiByFasciaOraria(fasciaOrariaUtenze);
        return this.getPeriodiOrThrownExecption(periodi, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{idUtenza}")
    public List<PeriodoUtenze> getPeriodiByUtenza(@PathVariable(value = "idUtenza") Integer idUtenza) {
        Optional<List<PeriodoUtenze>> periodi = this.servicePeriodoUtenze.getPeriodiByUtenza(idUtenza);
        return this.getPeriodiOrThrownExecption(periodi, HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public PeriodoUtenze addPeriodo(@RequestBody PeriodoUtenze periodoUtenze) {
        Optional<PeriodoUtenze> added = this.servicePeriodoUtenze.createPeriodo(periodoUtenze);
        return this.getPeriodoOrTrhownExecption(added, HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/{id}")
    public PeriodoUtenze removePeriodo(@PathVariable(value = "id") Integer id) {
        Optional<PeriodoUtenze> removed = this.servicePeriodoUtenze.deletePeriodo(id);
        return this.getPeriodoOrTrhownExecption(removed, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping
    public List<PeriodoUtenze> removeAllPeriodi() {
        Optional<List<PeriodoUtenze>> removed = this.servicePeriodoUtenze.deleteAllPeriodi();
        return this.getPeriodiOrThrownExecption(removed, HttpStatus.NOT_FOUND);
    }

    private PeriodoUtenze getPeriodoOrTrhownExecption(Optional<PeriodoUtenze> periodo, HttpStatus status) {
        if (periodo.isEmpty()) {
            throw new ResponseStatusException(status);
        }
        return  periodo.get();
    }

//    @DeleteMapping("/{id}")
//    public Utenza removeUtenza(@PathVariable("id") Integer id) {
//        Optional<Utenza> removed = this.servicePeriodoUtenze.removeUtenza(id);
//        return this.getUtenzaOrTrhownExecption(removed,HttpStatus.NOT_FOUND);
//    }

    private List<PeriodoUtenze> getPeriodiOrThrownExecption(Optional<List<PeriodoUtenze>> periodi, HttpStatus status) {
        if (periodi.isEmpty()) {
            throw new ResponseStatusException(status);
        }
        return periodi.get();
    }

//    private Utenza getUtenzaOrTrhownExecption(Optional<Utenza> utenza, HttpStatus status) {
//        if (utenza.isEmpty()) {
//            throw new ResponseStatusException(status);
//        }
//        return  utenza.get();
//    }

//    public List<Utenza> getUtenze(Periodo periodo) {
//        if (periodo.checkGiorni()) {
//        }
//        return this.listaUtenzeByPeriodo.get(periodo);
//    }
//
//    public List<Utenza> getUtenze(Periodo periodi, FasciaOraria fasciaOraria) {
//        return null;
//    }
//
//    public List<Tariffa> getTariffe() {
//        return this.tariffe;
//    }

//    public boolean creaPrenotazioneCliente(IHandlerPrenotazioniUtenzeClienti receptionist, int idCliente, Periodo permanenzaUtenza, Utenza utenza, Tariffa tariffa) {
//        LocalDate t1 = LocalDate.now();
//        String str = t1.toString();
//        PrenotazioneUtenzaCliente prenotazioneUtenzaCliente = new PrenotazioneUtenzaCliente(idCliente, permanenzaUtenza, utenza, tariffa, str);
//        if (!receptionist.aggiungiPrenotazioneUtenza(prenotazioneUtenzaCliente)) {
//            System.out.println("Prenotazione di: " + prenotazioneUtenzaCliente + " non effettuata!");
//            return false;
//        }
//        receptionist.aggiungiPrenotazioneUtenza(prenotazioneUtenzaCliente);
//        System.out.println("Prenotazione di: " + prenotazioneUtenzaCliente + " effettuata");
//        return false;
//    }
//
//    public boolean eliminaPrenotazione(IHandlerPrenotazioniUtenzeClienti receptionist, PrenotazioneUtenzaCliente prenotazione) {
//        receptionist.eliminaPrenotazioneUtenza(prenotazione);
//        if (checkRimborso(prenotazione)) {
//            System.out.println("Rimborso consentito!");
//            return true;
//        }
//        System.out.println("Rimborso negato!");
//        return false;
//    }
//
//    private boolean checkRimborso(PrenotazioneUtenzaCliente prenotazioneUtenzaCliente) {
//        LocalDate dataCheckIn = prenotazioneUtenzaCliente.getPeriodoPermanenza().getCheckIn();
//        LocalDate now = LocalDate.now();
//        Period difference = Period.between(now,dataCheckIn);
//        if (difference.getYears() == 0 || difference.getMonths() == 0 || difference.getDays() >= 2) {
//            return true;
//        }
//        return false;
//    }

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

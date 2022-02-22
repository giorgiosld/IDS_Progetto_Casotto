package it.unicam.cs.ids_progetto_casotto.controller.controller_attivita;

import it.unicam.cs.ids_progetto_casotto.model.attivita.Attivita;
import it.unicam.cs.ids_progetto_casotto.model.attivita.IHandlerPrenotazioniAttivitaClienti;
import it.unicam.cs.ids_progetto_casotto.model.newsletter.IHandlerNewsletter;
import it.unicam.cs.ids_progetto_casotto.model.ordinazione.Consumazione;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Classe che permette di gestire
 * le attivit&agrave;
 */
@RestController
@RequestMapping("/bacheca")
public class ControllerAttivita implements IControllerClienteAttivita,IControllerGestoreAttivita {

   // private final List<Attivita> attivita;

   /* public ControllerAttivita() {
        this.attivita = new ArrayList<>();
    }

    */
    private ServiceAttivita serviceAttivita;
    //FATTO
    @Override
    @GetMapping("/Offerte")
    public List<Attivita> getAttivita() {
       // return this.attivita;
        return this.serviceAttivita.getAll();
    }

    @Override
    @GetMapping("/attivita{id}")
    public Attivita getSingolaAttivita(@PathVariable ("id")Integer id){
        Optional<Attivita> attivita = this.serviceAttivita.getAttivita(id);
        return this.getAttivitaOrThrownException(attivita, HttpStatus.NOT_FOUND);

    }


    //FATTO
    @Override
    @PostMapping
    public int getPostiDisponibili(@RequestBody Attivita attivita) {
       // return attivita.getPostiDisponibili();
        int postiDisponibili;
     postiDisponibili=this.serviceAttivita.getNPosti(attivita);
     return postiDisponibili;
    }

    @Override
    @PostMapping("/prenota{id}")
    public PrenotazioneAttivitaCliente creaPrenotazioneAttivitaCliente(IHandlerPrenotazioniAttivitaClienti receptionist, int idCliente, @PathVariable("id")Integer id) {
//         LocalDate t1 = LocalDate.now();
//        String str = t1.toString();
//        PrenotazioneAttivitaCliente prenotazioneAttivitaCliente = new PrenotazioneAttivitaCliente(idCliente, );
//        if (!receptionist.aggiungiPrenotazioneAttivita(prenotazioneAttivitaCliente)) {
//            System.out.println("Prenotazione di: " + prenotazioneAttivitaCliente + " non effettuata");
//            return null;
//
//
//        }
//        receptionist.aggiungiPrenotazioneAttivita(prenotazioneAttivitaCliente);
//        System.out.println("Prenotazione di: " + prenotazioneAttivitaCliente +" effettuata");
//        return null;
        PrenotazioneAttivitaCliente attivitaPrenotata = this.serviceAttivita.creaPrenotazioneAttivita(idCliente,id).get();


        return attivitaPrenotata;
    }

    @Override
    @DeleteMapping("/elimina{id}")
    public PrenotazioneAttivitaCliente eliminaPrenotazioneAttivitaCliente(IHandlerPrenotazioniAttivitaClienti receptionist, @PathVariable("id") Integer idPrenotazione) {

       /* receptionist.eliminaPrenotazioneAttivita(prenotazione);
        if (checkRimborso(prenotazione)) {
            System.out.println("Rimborso consentito!");
            return null;
        }
        System.out.println("Rimborso negato!");
        return null;
        */
        PrenotazioneAttivitaCliente attivitaEliminata = this.serviceAttivita.eliminaPrenotazioneAttivitaCliente(idPrenotazione).get();
        return attivitaEliminata;
    }

    private boolean checkRimborso(LocalDate primaData ) {
        /*LocalDate dataSvolgimento = prenotazioneAttivita.getAttivitaPrenotata().getDataSvolgimento();
        LocalDate now = LocalDate.now();
        Period difference = Period.between(now,dataSvolgimento);
        if (difference.getYears() >= 0 || difference.getMonths() >= 0 || difference.getDays() >= 2) {
            return true;
        }
        return false;
         */
        LocalDate now = LocalDate.now();
        Period difference = Period.between(now,primaData);
        if (difference.getYears() >= 0 || difference.getMonths() >= 0 || difference.getDays() >= 2) {
            return true;
        }
        return false;

    }
    //FATTO
    @Override//boolean
    public Optional <Attivita> aggiungiAttivita(@RequestBody  Attivita attivita) {
        /*if (this.getAttivita().contains(attivita)) {
            System.out.println("L'attività che si vuole aggiungere è già presente");
            return false;
        }
        System.out.println("Attività aggiunta correttamente");
        this.getAttivita().add(attivita);
        return true;
         */
       Optional <Attivita> added = this.serviceAttivita.addAttivita(attivita);
        if(added.isEmpty()){
            return Optional.empty();
        }
        return added;

    }
    //FATTO
    @Override
    @DeleteMapping("attivita{id}/cancellazione")
    public Optional<Attivita> eliminaAttivita(@PathVariable Integer id) {
       /* if (!this.getAttivita().contains(attivita)) {
            System.out.println("L'attività che si vuole aggiungere non è presente");
            return false;
        }
        System.out.println("Attività rimossa correttamente");
        this.getAttivita().remove(attivita);
        return true;

        */

       return this.serviceAttivita.eliminaAttivita(id);
    }
    //FATTO
    @Override
    @PutMapping("/attivitaRimandate{id}")//mapping //modififa interfaccia e controller
    public Attivita rimandaAttivita(IHandlerNewsletter receptionist,@PathVariable("id")Integer id , String nuovaData) {
        Optional<Attivita> check = this.serviceAttivita.getAttivita(id);
        if(check.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        //Optional<Attivita>toUpdate = this.serviceAttivita.rimandaAttivita();

        //TODO sistemare notifica clienti con receptionist



        return this.getAttivitaOrThrownException(check,HttpStatus.BAD_REQUEST);
    }

    private Attivita getAttivitaOrThrownException(Optional<Attivita> attivita, HttpStatus status) {
        if (attivita.isEmpty())
            throw new ResponseStatusException(status);
        return attivita.get();
    }
}

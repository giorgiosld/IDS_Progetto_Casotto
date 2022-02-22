package it.unicam.cs.ids_progetto_casotto.controller.controller_attivita;

import it.unicam.cs.ids_progetto_casotto.model.attivita.Attivita;
import it.unicam.cs.ids_progetto_casotto.model.attivita.IHandlerPrenotazioniAttivitaClienti;
import it.unicam.cs.ids_progetto_casotto.model.newsletter.IHandlerNewsletter;
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
 * le attivit&agrave;
 */
@RestController
@RequestMapping("/bacheca")
public class ControllerAttivita implements IControllerClienteAttivita,IControllerGestoreAttivita {

    @Autowired
    private ServiceAttivita serviceAttivita;

    @Autowired
    private ServicePrenotazioneAttivita servicePrenotazioneAttivita;

    @Override
    @GetMapping("/offerte")
    public List<Attivita> getAttivita() {
        return this.serviceAttivita.getAll();
    }

    @Override
    @PostMapping("/addAttivita")
    public Attivita aggiungiAttivita(@RequestBody Attivita attivita) {
        Optional <Attivita> added = this.serviceAttivita.addAttivita(attivita);
        return this.getAttivitaOrThrownException(added, HttpStatus.BAD_REQUEST);
    }

    @Override
    @GetMapping("/attivita/{id}")
    public Attivita getSingolaAttivita(@PathVariable ("id")Integer id){
        Optional<Attivita> attivita = this.serviceAttivita.getAttivita(id);
        return this.getAttivitaOrThrownException(attivita, HttpStatus.NOT_FOUND);
    }

    @Override
    @GetMapping("/attivita/{id}/posti")
    public Integer getPostiDisponibili(@PathVariable("id") Integer id) {
        int postiDisponibili;
        postiDisponibili=this.serviceAttivita.getNPosti(id);
        return postiDisponibili;
    }

    @Override
    @DeleteMapping("attivita/{id}/cancellazione")
    public Attivita eliminaAttivita(@PathVariable Integer id) {
        Optional<Attivita> removed = this.serviceAttivita.eliminaAttivita(id);
        return this.getAttivitaOrThrownException(removed, HttpStatus.NOT_FOUND);
    }

    @Override
    @PutMapping("/attivita/{id}/rimanda")//mapping //modififa interfaccia e controller
    public Attivita rimandaAttivita(IHandlerNewsletter receptionist,@PathVariable("id")Integer id , @RequestBody  Attivita attivita) {
        Optional<Attivita> check = this.serviceAttivita.getAttivita(id);
        if(check.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        Optional<Attivita>toUpdate = this.serviceAttivita.rimandaAttivita(id, attivita);
        //TODO sistemare notifica clienti con receptionist
        return this.getAttivitaOrThrownException(toUpdate,HttpStatus.BAD_REQUEST);
    }

    @Override
    @PostMapping("/prenota/{id}")
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
        PrenotazioneAttivitaCliente attivitaPrenotata = this.servicePrenotazioneAttivita.creaPrenotazioneAttivita(idCliente,id).get();


        return attivitaPrenotata;
    }

    @Override
    @DeleteMapping("/elimina/{id}")
    public PrenotazioneAttivitaCliente eliminaPrenotazioneAttivitaCliente(IHandlerPrenotazioniAttivitaClienti receptionist, @PathVariable("id") Integer idPrenotazione) {

       /* receptionist.eliminaPrenotazioneAttivita(prenotazione);
        if (checkRimborso(prenotazione)) {
            System.out.println("Rimborso consentito!");
            return null;
        }
        System.out.println("Rimborso negato!");
        return null;
        */
        PrenotazioneAttivitaCliente attivitaEliminata = this.servicePrenotazioneAttivita.eliminaPrenotazioneAttivitaCliente(idPrenotazione).get();
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

    private Attivita getAttivitaOrThrownException(Optional<Attivita> attivita, HttpStatus status) {
        if (attivita.isEmpty())
            throw new ResponseStatusException(status);
        return attivita.get();
    }
}

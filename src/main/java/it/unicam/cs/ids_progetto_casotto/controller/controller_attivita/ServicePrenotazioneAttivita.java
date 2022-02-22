package it.unicam.cs.ids_progetto_casotto.controller.controller_attivita;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServicePrenotazioneAttivita {

    public ServicePrenotazioneAttivita(){

    }

    public Optional<PrenotazioneAttivitaCliente> creaPrenotazioneAttivita(int idCliente, Integer id) {

        /*Optional<Attivita> attivitaSelezionata = this.repositoryAttivita.findById(id);
        PrenotazioneAttivitaCliente nuovaPrenotazione = new PrenotazioneAttivitaCliente();
        nuovaPrenotazione.setAttivitaPrenotata(attivitaSelezionata.get());
        nuovaPrenotazione.setIdCliente(idCliente);
        nuovaPrenotazione.setOrarioPrenotazione();
        nuovaPrenotazione.setIdCliente(id);


        return Optional.of(this.repositoryPrenotazioneAttivita.save(nuovaPrenotazione));*/
        return Optional.empty();
    }

    public Optional<PrenotazioneAttivitaCliente> eliminaPrenotazioneAttivitaCliente(Integer idPrenotazione) {
        //<PrenotazioneAttivitaCliente> toDelete = this.repositoryPrenotazioneAttivita.findById(idPrenotazione);
        //if(toDelete.isEmpty()){
        //    return Optional.empty();
        //}
        //this.repositoryPrenotazioneAttivita.deleteById(idPrenotazione);
        return Optional.empty();

    }
}

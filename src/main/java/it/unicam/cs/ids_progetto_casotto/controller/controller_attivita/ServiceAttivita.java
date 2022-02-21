package it.unicam.cs.ids_progetto_casotto.controller.controller_attivita;

import it.unicam.cs.ids_progetto_casotto.model.attivita.Attivita;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceAttivita {


    private RepositoryAttivita repositoryAttivita;

    public ServiceAttivita(RepositoryAttivita repositoryAttivita){
        this.repositoryAttivita=repositoryAttivita;
    }

    public List<Attivita> getAll(){
        return this.repositoryAttivita.findAll();
    }

    public int getNPosti(Attivita attivita){
        return this.repositoryAttivita.getById(attivita.getId()).getPostiDisponibili();

    }

    public Optional<Attivita> getAttivita(Integer id){
        Optional<Attivita> attivita = this.repositoryAttivita.findById(id);
        if(attivita.isEmpty()){
            return Optional.empty();
      }
        return attivita;
    }

    public Optional<Attivita> addAttivita(Attivita attivita) {
        if((attivita.getNome().isEmpty())||(attivita.getPrezzo()==0)){
            return Optional.empty();
        }
        return Optional.of(repositoryAttivita.save(attivita));
    }

    public Optional<Attivita> eliminaAttivita(Integer id){
        Optional<Attivita>toRemove = this.repositoryAttivita.findById(id);
       if(toRemove.isEmpty()){
           return Optional.empty();
       }
       return toRemove;

    }
    public Optional <Attivita> rimandaAttivita(Integer id,String nuovaData){
      /*  if(!repositoryAttivita.findAll().contains(attivita)){
            throw new ResponseStatusException(HttpStatus.HTTP_VERSION_NOT_SUPPORTED);
        }

       */
        Attivita check  =  this.repositoryAttivita.getById(id);
        check.setDataSvolgimento(nuovaData);
        return Optional.of(this.repositoryAttivita.save(check));

        /*if(!attivita.getDataSvolgimento().equals(nuovaData)){
            throw new getAttivitaOrThrownException
        }

         */
    }

    public Optional<PrenotazioneAttivitaCliente> creaPrenotazioneAttivita(int idCliente, Integer id){

        LocalDate t1 = LocalDate.now();
        String str = t1.toString();
        Optional<Attivita> attivitaSelezionata = this.repositoryAttivita.findById(id);
        //PrenotazioneAttivitaCliente nuovaPrenotazione = new PrenotazioneAttivitaCliente(idCliente,attivitaSelezionata,str);

        //return Optional.of(nuovaPrenotazione);
        return Optional.empty();


    }
}

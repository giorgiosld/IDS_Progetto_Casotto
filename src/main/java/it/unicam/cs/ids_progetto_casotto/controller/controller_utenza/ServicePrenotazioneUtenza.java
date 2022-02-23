package it.unicam.cs.ids_progetto_casotto.controller.controller_utenza;

import org.springframework.stereotype.Service;

@Service
public class ServicePrenotazioneUtenza {

    private RepositoryPrenotazioneUtenza repositoryPrenotazioneUtenza;

    public ServicePrenotazioneUtenza(RepositoryPrenotazioneUtenza repositoryPrenotazioneUtenza){
        this.repositoryPrenotazioneUtenza = repositoryPrenotazioneUtenza;
    }


}

package it.unicam.cs.ids_progetto_casotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Classe che rappresenta un gestore delle
 * attivit&agrave;
 */
public class ControllerAttivita {

    private final List<Attivita> attivita;

    public ControllerAttivita() {
        this.attivita = new ArrayList<>();
    }

    /**
     * Metodo che ritorna tutte le attivit&agrave;
     * organizzate
     *
     * @return lista di attivit&agrave;
     */
    public List<Attivita> getAttivita() {
        return this.attivita;
    }

    /**
     * Metodo che implementa la possibitlità
     * ad un cliente di prenotare un'attivit&agrave;
     *
     * @param codiceFiscale del cliente che ha effettuato la prenotazione
     * @param nomeAttivita dell'attivit&agrave; selezionata
     *
     * @return l'attivit&agrave; selezionata in caso di prenotazione
     * avvenuta con successo. Nulla altrimenti
     */
    public Optional<Attivita> prenotazioneAttivita(String codiceFiscale, String nomeAttivita) {
        Optional<Attivita> attivita = this.attivita.stream()
                .filter(x -> x.getNome().equals(nomeAttivita))
                .findFirst();
        if (attivita.isPresent()) {
            Attivita temp = attivita.get();
            if (temp.getPostiDisponibili() > 0) {
                temp.setPostiDisponibili(temp.getPostiDisponibili() - 1);
                temp.getClientiPrenotati().add(codiceFiscale);
                return attivita;
            }
        }
        return Optional.empty();
    }
}

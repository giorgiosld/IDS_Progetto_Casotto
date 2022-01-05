package it.unicam.cs.ids_progetto_casotto;

import java.util.ArrayList;
import java.util.List;
import java.util.GregorianCalendar;
import java.util.Optional;
import java.util.stream.Collectors;

public class ControllerAttivita {

    private List<Attivita> attivita;

    public ControllerAttivita() {
        this.attivita = new ArrayList<>();
    }

    public List<Attivita> getAttivita(int anno, int mese, int giorno) {
        GregorianCalendar periodo = new GregorianCalendar(anno, mese, giorno);
        List<Attivita> attivitaFiltrate = this.attivita.stream()
                .filter(x -> x.getDataSvolgimento().equals(periodo))
                .collect(Collectors.toList());
        if (attivitaFiltrate.isEmpty()) {
            System.out.println("Ci dispiace ma non ci sono attività disponibili per il periodo selezionato");
        }
        return attivitaFiltrate;
    }

    public Optional<Attivita> prenotazioneAttivita(int anno, int mese, int giorno, String nomeAttivita) {
        List<Attivita> attivitaVisualizzate = getAttivita(anno, mese, giorno);
        Optional<Attivita> temp = attivitaVisualizzate.stream()
                .filter(a -> a.getNome().equals(nomeAttivita))
                .findFirst();
        if (temp.isPresent() && temp.get().getPostiDisponibili() > 0) {
            rimozionePostoDisponibile(temp.get());
            System.out.println("Prenotazione effettuata con successo\n"+temp.get());
            return temp;
        }
        System.out.println("Ci dispiace ma l'attività da lei scelta non è più disponibile");
        return Optional.empty();
    }

    public void rimozionePostoDisponibile(Attivita attivita) {
        attivita.setPostiDisponibili(attivita.getPostiDisponibili() - 1);
    }
}

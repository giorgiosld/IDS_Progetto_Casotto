package it.unicam.cs.ids_progetto_casotto;

import java.util.GregorianCalendar;
import java.util.List;
import java.util.Optional;

public class Cliente {

    private String nome;
    private String cognome;
    private int eta;
    private String codiceFiscale;
    private char sesso;
    private int idTariffa;

    public Cliente(String nome, String cognome, int eta, String codiceFiscale, char sesso, int idTariffa) {
        this.nome = nome;
        this.cognome = cognome;
        this.eta = eta;
        this.codiceFiscale = codiceFiscale;
        this.sesso = sesso;
        this.idTariffa = idTariffa;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public int getEta() {
        return eta;
    }

    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    public char getSesso() {
        return sesso;
    }

    public int getIdTariffa() {
        return idTariffa;
    }

    public List<Attivita> visualizzaAttivita(int anno, int mese, int giorno) {
        ControllerAttivita controller = new ControllerAttivita();
        List<Attivita> attivitaVisualizzate = controller.getAttivita(anno, mese, giorno);
        return attivitaVisualizzate;
    }

    public Optional<Attivita> prenotaAttivita(int anno, int mese, int giorno, String nomeAttivita) {
        ControllerAttivita controller = new ControllerAttivita();
        Optional<Attivita> attivitaSelezionata = controller.prenotazioneAttivita(anno, mese, giorno, nomeAttivita);
        return attivitaSelezionata;
    }

    public List<GregorianCalendar> visualizzaPeriodo() {
        //TODO
        return null;
    }

    public Optional<UtenzaSpiaggia> prenotaUntenza(int anno, int mese, int giorno, int idUtenza, int idTariffa) {
        //TODO
        return Optional.empty();
    }

    public List<Consumazione> visualizzaMenu(String idUtenza) {
        //TODO
        return null;
    }

    public List<Consumazione> ordinazioneConsumazione(Consumazione ... consumazioni) {
        //TODO
        return null;
    }

    public void pagamento(double importoDaPagare) {
        //TODO
    }

}

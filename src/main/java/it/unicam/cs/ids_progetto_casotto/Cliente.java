package it.unicam.cs.ids_progetto_casotto;

import java.util.GregorianCalendar;
import java.util.List;
import java.util.Optional;

public class Cliente {

    private final String nome;
    private final String cognome;
    private final int eta;
    private final String codiceFiscale;
    private final char sesso;
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

    public void setIdTariffa(int idTariffa) { this.idTariffa = idTariffa; }

    public List<Attivita> visualizzaAttivita(ControllerAttivita controller) {
        return controller.getAttivita();
    }

    public Optional<Attivita> prenotaAttivita(ControllerAttivita controller, String nomeAttivita) {
        Optional<Attivita> attivitaSelezionata = controller.prenotazioneAttivita(this.codiceFiscale, nomeAttivita);
        return attivitaSelezionata;
    }

    public List<GregorianCalendar> visualizzaPeriodo(ControllerUtenze controllerUtenze) {
        return controllerUtenze.getPeriodi();
    }

    public Optional<UtenzaSpiaggia> prenotaUntenza(ControllerUtenze controllerUtenze, int idUtenza, int idTariffa) {
        return controllerUtenze.prenotaUtenza(idUtenza, idTariffa);
    }

    /**
     * Metodo per visualizzare il men&ugrave;
     *
     * @param controllerOrdinazione controller dal quale si visualizza il men&ugrave;
     *
     * @return lista di consumazioni
     */
    public List<Consumazione> visualizzaMenu(ControllerOrdinazione controllerOrdinazione) {
        return controllerOrdinazione.getConsumazioni();
    }

    public List<Consumazione> ordinazioneConsumazione(ControllerOrdinazione controllerOrdinazione, Consumazione ... consumazioni) {
        Comanda c = controllerOrdinazione.creaComanda(consumazioni);
        return c.getConsumazioni();
    }

    public void pagamento(double importoDaPagare) {
        //TODO
    }

}

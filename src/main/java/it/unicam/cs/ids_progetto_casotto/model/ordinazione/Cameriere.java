package it.unicam.cs.ids_progetto_casotto.model.ordinazione;

import it.unicam.cs.ids_progetto_casotto.controller.controller_ordinazione.ControllerOrdinazione;
import it.unicam.cs.ids_progetto_casotto.controller.controller_ordinazione.IControllerStaffOrdinazione;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Classe che rappresenta un cameriere
 */
public class Cameriere extends StaffRistorazione{

    List<Comanda> comandeDaConsegnare;

    public Cameriere(int id, String nome, String cognome, String dataNascita, char sesso, String email) {
        super(id, nome, cognome, dataNascita, sesso, email);
    }

    /**
     * Metodo per far creare al cameriere una comanda in cui riceve le consumazioni a voce dal cliente
     *
     * @param controller handler delle ordinazioni in cui salvare la comanda
     * @param consumazioni le consumazioni scelte dal cliente e dettate al cameriere
     */
    public void creaComanda(ControllerOrdinazione controller, List<Consumazione> consumazioni, Barista barista){
        controller.creaComanda(consumazioni);
    }

    /**
     * Metodo che ritorna una lista di comande pronte per la successiva consegna al cliente
     *
     * @param bar da dove cercare le comande pronte
     * @return lista di comande pronte
     */
    public List<Comanda> getComandePronte(IControllerStaffOrdinazione bar){
        List<Comanda> todelivery = bar.getComande().stream()
                                                        .filter(x -> x.getStatoComanda() == StatoComanda.PRONTA)
                                                        .collect(Collectors.toList());
        return todelivery;
    }

    /**
     * Metodo che aggiunge una comanda da consegnare nella lista del cameriere
     *
     * @param comanda la comanda da consegnare
     */
    public void aggiungiComandaDaConsegnare(Comanda comanda){
        this.comandeDaConsegnare.add(comanda);
    }

    /**
     * Metodo che cambia lo stato della comanda per porla in consegna
     *
     * @param comanda la comanda che sta per essere consegnata
     */
    public void consegnaComande(Comanda comanda){
        comanda.setStatoComanda(StatoComanda.IN_CONSEGNA);
        this.setStatoOccupazione(StatoOccupazione.OCCUPATO);
    }

    /**
     * Metodo che termina il ciclo di vita della comanda
     *
     * @param comanda la comanda che è stata consegnata
     */
    public void terminaComanda(Comanda comanda){
        comanda.setStatoComanda(StatoComanda.CONSEGNATA);
        this.setStatoOccupazione(StatoOccupazione.LIBERO);
    }
}

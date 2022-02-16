package it.unicam.cs.ids_progetto_casotto.model;

import it.unicam.cs.ids_progetto_casotto.controller.ControllerOrdinazione;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Classe che rappresenta un Barista
 */
public class Barista extends StaffRistorazione{

    public Barista(String nome, String cognome) {
        super(nome, cognome);
    }

    @Override
    public String getNome() {
        return super.getNome();
    }


    @Override
    public Comanda getComanda(Comanda comanda, ControllerOrdinazione controller) {
        return super.getComanda(comanda, controller);
    }

    @Override
    public List<Comanda> getComande(ControllerOrdinazione controller) {
        return super.getComande(controller);
    }

    /**
     * Metodo che ritorna una lista di comande create per la successiva preparazione di essa
     *
     * @param controller da dove cercare le comande pronte
     * @return lista di comande pronte
     */
    public List<Comanda> visualizzaComandeCreate(ControllerOrdinazione controller){
        List<Comanda> toPrepare = controller.getComande().stream()
                .filter(x -> x.getState() == StatoComanda.CREATA)
                .collect(Collectors.toList());
        return toPrepare;
    }

    /**
     * Metodo che ritorna una comanda e la pone in stato di preprazione
     *
     * @param controller dove si trovano memorizzate le comande
     * @param comanda la comanda alla quale si vuole mettere in stato di preparazione
     * @return la comanda in stato di preparazione
     */
    public Comanda preparaComanda(ControllerOrdinazione controller, Comanda comanda){
        List<Comanda> comandeCreate = this.visualizzaComandeCreate(controller);
        Comanda toPrepare = comandeCreate.stream().filter(x -> comanda.equals(x)).findFirst().get();
        toPrepare.setState(StatoComanda.IN_PREPARAZIONE);
        return toPrepare;
    }
}


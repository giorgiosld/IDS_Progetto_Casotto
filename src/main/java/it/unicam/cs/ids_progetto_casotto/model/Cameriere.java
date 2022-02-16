package it.unicam.cs.ids_progetto_casotto.model;

import it.unicam.cs.ids_progetto_casotto.controller.ControllerOrdinazione;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Classe che rappresenta un cameriere
 */
public class Cameriere extends StaffRistorazione{

    public Cameriere(String nome, String cognome) {
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
     * Metodo per far creare al cameriere una comanda in cui riceve le consumazioni a voce dal cliente
     *
     * @param controller handler delle ordinazioni in cui salvare la comanda
     * @param consumazioni le consumazioni scelte dal cliente e dettate al cameriere
     */
    public void creaComanda(ControllerOrdinazione controller, Consumazione ... consumazioni){
        controller.creaComanda(consumazioni);
    }

    /**
     * Metodo che ritorna una lista di comande pronte per la successiva consegna al cliente
     *
     * @param controller da dove cercare le comande pronte
     * @return lista di comande pronte
     */
    public List<Comanda> visualizzaComandePronte(ControllerOrdinazione controller){
        List<Comanda> todelivery = controller.getComande().stream()
                                                        .filter(x -> x.getState() == StatoComanda.PRONTA)
                                                        .collect(Collectors.toList());
        return todelivery;
    }
}

package it.unicam.cs.ids_progetto_casotto;

import java.util.List;

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
     * Metodo che setta uno stato di consumazione ad una consumazione
     *
     * @param consumazione la consumazione in svolgimento
     * @param state stato in cui deve essere posto
     */
    public void setStatoConsumazione(Consumazione consumazione, StatoConsumazione state){
        consumazione.setStatoConsumazione(state);
    }
}


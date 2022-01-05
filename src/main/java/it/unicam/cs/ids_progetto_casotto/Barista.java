package it.unicam.cs.ids_progetto_casotto;

import java.util.List;

public class Barista extends StaffRistorazione{

    public Barista(String nome, int idStaff) {
        super(nome, idStaff);
    }

    @Override
    public String getNome() {
        return super.getNome();
    }

    @Override
    public int getIdStaff() {
        return super.getIdStaff();
    }

    @Override
    public Comanda getOrdinazione(Comanda comanda, ControllerOrdinazione controller) {
        return super.getOrdinazione(comanda, controller);
    }

    @Override
    public List<Comanda> getOrdinazioni(ControllerOrdinazione controller) {
        return super.getOrdinazioni(controller);
    }


}


package it.unicam.cs.ids_progetto_casotto;

public class Cameriere extends StaffRistorazione{

    public Cameriere(String nome, int idStaff) {
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
    public void getOrdinazione() {
        super.getOrdinazione();
    }

    //TODO getStatoComanda after create StatoComanda as enum

    //TODO setStatoComanda after create StatoComanda as enum
}

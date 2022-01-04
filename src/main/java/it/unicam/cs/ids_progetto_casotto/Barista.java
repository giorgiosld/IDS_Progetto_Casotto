package it.unicam.cs.ids_progetto_casotto;

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
    public void getOrdinazione() {
        super.getOrdinazione();
    }

    public void setStatoConsumazione(Consumazione consumazione, StatoConsumazione state){
        consumazione.setStatoConsumazione(state);
    }
}

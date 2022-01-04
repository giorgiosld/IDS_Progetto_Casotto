package it.unicam.cs.ids_progetto_casotto;

public abstract class StaffRistorazione {

    protected String nome;
    protected int idStaff;

    public StaffRistorazione(String nome, int idStaff){
        this.nome = nome;
        this.idStaff = idStaff;
    }

    public String getNome() {
        return nome;
    }

    public int getIdStaff() {
        return idStaff;
    }

    public void getOrdinazione(){
        //TODO
    }
}

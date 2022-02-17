package it.unicam.cs.ids_progetto_casotto.model;

public class Tariffa {

    FasciaOraria fasciaOraria;
    double prezzo;
    int attivitaComprese;

    public Tariffa(FasciaOraria fasciaOraria, double prezzo, int attivitaComprese){
        this.fasciaOraria=fasciaOraria;
        this.prezzo=prezzo;
        this.attivitaComprese=attivitaComprese;

}

    public int getAttivitaComprese() {
        return this.attivitaComprese;
    }
    public FasciaOraria getFasciaOraria(){
        return this.getFasciaOraria();
    }
    public double getPrezzo(){
        return this.prezzo;
    }
}

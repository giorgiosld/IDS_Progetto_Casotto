package it.unicam.cs.ids_progetto_casotto.model.ordinazione;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.List;

/**
 * Classe che rappresenta un generico piatto che si trova nel men&ugrave;
 */
@Entity
public class Cibo extends Consumazione{

    @Column
    String allergeni;

    public Cibo() {
        super();
    }

    /*public Cibo(String nome, double prezzo, List<String> allergeni) {
        super(nome, prezzo);
        this.allergeni = allergeni;
    }*/

    public String getAllergeni(){
        return this.allergeni;
    }
}

package it.unicam.cs.ids_progetto_casotto.model.ordinazione;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import it.unicam.cs.ids_progetto_casotto.controller.controller_ordinazione.ControllerOrdinazione;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * Classe che rappresenta una generica comanda contenuta all'interno del {@link ControllerOrdinazione}
 */
@Entity
@Getter
@Setter
public class Comanda {

    //private static int id;
    @Id
    @Column
    private  UUID idComanda;
    @Column
    public double prezzoTotale;
    @Column
    public StatoComanda statoComanda;
    //DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    @Column
    private  String orarioCreazione;


//    public Comanda(List<Consumazione> consumazioni, double prezzoTotale, StatoComanda state){
//        this.idComanda = Comanda.id;
//        Comanda.id++;
//        this.consumazioni = consumazioni;
//        this.prezzoTotale = prezzoTotale;
//        this.statoComanda = state;
//        this.orarioCreazione =  dtf.format(LocalDateTime.now());
//    }
    public Comanda(){
        this.idComanda = UUID.randomUUID();
    }

    /**
     * Crea la comanda senza saperne il prezzo totale
     *
     * @param consumazioni la lista delle consumaizoni scelte
     * @param state stato in cui si trova la comanda
     */
//    public Comanda(List<Consumazione> consumazioni, StatoComanda state){
//        this.idComanda = Comanda.id;
//        Comanda.id++;
//        this.consumazioni = consumazioni;
//        this.statoComanda = state;
//        this.orarioCreazione =  dtf.format(LocalDateTime.now());
//    }

    /**
     * Ritorna l'id della comanda
     *
     * @return id della comanda
     */
//    public int getId() {
//        return this.idComanda;
//    }

    /**
     * Ritorna la lista delle consumazioni presenti nella comanda
     *
     * @return lista consumazioni scelte dal cliente
     */
//    public List<Consumazione> getConsumazioni() {
//        return consumazioni;
//    }

    /**
     * Se non presente chiama metodo per il calcolo del prezzo totale della comanda
     *
     * @return il prezzo totale della comanda
     */
//    public double getPrezzoTotale() {
//        if(Double.isNaN(this.prezzoTotale)){
//            this.calcolaPrezzoTotale();
//        }
//        return this.prezzoTotale;
//    }

    /**
     * Calcolo del prezzo totale della comanda
     */
//    public void calcolaPrezzoTotale(){
//        this.prezzoTotale = this.consumazioni.stream()
//                .mapToDouble(Consumazione::getPrezzo)
//                .sum();
//    }

    /**
     * Ritorna lo stato della comanda
     *
     * @return stato comanda
     */
    public StatoComanda getStatoComanda() {
        return statoComanda;
    }

    /**
     * Imposta lo stato della comanda
     *
     * @param state stato da impostare
     */
    public void setStatoComanda(StatoComanda state){
        this.statoComanda = state;
    }


    /**
     * Ritorna l'orario in stringa di quando si è creata la comanda
     *
     * @return orario creazione comanda
     */
//    //public String getOrarioCreazione() {
//        return orarioCreazione;
//    }

    @Override
    public String toString() {
        return "Comanda{" +
                "idComanda=" + idComanda +
                ", prezzoTotale=" + prezzoTotale +
                ", state=" + statoComanda +
                ", data creazione=" + orarioCreazione +
                '}';
    }
}

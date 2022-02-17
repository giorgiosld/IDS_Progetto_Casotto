package it.unicam.cs.ids_progetto_casotto.model.utenza;

/**
 * Classe che descrive un periodo di prenotazione
 */
public class Periodo {

    String checkIn;
    String checkOut;

    public Periodo(String checkIn, String checkOut){
        this.checkIn=checkIn;
        this.checkOut=checkOut;
    }

    /**
     * metodo che controlla se checkIn e checkOut hanno la stessa data
     * @return true se i checkIn e checkOut sono uguali altrimenti false
     */
    public boolean checkGiorni(){

        if(this.checkOut.equals(this.checkOut)){
            return true;
        }
        return false;
    }
    public String getCheckIn(){
        return this.checkIn;
    }
    public String getCheckOut(){
        return  this.checkOut;
    }
    public void setCheckIn(String newCheckIn){
        this.checkIn=newCheckIn;
    }
    public void setCheckOut(String newCheckOut){
        this.checkOut=newCheckOut;
    }
}

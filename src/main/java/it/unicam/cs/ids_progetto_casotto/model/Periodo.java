package it.unicam.cs.ids_progetto_casotto.model;

/**
 * Classe che rappresenta
 * il periodo di permanenza
 * del cliente
 */
public class Periodo {

    private final String checkIn;
    private final String checkOut;

    public Periodo(String checkIn, String checkOut) {
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    /**
     * Metodo che ritorna
     * la data del checkIn
     *
     * @return stringa che indica
     * il checkIn
     */
    public String getCheckIn() {
        return checkIn;
    }

    /**
     * Metodo che ritorna
     * la data del checkOut
     *
     * @return stringa che indica
     * il checkOut
     */
    public String getCheckOut() {
        return checkOut;
    }

    /**
     * Metodo che controlla
     * se il checkIn e il checkOut
     * corrispondono alla stessa data
     *
     * @return true se le checkIn e
     * checkOut coincidono, false altrimenti
     */
    boolean checkGiorni() {
        if (this.checkIn.equals(this.checkOut)) {
            return true;
        }
        return false;
    }
}

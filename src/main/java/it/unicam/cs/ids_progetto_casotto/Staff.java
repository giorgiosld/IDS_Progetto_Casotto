package it.unicam.cs.ids_progetto_casotto;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Classe astratta che rappresenta un membro non definito dello staff dello chalet
 */
public abstract class Staff {

    private static final AtomicInteger precedente = new AtomicInteger(0);
    private final int id;
    public String nome;
    public String cognome;

    public Staff(String nome, String cognome){
        id = precedente.incrementAndGet();
        this.nome = nome;
        this.cognome = cognome;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }
}

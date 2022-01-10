package it.unicam.cs.ids_progetto_casotto;

import java.util.concurrent.atomic.AtomicInteger;

public abstract class Staff {

    private static final AtomicInteger precedente = new AtomicInteger(0);
    private int id;
    public String nome;

    public Staff(String nome){
        id = precedente.incrementAndGet();
        this.nome = nome;
    }
}

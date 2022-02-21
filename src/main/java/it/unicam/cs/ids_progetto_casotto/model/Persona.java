package it.unicam.cs.ids_progetto_casotto.model;

import javax.persistence.*;

@MappedSuperclass
public abstract class Persona implements IUtente{

    @Column
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column
    private  String nome;

    @Column
    private  String cognome;

    @Column
    private  char sesso;

    @Column
    private String email;

    public Persona(){

    }

    @Override
    public Integer getId() {
        return this.id;
    }

    public void setId(int newId) {
        this.id = newId;
    }

    @Override
    public String getNomeUtente() {
        return this.nome;
    }

    public void setNome(String nome){
        this.nome=nome;
    }

    public void setCognome(String cognome){
        this.cognome=cognome;
    }

    @Override
    public String getCognomeUtente() {
        return this.cognome;
    }

    @Override
    public char getSesso() {
        return this.sesso;
    }

    @Override
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String newEmail) {
        this.email = newEmail;
    }
}

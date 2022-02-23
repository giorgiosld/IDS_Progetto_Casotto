package it.unicam.cs.ids_progetto_casotto.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import it.unicam.cs.ids_progetto_casotto.model.attivita.Prenotazione;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.Set;

/**
 * Classe che rappresenta un
 * generico cliente che utilizzer&agrave;
 * il sistema
 */
@Entity
@Table(name = "user")
@JsonIgnoreProperties(value = {"prenotazioni"})
public class User implements IUtente{

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

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(targetEntity = Prenotazione.class, mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Prenotazione> prenotazioni;

    public User(){

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

package it.unicam.cs.ids_progetto_casotto.model.attivita;


import it.unicam.cs.ids_progetto_casotto.controller.controller_attivita.ControllerAttivita;
import it.unicam.cs.ids_progetto_casotto.controller.controller_utenza.PrenotazioneUtenzaCliente;
import it.unicam.cs.ids_progetto_casotto.model.User;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Classe che rappresenta una prenotazione
 * del cliente che viene gestita da
 * {@link ControllerAttivita} e
 */

@Entity
@Getter
@Setter
@Table(name = "prenotazione")
public class Prenotazione {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @LazyCollection(LazyCollectionOption.FALSE)
    @ManyToOne(targetEntity = User.class)
    private User user;

    @LazyCollection(LazyCollectionOption.FALSE)
    @ManyToMany(targetEntity = Event.class, cascade = CascadeType.ALL)
    private Set<Event> eventiPrenotatiList;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(targetEntity = PrenotazioneUtenzaCliente.class, mappedBy = "prenotazione")
    private Set<PrenotazioneUtenzaCliente> utenzaPrenotazioneList;

    public Prenotazione() {
        this.eventiPrenotatiList = new HashSet<>();
        this.utenzaPrenotazioneList = new HashSet<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Event> getEventiPrenotatiList() {
        return eventiPrenotatiList;
    }

    public void setEventiPrenotatiList(Set<Event> eventiPrenotatiList) {
        this.eventiPrenotatiList = eventiPrenotatiList;
    }

    public Set<PrenotazioneUtenzaCliente> getUtenzaPrenotazioneList() {
        return utenzaPrenotazioneList;
    }

    public void setUtenzaPrenotazioneList(Set<PrenotazioneUtenzaCliente> utenzaPrenotazioneList) {
        this.utenzaPrenotazioneList = utenzaPrenotazioneList;
    }
}

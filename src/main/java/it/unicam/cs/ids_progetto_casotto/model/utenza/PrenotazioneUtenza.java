package it.unicam.cs.ids_progetto_casotto.model.utenza;

import com.fasterxml.jackson.annotation.JsonFormat;
import it.unicam.cs.ids_progetto_casotto.model.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "prenotazione_utenza")
public class PrenotazioneUtenza {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "check_in")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate checkIn;

    @Column(name = "check_out")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate checkOut;

    @ManyToOne(targetEntity = User.class,
            cascade = CascadeType.ALL)
    @JoinColumn(name = "cliente_id", referencedColumnName = "id")
    private User user;

    @ManyToOne(targetEntity = Utenza.class,
            cascade = CascadeType.ALL)
    @JoinColumn(name = "utenza_id", referencedColumnName = "id")
    private Utenza utenza;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tariffa_id", referencedColumnName = "id")
    private Tariffa tariffa;


    public PrenotazioneUtenza() {}

    public void assegnaTariffa(Tariffa tariffa) {
        this.tariffa = tariffa;
    }

    public void assegnaUtente(User user) {
        this.user = user;
    }

    public void assegnaUtenza(Utenza utenza) {
        this.utenza = utenza;
    }


}

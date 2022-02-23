package it.unicam.cs.ids_progetto_casotto.controller.controller_utenza;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import it.unicam.cs.ids_progetto_casotto.model.attivita.Prenotazione;
import it.unicam.cs.ids_progetto_casotto.model.utenza.Periodo;
import it.unicam.cs.ids_progetto_casotto.model.utenza.Tariffa;
import it.unicam.cs.ids_progetto_casotto.model.utenza.Utenza;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Classe che rappresenta una prenotazione
 * del cliente che viene gestita da
 *
 */

@Entity
@Table(name = "prenotazione_utenza")
@Getter
@Setter
@JsonIgnoreProperties(value = {"prenotazione"}, allowSetters = true)
public class PrenotazioneUtenzaCliente {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String tipo;

    @Column
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime checkin;

    @Column
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime checkout;

    @ManyToOne(targetEntity = Utenza.class)
    private Utenza utenza;

    @ManyToOne(targetEntity = Prenotazione.class)
    private Prenotazione prenotazione;

    public PrenotazioneUtenzaCliente(){

    }

}

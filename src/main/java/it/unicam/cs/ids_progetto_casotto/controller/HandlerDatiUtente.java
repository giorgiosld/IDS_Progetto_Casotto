package it.unicam.cs.ids_progetto_casotto.controller;

import it.unicam.cs.ids_progetto_casotto.model.Cliente;
import it.unicam.cs.ids_progetto_casotto.model.Tariffa;

public interface HandlerDatiUtente {

     String getNomeUtente(Cliente cliente);

     String getCognomeUtente(Cliente cliente);

     int getEta(Cliente cliente);

     char getSesso(Cliente cliente);

     Tariffa getTariffa();//pensare al tipo di tariffa
}
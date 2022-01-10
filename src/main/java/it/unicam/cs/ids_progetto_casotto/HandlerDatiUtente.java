package it.unicam.cs.ids_progetto_casotto;

public interface HandlerDatiUtente {

     String getNomeUtente(Cliente cliente);

     String getCognomeUtente(Cliente cliente);

     int getEta(Cliente cliente);

     char getSesso(Cliente cliente);

     Tariffa getTariffa();//pensare al tipo di tariffa
}
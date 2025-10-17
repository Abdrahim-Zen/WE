/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package it.univaq.webmarket.data.model;

import java.time.LocalDate;

/**
 *
 * @author abdrahimzeno
 */
public interface Tecnico extends Utente{
    
    LocalDate getDataAssunzione();
    void setDataAssunzione(LocalDate x);
    void setStato(String x);
    String getStato();
    
    
}

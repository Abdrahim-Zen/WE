/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package it.univaq.webmarket.data.model;

/**
 *
 * @author abdrahimzeno
 */
public interface UtenteRegistrato extends Utente {
    String getPassword();
    
    Double getBudgetDisponibile();
    
    void setBudgetDisponibile(Double x);
    
}

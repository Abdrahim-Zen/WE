/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.univaq.webmarket.data.model;

import it.univaq.webmarket.framework.data.DataItem;

/**
 *
 * @author abdrahimzeno
 */
public interface Utente extends DataItem<Integer> {
    String getNome();
    
    String getCognome();
    String getPassword();
    String getEmail();
    void setNome(String name);
    void setEmail(String x);
    void setCognome(String surname);
    
    Amministratore getAmministratore();
    
    void setAmministratore(Amministratore x);
    void setPassword(String x);

  
    
}

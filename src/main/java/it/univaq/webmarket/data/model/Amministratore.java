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
public interface Amministratore extends DataItem<Integer>{
    String getNome();
    
    String getCognome();
    
    String getEmail();
    
    String getPassword();
    
    void setNome(String name);
    
    void setCognome(String surname);
    
    void setPassword(String password);
    
    void setEmail(String x);
    
  
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.univaq.webmarket.data.model.impl;

import it.univaq.webmarket.data.model.Amministratore;
import it.univaq.webmarket.framework.data.DataItemImpl;

/**
 *
 * @author abdrahimzeno
 */
public class AmministratoreImpl extends DataItemImpl<Integer> implements Amministratore{
    private String nome;
    private String cognome;
    
    public AmministratoreImpl(){
        nome=null;
        cognome=null;
    }
    @Override
    public String getNome() {
        return nome; 
    }

    @Override
    public String getCognome() {
        return cognome; 
    }

    @Override
    public void setNome(String name) {
        this.nome=name; 
    }

    @Override
    public void setCognome(String surname) {
        this.cognome=surname; 
    }

   
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.univaq.webmarket.data.model.impl;

import it.univaq.webmarket.data.model.Amministratore;
import it.univaq.webmarket.data.model.UtenteRegistrato;
import it.univaq.webmarket.framework.data.DataItemImpl;

/**
 *
 * @author abdrahimzeno
 */
public class UtenteRegistratoImpl extends DataItemImpl<Integer> implements UtenteRegistrato{
      private String email;
      private String nome;
      private String cognome;
      private Amministratore amministratore;
      private String password;
      private Double budgetDisponibile;
    public UtenteRegistratoImpl(){
        super();
        nome=null;
        cognome=null;
        amministratore=null;
        password=null;
        budgetDisponibile=null;
    }
    @Override
    public String getPassword() {
        return password; 
    }

    @Override
    public void setPassword(String x) {
        this.password=x; 
    }

    @Override
    public Double getBudgetDisponibile() {
       return budgetDisponibile; 
    }

    @Override
    public void setBudgetDisponibile(Double x) {
        this.budgetDisponibile=x;
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

    @Override
    public Amministratore getAmministratore() {
        return amministratore;
    }

    @Override
    public void setAmministratore(Amministratore x) {
        this.amministratore=x; 
    }

    @Override
    public String getEmail() {
       return email; 
    }

    @Override
    public void setEmail(String x) {
       this.email=x; 
    }
    
}

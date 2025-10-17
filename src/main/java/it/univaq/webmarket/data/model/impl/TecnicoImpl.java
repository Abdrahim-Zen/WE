/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.univaq.webmarket.data.model.impl;

import it.univaq.webmarket.data.model.Amministratore;
import it.univaq.webmarket.data.model.Tecnico;
import it.univaq.webmarket.framework.data.DataItemImpl;
import java.time.LocalDate;

/**
 *
 * @author abdrahimzeno
 */
public class TecnicoImpl extends DataItemImpl<Integer> implements Tecnico{
    
    private String nome;
    private String cognome;
    private Amministratore amministratore;
    private LocalDate dataAssunzione;
    private String password;
    private String email;
    private String stato;
    public TecnicoImpl(){
        super();
        nome=null;
        cognome=null;
        amministratore=null;
        dataAssunzione=null;
    }
    @Override
    public LocalDate getDataAssunzione() {
        return dataAssunzione; 
    }

    @Override
    public void setDataAssunzione(LocalDate x) {
        this.dataAssunzione=x;
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
    public void setPassword(String x) {
        this.password=x;
    }

    @Override
    public String getPassword() {
       return password; 
    }

    @Override
    public String getEmail() {
        return email; 
    }

    @Override
    public void setEmail(String x) {
        this.email=x; 
    }

    @Override
    public void setStato(String x) {
       this.stato=x; 
    }

    @Override
    public String getStato() {
       return stato; 
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.univaq.webmarket.data.model.impl.proxy;

import it.univaq.webmarket.data.model.Amministratore;
import it.univaq.webmarket.data.model.impl.UtenteRegistratoImpl;
import it.univaq.webmarket.framework.data.DataItemProxy;
import it.univaq.webmarket.framework.data.DataLayer;

/**
 *
 * @author abdrahimzeno
 */
public class UtenteRegistratoProxy extends UtenteRegistratoImpl implements DataItemProxy {

    protected boolean modified;
    protected DataLayer dataLayer;
    protected Integer Amministratore_key;

    public UtenteRegistratoProxy(DataLayer d) {
        super();
        this.dataLayer = d;
        this.modified = false;
    }

    @Override
    public void setPassword(String x) {
        super.setPassword(x);
        setModified(true);
    }

    @Override
    public void setBudgetDisponibile(Double x) {
        super.setBudgetDisponibile(x);
        setModified(true);
    }

    @Override
    public void setNome(String name) {
        super.setNome(name); // oppure this.nome = name;
        setModified(true);
    }

    @Override
    public void setCognome(String surname) {
        super.setCognome(surname); // oppure this.cognome = surname;
        setModified(true);
    }

    @Override
    public void setAmministratore(Amministratore x) {
        super.setAmministratore(x);
        setModified(true);
    }
    
    @Override
    public void setEmail(String x){
        super.setEmail(x);
        setModified(true);
    }

    @Override
    public boolean isModified() {
        return modified;
    }

    @Override
    public void setModified(boolean dirty) {
        this.modified = dirty;
    }

    public void setAmministratore_key(int aInt) {
        this.Amministratore_key = aInt; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}

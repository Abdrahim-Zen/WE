/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.univaq.webmarket.data.model.impl.proxy;

import it.univaq.webmarket.data.model.impl.UtenteImpl;
import it.univaq.webmarket.framework.data.DataItemProxy;
import it.univaq.webmarket.framework.data.DataLayer;

/**
 *
 * @author abdrahimzeno
 */
public class UtenteProxy extends UtenteImpl implements DataItemProxy {

    protected boolean modified;
    protected DataLayer dataLayer;
    protected Integer Amministratore_key;

    public UtenteProxy(DataLayer d) {
        super();
        this.dataLayer = d;
        this.modified = false;
    }

    @Override
    public boolean isModified() {
        return modified;
    }

    @Override
    public void setModified(boolean dirty) {
        this.modified = dirty;
    }

    @Override
    public void setNome(String nome) {
        super.setNome(nome);
        setModified(true);
    }

    @Override
    public void setCognome(String cognome) {
        super.setCognome(cognome);
        setModified(true);
    }

    public void setAmministratore_key(Integer a) {
        this.Amministratore_key = a;
        setModified(true);
    }
    public void setEmail(String x){
        super.setEmail(x);
        setModified(true);
    }

}

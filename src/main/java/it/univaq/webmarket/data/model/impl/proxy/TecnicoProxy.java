/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.univaq.webmarket.data.model.impl.proxy;

import it.univaq.webmarket.data.model.Amministratore;
import it.univaq.webmarket.data.model.impl.TecnicoImpl;
import it.univaq.webmarket.framework.data.DataItemProxy;
import it.univaq.webmarket.framework.data.DataLayer;
import java.time.LocalDate;

/**
 *
 * @author abdrahimzeno
 */
public class TecnicoProxy extends TecnicoImpl implements DataItemProxy {

    protected boolean modified;
    protected DataLayer dataLayer;
    protected Integer Amministratore_key;

    public TecnicoProxy(DataLayer d) {
        super();
        this.dataLayer = d;
        this.modified = false;
    }

    @Override
    public void setDataAssunzione(LocalDate x) {
        super.setDataAssunzione(x);
        setModified(true);
    }

    @Override
    public void setNome(String name) {
        super.setNome(name);
        setModified(true);
    }

    @Override
    public void setCognome(String surname) {
        super.setCognome(surname);
        setModified(true);
    }

    @Override
    public void setAmministratore(Amministratore x) {
        super.setAmministratore(x);
        setModified(true);
    }

    @Override
    public void setPassword(String x) {
        super.setPassword(x);
        setModified(true);
    }
    
    @Override
    public void setStato(String x){
        super.setStato(x);
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
        this.Amministratore_key = aInt;

    }
}

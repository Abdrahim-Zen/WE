/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.univaq.webmarket.data.model.impl.proxy;

import it.univaq.webmarket.data.model.impl.ProdottoImpl;
import it.univaq.webmarket.framework.data.DataItemProxy;
import it.univaq.webmarket.framework.data.DataLayer;

/**
 *
 * @author abdrahimzeno
 */
public class ProdottoProxy extends ProdottoImpl implements DataItemProxy {
    
    protected boolean modified;
    protected DataLayer dataLayer;
    private int CategoriaID;
    
    public ProdottoProxy(DataLayer d){
        super();
        this.modified=false;
        this.dataLayer=d;
    }
    @Override
    public void setPrezzo(Double x) {
        super.setPrezzo(x);
        setModified(true);
    }

    @Override
    public void setDescrizione(String x) {
        super.setDescrizione(x);
        setModified(true);
    }
    
    public void setCategoriaID(int x) {
        this.CategoriaID=x;
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
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.univaq.webmarket.data.model.impl.proxy;

import it.univaq.webmarket.data.model.Categoria;
import it.univaq.webmarket.data.model.impl.SpecificaCategoriaImpl;
import it.univaq.webmarket.framework.data.DataItemProxy;
import it.univaq.webmarket.framework.data.DataLayer;

/**
 *
 * @author abdrahimzeno
 */
public class SpecificaCategoriaProxy extends SpecificaCategoriaImpl implements DataItemProxy {

    protected boolean modified;
    protected DataLayer dataLayer;
    protected int CategoriaKey;
    public SpecificaCategoriaProxy(DataLayer d) {
        super();
        this.dataLayer = d;
        this.modified = false;
    }
    
    @Override
    public void setNomeSpecifica(String x){
        super.setNomeSpecifica(x);
        setModified(true);
    }
    
    public void setCategoriaKey(int id){
        this.CategoriaKey=id;
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

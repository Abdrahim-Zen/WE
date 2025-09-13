/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.univaq.webmarket.data.model.impl.proxy;

import it.univaq.webmarket.data.model.RichiestaAcquisto;
import it.univaq.webmarket.data.model.SpecificaCategoria;
import it.univaq.webmarket.data.model.impl.ValoreSpecificaRichiestaImpl;
import it.univaq.webmarket.framework.data.DataItemProxy;
import it.univaq.webmarket.framework.data.DataLayer;

/**
 *
 * @author abdrahimzeno
 */
public class ValoreSpecificaRichiestaProxy extends ValoreSpecificaRichiestaImpl implements DataItemProxy {

    protected boolean modified;
    protected DataLayer dataLayer;
    
    public ValoreSpecificaRichiestaProxy(DataLayer d) {
        super();
        this.dataLayer = d;
        this.modified = false;
    }

    @Override
    public void setRichiestaAcquisto(RichiestaAcquisto x) {
        super.setRichiestaAcquisto(x);
        setModified(true);
    }

    @Override
    public void setSpecificaCategoria(SpecificaCategoria x) {
        super.setSpecificaCategoria(x);
        setModified(true);
    }
    
    @Override
    public void setValore(String x) {
        super.setValore(x);
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

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.univaq.webmarket.data.model.impl;

import it.univaq.webmarket.data.model.RichiestaAcquisto;
import it.univaq.webmarket.data.model.SpecificaCategoria;
import it.univaq.webmarket.data.model.ValoreSpecificaRichiesta;
import it.univaq.webmarket.framework.data.DataItemImpl;

/**
 *
 * @author abdrahimzeno
 */
public class ValoreSpecificaRichiestaImpl extends DataItemImpl<Integer> implements ValoreSpecificaRichiesta{
    private RichiestaAcquisto richiestaAcquisto;
    private SpecificaCategoria specificaCategoria;
    private String valore;
    
    public ValoreSpecificaRichiestaImpl(){
        super();
        richiestaAcquisto=null;
        specificaCategoria=null;
        valore=null; 
    }
    @Override
    public RichiestaAcquisto getRichiestaAcquisto() {
        return richiestaAcquisto; 
    }

    @Override
    public void setRichiestaAcquisto(RichiestaAcquisto x) {
        this.richiestaAcquisto=x; 
    }

    @Override
    public SpecificaCategoria getSpecificaCategoria() {
        return specificaCategoria; 
    }

    @Override
    public void setSpecificaCategoria(SpecificaCategoria x) {
        this.specificaCategoria=x; 
    }

    @Override
    public String getValore() {
        return valore;
    }

    @Override
    public void setValore(String x) {
        this.valore=x; 
    }
    
}

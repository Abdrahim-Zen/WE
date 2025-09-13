/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.univaq.webmarket.data.model.impl;

import it.univaq.webmarket.data.model.Ordine;
import it.univaq.webmarket.data.model.ProdottoCandidato;
import it.univaq.webmarket.data.model.UtenteRegistrato;
import it.univaq.webmarket.framework.data.DataItemImpl;
import java.time.LocalDateTime;

/**
 *
 * @author abdrahimzeno
 */
public class OrdineImpl extends DataItemImpl<Integer> implements Ordine{
    private  LocalDateTime dataOrdine;
    private  String stato;
    private UtenteRegistrato utenteRegistrato;
    private ProdottoCandidato prodottoCandidato;
    
    public OrdineImpl(){
        super();
        dataOrdine=null;
        stato=null;
        utenteRegistrato=null;
        prodottoCandidato=null;
    }
    @Override
    public LocalDateTime getDataOrdine() {
       return dataOrdine; 
    }

    @Override
    public void setDataOrdine(LocalDateTime x) {
        this.dataOrdine=x; 
    }

    @Override
    public String getStato() {
        return stato; 
    }

    @Override
    public void setStato(String x) {
        this.stato=x; 
    }

    @Override
    public UtenteRegistrato getUtenteRegistrato() {
       return utenteRegistrato; 
    }

    @Override
    public void setUtenteRegistrato(UtenteRegistrato x) {
        this.utenteRegistrato=x; 
    }

    @Override
    public ProdottoCandidato getProdottoCandidato() {
       return prodottoCandidato; 
    }

    @Override
    public void setProdottoCandidato(ProdottoCandidato x) {
        this.prodottoCandidato=x; 
    }
    
}

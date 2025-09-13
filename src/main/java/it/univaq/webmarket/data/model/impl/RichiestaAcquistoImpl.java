/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.univaq.webmarket.data.model.impl;

import it.univaq.webmarket.data.model.Categoria;
import it.univaq.webmarket.data.model.RichiestaAcquisto;
import it.univaq.webmarket.data.model.UtenteRegistrato;
import it.univaq.webmarket.framework.data.DataItemImpl;
import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 *
 * @author abdrahimzeno
 */
public class RichiestaAcquistoImpl extends DataItemImpl<Integer> implements RichiestaAcquisto{
    private Categoria categoria;
    private UtenteRegistrato utenteRegistarto;
    private Double importo;
    private String stato;
    private Timestamp dataInserimento;
    private String note;
    private String valore;
    
    public RichiestaAcquistoImpl(){
        super();
        categoria=null;
        utenteRegistarto=null;
        importo=null;
        stato=null;
        dataInserimento=null;
    }
    

    @Override
    public Categoria getCategoria() {
        return categoria; 
    }

    @Override
    public void setCategorai(Categoria x) {
        this.categoria=x; 
    }

    @Override
    public UtenteRegistrato getUtenteRegistrato() {
        return utenteRegistarto; 
    }

    @Override
    public void setUtenteRegistrato(UtenteRegistrato x) {
        this.utenteRegistarto=x; 
    }

    @Override
    public Double getImporto() {
        return importo; 
    }

    @Override
    public void setImporto(Double x) {
        this.importo=x; 
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
    public Timestamp getDataInserimento() {
        return dataInserimento; 
    }

    @Override
    public void setDataInserimento(Timestamp x) {
        this.dataInserimento=x; 
    }

    @Override
    public String getNote() {
       return note; 
    }

    @Override
    public void setNote(String x) {
        this.note=x;} 

    @Override
    public void setValore(String x) {
       this.valore=x;
    }

    @Override
    public String getValore() {
       return valore; 
    }
    
}

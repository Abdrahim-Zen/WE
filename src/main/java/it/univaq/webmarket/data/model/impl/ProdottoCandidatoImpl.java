/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.univaq.webmarket.data.model.impl;

import it.univaq.webmarket.data.model.ProdottoCandidato;
import it.univaq.webmarket.data.model.RichiestaAcquisto;
import it.univaq.webmarket.data.model.TecnicoIncaricato;
import it.univaq.webmarket.framework.data.DataItemImpl;
import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 *
 * @author abdrahimzeno
 */
public class ProdottoCandidatoImpl extends DataItemImpl<Integer> implements ProdottoCandidato{
    private String nome;
    private String descrizione;
    private Double prezzo;
    private Timestamp  dataProposta;
    private TecnicoIncaricato tecnicoIncaricato;
    private RichiestaAcquisto richiestaAcquisto;
    
    public ProdottoCandidatoImpl(){
        super();
        nome=null;
        descrizione=null;
        prezzo=null;
        dataProposta=null;
        tecnicoIncaricato=null;
        richiestaAcquisto=null;
    }
    @Override
    public String getNome() {
        return nome; 
    }

    @Override
    public void setNome(String x) {
        this.nome=x; 
    }

    @Override
    public String getDescrizone() {
        return  descrizione; 
    }

    @Override
    public void setDescrizione(String x) {
        this.descrizione=x; 
    }

    @Override
    public Double getPrezzo() {
        return prezzo; 
    }

    @Override
    public void setPrezzo(Double x) {
        this.prezzo=x; 
    }

    @Override
    public Timestamp getDataProposta() {
        return dataProposta; 
    }

    @Override
    public void setDataProposta(Timestamp  x) {
        this.dataProposta=x; 
    }

    @Override
    public TecnicoIncaricato getTecnicoIncTecnico() {
       return tecnicoIncaricato; 
    }

    @Override
    public void setTecnicoIncaricato(TecnicoIncaricato x) {
        this.tecnicoIncaricato=x; 
    }

    @Override
    public RichiestaAcquisto getRichiestaAcquisto() {
        return richiestaAcquisto;
    }

    @Override
    public void setRichiestaAcquisto(RichiestaAcquisto x) {
        this.richiestaAcquisto=x; 
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.univaq.webmarket.data.model.impl;

import it.univaq.webmarket.data.model.Categoria;
import it.univaq.webmarket.data.model.Prodotto;
import it.univaq.webmarket.framework.data.DataItemImpl;

/**
 *
 * @author abdrahimzeno
 */
public class ProdottoImpl extends DataItemImpl<Integer> implements Prodotto{
    private Double prezzo;
    private Categoria categoria;
    private String descrizione;
    
    
    public ProdottoImpl(){
        super();
        prezzo=null;
        categoria=null;
        descrizione=null;
    }
    @Override
    public Double getPrezzo() {
        return prezzo; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void setPrezzo(Double x) {
        this.prezzo=x; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getDescrizione() {
        return descrizione ; 
    }

    @Override
    public void setDescrizione(String x) {
        this.descrizione=x; 
    }

    @Override
    public Categoria getCategoria() {
        return categoria; 
    }

    @Override
    public void setCategoria(Categoria x) {
        this.categoria=x;
    }

   
    
}

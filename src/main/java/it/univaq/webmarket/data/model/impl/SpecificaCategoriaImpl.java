/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.univaq.webmarket.data.model.impl;

import it.univaq.webmarket.data.model.Categoria;
import it.univaq.webmarket.data.model.SpecificaCategoria;
import it.univaq.webmarket.framework.data.DataItemImpl;

/**
 *
 * @author abdrahimzeno
 */
public class SpecificaCategoriaImpl extends DataItemImpl<Integer> implements SpecificaCategoria{
    private String nomeSpecifica;
    private Categoria categoria;

    public SpecificaCategoriaImpl() {
        super();
        nomeSpecifica=null;
        categoria=null;
    }
    
    
    @Override
    public String getNomeSpecifica() {
        return nomeSpecifica; 
    }

    @Override
    public void setNomeSpecifica(String x) {
        this.nomeSpecifica=x; 
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

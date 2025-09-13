/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.univaq.webmarket.data.model.impl;

import it.univaq.webmarket.data.model.Categoria;
import it.univaq.webmarket.framework.data.DataItemImpl;

/**
 *
 * @author abdrahimzeno
 */
public class CategoriaImpl extends DataItemImpl<Integer> implements Categoria {
    private String nome;

    public CategoriaImpl() {
        super();
        nome=null;
    }
    
    
    @Override
    public String getNomeCategoria() {
        return nome; 
    }

    @Override
    public void setNomeCategoria(String x) {
        this.nome=x; 
    }
    
}

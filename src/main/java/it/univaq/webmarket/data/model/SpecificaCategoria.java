/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package it.univaq.webmarket.data.model;

import it.univaq.webmarket.framework.data.DataItem;

/**
 *
 * @author abdrahimzeno
 */
public interface SpecificaCategoria extends DataItem<Integer>{
    String getNomeSpecifica();
    void setNomeSpecifica(String x);
    
    Categoria getCategoria();
    void setCategoria(Categoria x);
     
    
}

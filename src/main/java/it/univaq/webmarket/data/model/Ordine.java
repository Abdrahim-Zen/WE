/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package it.univaq.webmarket.data.model;

import it.univaq.webmarket.framework.data.DataItem;
import java.time.LocalDateTime;

/**
 *
 * @author abdrahimzeno
 */
public interface Ordine extends DataItem<Integer> {
    LocalDateTime getDataOrdine();
    void setDataOrdine(LocalDateTime x);
    
    String getStato();
    void setStato(String x);
    
    UtenteRegistrato getUtenteRegistrato();
    void setUtenteRegistrato(UtenteRegistrato x);
    
    ProdottoCandidato getProdottoCandidato();
    void setProdottoCandidato(ProdottoCandidato x);
    
    
}

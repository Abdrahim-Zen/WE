/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package it.univaq.webmarket.data.model;

import it.univaq.webmarket.framework.data.DataItem;
import java.sql.Timestamp;

/**
 *
 * @author abdrahimzeno
 */
public interface ProdottoCandidato extends DataItem<Integer>{
    String getNome();
    void setNome(String x);
    
    String getDescrizone();
    void setDescrizione(String x);
    
    Double getPrezzo();
    void setPrezzo(Double x);
    
    Timestamp  getDataProposta();
    void setDataProposta(Timestamp  x);
    
    TecnicoIncaricato getTecnicoIncTecnico();
    void setTecnicoIncaricato(TecnicoIncaricato x);
    
    RichiestaAcquisto getRichiestaAcquisto();
    void setRichiestaAcquisto(RichiestaAcquisto x);
    
    
    
}

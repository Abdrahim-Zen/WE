/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package it.univaq.webmarket.data.model;

import it.univaq.webmarket.framework.data.DataItem;
import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 *
 * @author abdrahimzeno
 */
public interface RichiestaAcquisto extends DataItem<Integer> {

    Categoria getCategoria();

    void setCategorai(Categoria x);

    UtenteRegistrato getUtenteRegistrato();

    void setUtenteRegistrato(UtenteRegistrato x);

    Double getImporto();

    void setImporto(Double x);

    String getStato();

    void setStato(String x);

    void setNote(String x);

    String getNote();

    Timestamp getDataInserimento();

    void setDataInserimento(Timestamp x);
    
    void setValore(String x);
    
    String getValore();

}

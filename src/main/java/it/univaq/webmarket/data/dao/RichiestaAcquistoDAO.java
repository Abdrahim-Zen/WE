/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package it.univaq.webmarket.data.dao;


import it.univaq.webmarket.data.model.RichiestaAcquisto;
import it.univaq.webmarket.framework.data.DataException;
import java.util.List;

/**
 *
 * @author abdrahimzeno
 */
public interface RichiestaAcquistoDAO {
 public void storeRichiestaAcquisto(RichiestaAcquisto richiesta) throws DataException;
 RichiestaAcquisto createRichiesta();
 public List<RichiestaAcquisto> getRichiesteByUtenteId(int utenteid);
}

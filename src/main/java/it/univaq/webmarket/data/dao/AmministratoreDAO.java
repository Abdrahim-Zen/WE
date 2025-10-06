/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package it.univaq.webmarket.data.dao;

import it.univaq.webmarket.data.model.Amministratore;
import it.univaq.webmarket.framework.data.DataException;

/**
 *
 * @author abrah
 */
public interface AmministratoreDAO {
    Amministratore getAmmistratorebyEmail(String x)throws DataException;
    Amministratore getAmministratorebyID(Integer x) throws DataException;
    
    
}

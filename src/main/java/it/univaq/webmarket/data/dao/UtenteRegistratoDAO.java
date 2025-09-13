/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package it.univaq.webmarket.data.dao;

import it.univaq.webmarket.data.model.UtenteRegistrato;
import it.univaq.webmarket.framework.data.DataException;

/**
 *
 * @author abdrahimzeno
 */
public interface UtenteRegistratoDAO {
    UtenteRegistrato getUtenteRegistrato(String n,String p)throws DataException;
    UtenteRegistrato getUtente(Integer id) throws DataException;
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package it.univaq.webmarket.data.dao;

import it.univaq.webmarket.data.model.Utente;
import it.univaq.webmarket.framework.data.DataException;
import java.util.List;

/**
 *
 * @author abdrahimzeno
 */
public interface UtenteDAO {
    Utente getUtente(int id) throws DataException;
    List<Utente> getUtentiCreatiDa(int idAmministratore) throws DataException;
    void addUtente(String email,String nome,String cognome,String password,Integer idAdmin);
 
}

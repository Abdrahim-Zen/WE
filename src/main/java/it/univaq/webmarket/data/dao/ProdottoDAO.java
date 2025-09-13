/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package it.univaq.webmarket.data.dao;

import it.univaq.webmarket.data.model.Prodotto;
import it.univaq.webmarket.framework.data.DataException;
import java.util.List;

/**
 *
 * @author abdrahimzeno
 */
public interface ProdottoDAO {
    Prodotto getProdottoByName(String nomeProdotto)throws DataException;
    Prodotto getProdottoByID(int id) throws DataException;

    public List<Prodotto> getProdottiByCategoriaID(int key)throws DataException;
}

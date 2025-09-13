/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package it.univaq.webmarket.data.dao;

import it.univaq.webmarket.data.model.Categoria;
import it.univaq.webmarket.framework.data.DataException;
import java.util.List;

/**
 *
 * @author abdrahimzeno
 */
public interface CategoriaDAO {
    List<Categoria> getAllCategorie() throws DataException;
    Categoria getCategoriabyID(int id)throws DataException;
}

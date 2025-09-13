/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package it.univaq.webmarket.data.dao;

import it.univaq.webmarket.data.model.SpecificaCategoria;
import it.univaq.webmarket.framework.data.DataException;
import java.util.List;

/**
 *
 * @author abdrahimzeno
 */
public interface SpecificaCategoriaDAO {
    List<SpecificaCategoria> getListSpecificaCategoria(int idCategoria)throws DataException;
    SpecificaCategoria getSpecificaCategoria(int id)throws DataException;
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package it.univaq.webmarket.data.dao;

import it.univaq.webmarket.data.model.ProdottoCandidato;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author abdrahimzeno
 */
public interface ProdottoCandidatoDAO {
    public List<ProdottoCandidato> getProdottiCandidatiByUserID(int x);
    public ProdottoCandidato getProdottoCandidatoByID(int x ) throws SQLException;
    public ProdottoCandidato createProdottoCandidato();
}

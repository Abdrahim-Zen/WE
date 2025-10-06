/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.univaq.webmarket.data.dao.impl;

import it.univaq.webmarket.data.dao.ProdottoDAO;
import it.univaq.webmarket.data.model.Prodotto;
import it.univaq.webmarket.data.model.impl.proxy.ProdottoProxy;
import it.univaq.webmarket.framework.data.DAO;
import it.univaq.webmarket.framework.data.DataException;
import it.univaq.webmarket.framework.data.DataLayer;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author abdrahimzeno
 */
public class ProdottoDAO_MySQL extends DAO implements ProdottoDAO {

    private PreparedStatement sProdottoByNome;
    private PreparedStatement sProdottoById;
    private PreparedStatement sProdottiByCategoria ;
    public ProdottoDAO_MySQL(DataLayer d) {
        super(d);
    }

    @Override
    public void init() {
        try {
            sProdottoByNome = connection.prepareStatement("SELECT ID_prodotto FROM prodotto WHERE descrizione = ?");
            sProdottoByNome = connection.prepareStatement("SELECT * FROM prodotto WHERE ID_prodotto = ?");
            sProdottiByCategoria = connection.prepareStatement("SELECT * FROM prodotto WHERE ID_categoria = ?");
        } catch (SQLException ex) {
            Logger.getLogger(ProdottoDAO_MySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    @Override
    public Prodotto getProdottoByName(String nomeProdotto)throws DataException {
        Prodotto x = null; 

        try {
            sProdottoByNome.setString(1, nomeProdotto);
            ResultSet rs = sProdottoByNome.executeQuery();
            if (rs.next()) {
                x = getProdottoByID(rs.getInt("ID_prodotto"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProdottoDAO_MySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return x;
    }

    @Override
    public Prodotto getProdottoByID(int id) throws DataException {
        Prodotto x = null;
        if (dataLayer.getCache().has(Prodotto.class, id)) {
            x = dataLayer.getCache().get(Prodotto.class, id);
        }else{
            try{
                sProdottoById.setInt(1,id);
                try(ResultSet rs =sProdottoById.executeQuery()){
                    if(rs.next()){
                        x=createProdotto(rs);
                        dataLayer.getCache().add(Prodotto.class, x);
                    }
                }
            }catch (SQLException ex) {
                throw new DataException("Unable to load user by ID", ex);
            }
        }
        return x;
    }
    private Prodotto createProdotto(ResultSet rs) throws DataException, SQLException{
        try{
            ProdottoProxy a = (ProdottoProxy) createProdotto();
            a.setCategoriaID(rs.getInt("ID_categoria"));
            a.setDescrizione(rs.getString("descrizione"));
            a.setPrezzo(rs.getDouble("prezzo"));
            return a;
        }catch (SQLException ex) {
            throw new DataException("Unable to create user object form ResultSet", ex);
        }
        
    }
    
    @Override
    public List<Prodotto> getProdottiByCategoriaID(int categoriaId) throws DataException {
    List<Prodotto> prodotti = new ArrayList<>();
    try {
        sProdottiByCategoria.setInt(1, categoriaId);
        ResultSet rs = sProdottiByCategoria.executeQuery();
            while (rs.next()) {
                Prodotto prodotto = createProdotto(rs);
                prodotti.add(prodotto);
                dataLayer.getCache().add(Prodotto.class, prodotto);
            }
        
    } catch (SQLException ex) {
        throw new DataException("Unable to load prodotti by categoria", ex);
    }
    return prodotti;
}
    
    public Prodotto createProdotto(){
        return new ProdottoProxy(getDataLayer());
    }

}


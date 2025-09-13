/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.univaq.webmarket.data.dao.impl;

import it.univaq.webmarket.data.dao.ProdottoCandidatoDAO;
import it.univaq.webmarket.data.model.ProdottoCandidato;
import it.univaq.webmarket.data.model.impl.proxy.ProdottoCandidatoProxy;
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
public class ProdottoCandidatoDAO_MySQL extends DAO implements ProdottoCandidatoDAO {

    PreparedStatement sProdottoByUtente;
    PreparedStatement sProdottoByID;
    public ProdottoCandidatoDAO_MySQL(DataLayer d) {
        super(d);
    }

    @Override
    public void init() throws DataException {
        super.init();
        try {
            sProdottoByUtente = connection.prepareStatement("SELECT p.ID, p.nome, p.descrizione, p.prezzo, "
                    + "p.ID_tecnico, p.ID_richiesta, p.data_proposta "
                    + "FROM prodottoCandidato p " + "JOIN richiestaAcquisto r ON p.ID_richiesta = r.ID "
                    + "WHERE r.ID_utente = ? ");
            
            sProdottoByID=connection.prepareStatement("SELECT * FROM prodottoCandidato WHERE ID=? ");
        } catch (SQLException ex) {
            Logger.getLogger(ProdottoCandidatoDAO_MySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<ProdottoCandidato> getProdottiCandidatiByUserID(int x) {
        List<ProdottoCandidato> prodottiCandidati = new ArrayList<> ();
        try {
            sProdottoByUtente.setInt(1, x);
            ResultSet rs = sProdottoByUtente.executeQuery();
            while(rs.next()){
                prodottiCandidati.add(getProdottoCandidatoByID(rs.getInt("ID")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProdottoCandidatoDAO_MySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return prodottiCandidati;
    }

    @Override
    public ProdottoCandidato getProdottoCandidatoByID(int x) throws SQLException {
        ProdottoCandidato prodotto=null;
        if(dataLayer.getCache().has(ProdottoCandidato.class, x)){
            prodotto=dataLayer.getCache().get(ProdottoCandidato.class, x);
            
        }else{
            sProdottoByID.setInt(1, x);
            ResultSet rs = sProdottoByID.executeQuery();
            if(rs.next()){
                prodotto=createProdottoCandidato(rs);
                dataLayer.getCache().add(ProdottoCandidato.class, prodotto);
            }
        }
        return prodotto;
    }

    private ProdottoCandidato createProdottoCandidato(ResultSet rs) throws SQLException {
        ProdottoCandidatoProxy prodotto = (ProdottoCandidatoProxy) createProdottoCandidato();
        prodotto.setKey(rs.getInt("ID"));
        prodotto.setDataProposta(rs.getTimestamp("data_proposta"));
        prodotto.setDescrizione(rs.getString("descrizione"));
        prodotto.setNome(rs.getString("nome"));
        prodotto.setPrezzo(rs.getDouble("prezzo"));
        prodotto.setRichiesta_key(rs.getInt("ID_richiesta"));
        prodotto.setTecnicoKey(rs.getInt("ID_tecnico"));
        return prodotto;
    }
    
    @Override
    public ProdottoCandidato createProdottoCandidato(){
        return new ProdottoCandidatoProxy(dataLayer);
    }

}
